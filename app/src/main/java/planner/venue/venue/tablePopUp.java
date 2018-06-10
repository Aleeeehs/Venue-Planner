package planner.venue.venue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class tablePopUp extends AppCompatActivity{

    Table table;
    TextView tableName, ReservedStatus;
    Button reserveButton, orderButton;
    boolean reserve;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablepopup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * 0.9), (int)(height * 0.9));

        tableName = findViewById(R.id.tableName);
        ReservedStatus = findViewById(R.id.ReservedTable);
        reserveButton = findViewById(R.id.ReserveButton);
        orderButton = findViewById(R.id.OrderToTable);

        String tableNumber = getIntent().getExtras().getString("Table Number");
        String reserved = getIntent().getExtras().getString("Table Avaliable");
        reserve = Boolean.parseBoolean(reserved);

        if(reserve) {
            ReservedStatus.setText("This table is reserved");

        }else{
            ReservedStatus.setText("This table is free");
        }


        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reserve){
                    ReservedStatus.setText("This table is free");
                    reserve = false;

                }else{
                    ReservedStatus.setText("This table is reserved");
                    reserve = true;
                }
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tablePopUp.this, displayMenu.class);
                startActivity(intent);

            }
        });


        tableName.setText("Table " + tableNumber);

    }

}
