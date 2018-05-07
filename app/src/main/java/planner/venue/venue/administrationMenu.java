package planner.venue.venue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class administrationMenu extends AppCompatActivity{

    Button returnButton;
    Button createStaffButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administration);

        returnButton = (Button)findViewById(R.id.returnButton);
        createStaffButton  = (Button)findViewById(R.id.createStaffButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(administrationMenu.this, mainMenu.class);
                startActivity(intent);
            }
        });

        createStaffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(administrationMenu.this, addStaffMenu.class);
                startActivity(intent);
            }
        });
    }
}
