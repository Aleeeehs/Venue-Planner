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

        String tableNumber = getIntent().getExtras().getString("Table Number");
        String reserved = getIntent().getExtras().getString("Table Avaliable");
        boolean reserve = Boolean.parseBoolean(reserved);
        System.out.println(reserve);


        ReservedStatus.setText("This table is free");




        tableName.setText("This is Table " + tableNumber);

    }

}
