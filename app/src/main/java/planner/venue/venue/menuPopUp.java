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

public class menuPopUp extends AppCompatActivity{

    TextView foodName, foodDescription;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.5), (int) (height * 0.5));

        foodName = findViewById(R.id.FoodTitle);
        foodDescription = findViewById(R.id.instructions);
        String name = getIntent().getExtras().getString("Name");
        String description = getIntent().getExtras().getString("description");
        foodName.setText(name);
        foodDescription.setText(description);
    }
}
