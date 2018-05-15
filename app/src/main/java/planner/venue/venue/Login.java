package planner.venue.venue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    //Developed by Charlie Wall

    Database Helper = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onBtnClick(View v){
        if(v.getId() == R.id.btLogin){

            EditText nameUser = (EditText)findViewById(R.id.ptUsername);
            String uName = nameUser.getText().toString();
            EditText passCode = (EditText)findViewById(R.id.etPassword);
            String pWord = passCode.getText().toString();

            String Psword = Helper.searchPass(uName);

            if (pWord.equals(Psword)){
                Intent intentMenu = new Intent(Login.this, mainMenu.class);
                startActivity(intentMenu);
            }
            else{
                Toast passwordMsg = Toast.makeText(Login.this, "Username or password is incorrect!", Toast.LENGTH_SHORT);
                passwordMsg.show();
            }
        }

        if(v.getId() == R.id.tvRegister){
            Intent intentRego = new Intent(Login.this, Register.class);
            startActivity(intentRego);
        }

    }
}
