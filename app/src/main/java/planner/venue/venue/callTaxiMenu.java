package planner.venue.venue;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class callTaxiMenu extends AppCompatActivity {
    Button tableView, menuView, adminView, personalView, callbutton, reservationsView, mainMenuView;

    TextView t1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_taxi);

        tableView = (Button)findViewById(R.id.viewTables);
        adminView = (Button)findViewById(R.id.adminMenuButton);
        menuView = (Button)findViewById(R.id.menuButton);
        personalView = (Button)findViewById(R.id.personalButton);
        callbutton= (Button)findViewById(R.id.callbutton);
        reservationsView = (Button) findViewById(R.id.reservationsButton);
        mainMenuView = findViewById(R.id.endButton);

        tableView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(callTaxiMenu.this, tableViewer.class);
                startActivity(intent);
            }
        });

        adminView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(callTaxiMenu.this, administrationMenu.class);
                startActivity(intent);
            }
        });

        mainMenuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(callTaxiMenu.this, mainMenu.class);
                startActivity(intent);
            }
        });

        menuView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(callTaxiMenu.this, displayMenu.class);
                startActivity(intent);
            }
        });

        personalView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(callTaxiMenu.this, personalizationMenu.class);
                startActivity(intent);
            }
        });
        reservationsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(callTaxiMenu.this, "Not available yet", Toast.LENGTH_SHORT).show();
            }
        });


        callbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri number = Uri.parse("tel:123456789");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });

    }

}
