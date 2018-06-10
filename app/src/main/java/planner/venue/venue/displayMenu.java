package planner.venue.venue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;

//Designed by Matthew Ball
public class displayMenu extends AppCompatActivity {

    final int menu_size = 7;
    double totalPrice;
    displayMenuController m1;

    Button mainMenuButton, restartOrderButton, payCashButton, tableView;
    Button chickenBurgerButton, Soft_Drink, Beef_Burger,Steak, Chicken_Nuggets, Fish_and_Chips, Fries, taxiButton;
    TextView totalTrollyPrice;
    private SharedPreferences nPreferences;
    private SharedPreferences.Editor nEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulayout);
        String StringRawInfo = returnMenuString();
        m1 = new displayMenuController(StringRawInfo);

        ListView names = findViewById(R.id.ItemsInTrolly);
        final CustomListAdapter trollyList = new CustomListAdapter(this, m1.returnTrolly(), m1.returnTrollyPrice());

        names.setAdapter(trollyList);

        mainMenuButton = (Button)findViewById(R.id.endButton);
        restartOrderButton = (Button)findViewById(R.id.RestartOrderButton);
        payCashButton = (Button)findViewById(R.id.PayCashButton);
        taxiButton = (Button)findViewById(R.id.taxiButton);
        tableView = (Button)findViewById(R.id.viewTables);


        chickenBurgerButton = (Button)findViewById(R.id.chickenBurgerButton);
        Soft_Drink  = (Button)findViewById(R.id.SoftDrinkButton);
        Beef_Burger = (Button)findViewById(R.id.BeefBurgerButton);
        Steak = (Button)findViewById(R.id.SteakButton);
        Chicken_Nuggets = (Button)findViewById(R.id.ChickenNuggetsButton);
        Fish_and_Chips = (Button)findViewById(R.id.FishChipsButton);
        Fries = (Button)findViewById(R.id.friesButton);


        totalTrollyPrice = (TextView)findViewById(R.id.totalTrollyPrice);

        mainMenuButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(displayMenu.this, mainMenu.class);
                startActivity(intent);
            }
        });

        taxiButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(displayMenu.this, callTaxiMenu.class);
                startActivity(intent);
            }
        });
        tableView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(displayMenu.this, tableViewer.class);
                startActivity(intent);
            }
        });





        Soft_Drink.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

               m1.itemButtonPress(0);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice())+ "0");


            }
        });


        Soft_Drink.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(displayMenu.this, menuPopUp.class);
                intent.putExtra("Name", "Soft Drink");
                intent.putExtra("description", "A carbonated drink\n Glutten Free: Yes\n Vegan: Yes");
                startActivity(intent);
                return false;
            }

        });

        chickenBurgerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(1);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice()) +"0");


            }
        });

        chickenBurgerButton.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(displayMenu.this, menuPopUp.class);
                intent.putExtra("Name", "Chicken Burger");
                intent.putExtra("description", "A burger containing: \n Chicken Patty\nCranberry Sauce\nCheese\nLettuce\n Glutten Free: No\n Vegan: No");
                startActivity(intent);
                return false;
            }

        });

        Beef_Burger.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(2);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice())+"0");


            }
        });

        Beef_Burger.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(displayMenu.this, menuPopUp.class);
                intent.putExtra("Name", "Beef Burger");
                intent.putExtra("description", "A burger containing: \n Beef Patty\nBBQ Sauce\nCheese\nLettuce\n Glutten Free: No\n Vegan: No");
                startActivity(intent);
                return false;
            }

        });

        Steak.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(3);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice())+"0");


            }
        });

        Steak.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(displayMenu.this, menuPopUp.class);
                intent.putExtra("Name", "Steak");
                intent.putExtra("description", "A steak with mushroom sauce \n Glutten Free: No\n Vegan: No");
                startActivity(intent);
                return false;
            }

        });

        Chicken_Nuggets.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(4);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice())+"0");


            }
        });

        Chicken_Nuggets.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(displayMenu.this, menuPopUp.class);
                intent.putExtra("Name", "Chicken Nuggets");
                intent.putExtra("description", "10 chicken nuggets containg Sweet and Sour Sauce \n Glutten Free: No\n Vegan: No");
                startActivity(intent);
                return false;
            }

        });

        Fish_and_Chips.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(5);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice())+"0");


            }
        });

        Fish_and_Chips.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(displayMenu.this, menuPopUp.class);
                intent.putExtra("Name", "Fish and Chips");
                intent.putExtra("description", "Beer battered Fish with a side of fries \n Glutten Free: No\n Vegan: No");
                startActivity(intent);
                return false;
            }

        });

        Fries.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(6);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice())+"0");


            }
        });

        Fries.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(displayMenu.this, menuPopUp.class);
                intent.putExtra("Name", "Fries");
                intent.putExtra("description", "A side of fries \n Glutten Free: Yes\n Vegan: Yes");
                startActivity(intent);
                return false;
            }

        });

        restartOrderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                m1.restartOrder();
                trollyList.clear();
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice())+"0");


            }
        });

        payCashButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(m1.totalPrice != 0) {
                    saveToPreference(m1.totalPrice);
                }
                m1.restartOrder();
                trollyList.clear();
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice())+"0");

            }
        });





    }



    public void saveToPreference(double price){
        nPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        nEditor = nPreferences.edit();
        if(!nPreferences.contains("totalCash")){
            nEditor.putInt("totalCash", 0);
            nEditor.commit();
        }
        int Cash = (int)(price);
        Cash = Cash + (nPreferences.getInt("totalCash",0));
        nEditor.putInt("totalCash", Cash);
        nEditor.commit();

        if(!nPreferences.contains("totalOrders")){
            nEditor.putInt("totalOrders", 0);
            nEditor.commit();
        }
        int orders = 1;
        orders = orders + (nPreferences.getInt("totalOrders",0));
        nEditor.putInt("totalOrders", orders);
        nEditor.commit();

    }
    public String returnMenuString(){


        String text = "";
        try {
            InputStream is = getAssets().open("menu.txt");
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


    public void addToInvoices(ArrayList<String> trolly) throws IOException {
        //TODO



    }
}
