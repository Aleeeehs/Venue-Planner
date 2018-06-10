package planner.venue.venue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//designed by Matthew Ball
public class analysisIncome extends AppCompatActivity {


    private SharedPreferences nPreferences;
    private SharedPreferences.Editor nEditor;
    TextView TotalOrders, totalSales, AverageSale;
    Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income_analysis_page);
        returnButton = (Button)findViewById(R.id.returnButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(analysisIncome.this, mainMenu.class);
                startActivity(intent);
            }
        });

        nPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        nEditor = nPreferences.edit();
        if(!nPreferences.contains("totalCash")){
            nEditor.putInt("totalCash", 0);
            nEditor.commit();
        }


        if(!nPreferences.contains("totalOrders")){
            nEditor.putInt("totalOrders", 0);
            nEditor.commit();
        }

        int orders = (nPreferences.getInt("totalOrders",0));
        int Cash = (nPreferences.getInt("totalCash",0));


        TotalOrders = findViewById(R.id.TotalOrders);
        totalSales = findViewById(R.id.totalSales);
        AverageSale = findViewById(R.id.AverageSale);

        TotalOrders.setText("Total Number of Orders: " + orders );
        totalSales.setText("Total Earnings From Sales: " + Cash+ ".00");
        double av = 0;
        if(orders != 0){
            av = Cash / orders;

        }

        AverageSale.setText("Average Earnings Per Sale is: " + av);



    }

}
