package planner.venue.venue;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class tableViewer extends AppCompatActivity {

    Button returnButton;
    ImageButton t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablelayout);

        String TableRawInfo = returnTableArray();
        String tableString[] = TableRawInfo.split("\\r?\\n");
        Table[] tableArray = createTableArray(tableString);

        t1 = (ImageButton)findViewById(R.id.t1);
        final Table sentTable = tableArray[0];
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tableViewer.this, tablePopUp.class);
                intent.putExtra("Table Number", Integer.toString(sentTable.table_id));
                intent.putExtra("Table Avaliable", Boolean.toString(sentTable.avaliable));
                startActivity(intent);
            }
        });


        returnButton = (Button)findViewById(R.id.returnHome);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tableViewer.this, mainMenu.class);
                startActivity(intent);
            }
        });

    }

    //This function returns the details of the table text file
    public String returnTableArray(){


        InputStream input;
        String text = "";
        try {
            InputStream is = getAssets().open("tables.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return text;

    }

    //turns the text document into array of tables
    public Table[] createTableArray(String[] tableString){
        Table[] listOfTables = new Table[16];

        int[] tabNumbers = new int[16];
        boolean[] tabReserved = new boolean[16];
        tabNumbers[0] = Integer.parseInt(tableString[0]);
        for(int i = 1; i< 32; i++){
            if((i%2) == 0){
                tabNumbers[i/2] = Integer.parseInt(tableString[i]);
            }
            else{
                int tabNumber = (int)((i/2) + 0.5);
                tabReserved[(tabNumber)] = Boolean.parseBoolean(tableString[i]);
            }
        }

        for(int i = 0; i < 16; i++){
            listOfTables[i] = new Table(tabNumbers[i], tabReserved[i]);
        }
        return listOfTables;
    }


}