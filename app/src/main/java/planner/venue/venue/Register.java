package planner.venue.venue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    //Developed by Charlie Wall

    Database Helper = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onButtonClick(View v) {
        EditText nameFirst = (EditText) findViewById(R.id.etFirstName);
        EditText nameLast = (EditText) findViewById(R.id.etLastName);
        EditText nameUser = (EditText) findViewById(R.id.etUname);
        EditText passwordFirst = (EditText) findViewById(R.id.etPword);
        EditText passwordSecond = (EditText) findViewById(R.id.etRepword);
        Button regButton = (Button) findViewById(R.id.btRegister);

        String firstName = nameFirst.getText().toString();
        String lastName = nameLast.getText().toString();
        String userName = nameUser.getText().toString();
        String passwordOne = passwordFirst.getText().toString();
        String passwordTwo = passwordSecond.getText().toString();

        if (!passwordOne.equals(passwordTwo)){
            Toast msgPassword = Toast.makeText(Register.this, "Passwords do not match!", Toast.LENGTH_SHORT);
            msgPassword.show();

        }
        else{
            UserDetails userDets = new UserDetails();

            userDets.setfName(firstName);
            userDets.setlName(lastName);
            userDets.setusrName(userName);
            userDets.setPswrd(passwordOne);

            Helper.insertContact(userDets);

            Intent intentLogin = new Intent(Register.this, Login.class);
            startActivity(intentLogin);

        }

    }
}
