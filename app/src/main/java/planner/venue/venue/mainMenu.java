package planner.venue.venue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class mainMenu extends AppCompatActivity {

    Button tableView, menuView, adminView, personalView, taxiButton, reservationsView;

    TextView t1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        tableView = (Button)findViewById(R.id.viewTables);
        adminView = (Button)findViewById(R.id.adminMenuButton);
        menuView = (Button)findViewById(R.id.menuButton);
        personalView = (Button)findViewById(R.id.personalButton);
        taxiButton = (Button)findViewById(R.id.taxiButton);
        reservationsView = findViewById(R.id.reservationsButton);

        tableView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainMenu.this, tableViewer.class);
                startActivity(intent);
            }
        });

        adminView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainMenu.this, administrationMenu.class);
                startActivity(intent);
            }
        });

        menuView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mainMenu.this, displayMenu.class);
                startActivity(intent);
            }
        });

        personalView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mainMenu.this, personalizationMenu.class);
                startActivity(intent);
            }
        });

        taxiButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mainMenu.this, callTaxiMenu.class);
                startActivity(intent);
            }
        });

        reservationsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainMenu.this, "Not available yet", Toast.LENGTH_SHORT).show();
            }
        });
    }


}