package planner.venue.venue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mainMenu extends AppCompatActivity {

    Button tableView, menuView, adminView, personalView;

    TextView t1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        tableView = (Button)findViewById(R.id.viewTables);
        adminView = (Button)findViewById(R.id.adminMenuButton);
        menuView = (Button)findViewById(R.id.menuButton);
        personalView = (Button)findViewById(R.id.personalButton);

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

    }
}