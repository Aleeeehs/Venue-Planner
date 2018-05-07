package planner.venue.venue;

import android.content.res.AssetManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class displayMenuController {
    final int menu_size = 7;
    double totalPrice;
    final ArrayList<String> trolly = new ArrayList<String>();
    final ArrayList<String> trolly_price = new ArrayList<String>();
    final ArrayList<Item> orderTrolly = new ArrayList<Item>();
    final Item[] listOfItems;

    public displayMenuController(String rawMenuInfo){
        totalPrice = 0;
        String StringRawInfo = rawMenuInfo;
        String menuString[] = StringRawInfo.split("\\s+");
        listOfItems = createItemArray(menuString);


    }



    public ArrayList<String> returnTrolly(){
        return trolly;
    }

    public ArrayList<String> returnTrollyPrice(){
        return trolly_price;
    }
    public ArrayList<Item> returnOrderTrolly(){
        return orderTrolly;
    }


    public double itemButtonPress(int menuSpot){
        trolly.add(listOfItems[menuSpot].name);
        trolly_price.add(Double.toString(listOfItems[menuSpot].price));

        orderTrolly.add(listOfItems[menuSpot]);
        return setPrice();
    }


    public double setPrice(){
        totalPrice = 0;
        for(int i = 0; i < orderTrolly.size(); i++){
            totalPrice += orderTrolly.get(i).getPrice();

        }

        return totalPrice;


    }

    public double restartOrder(){
        orderTrolly.clear();
        trolly_price.clear();
        return 0;
    }




    public Item[] createItemArray(String[] menuString){
        Item[] listOfItems = new Item[menu_size];

        int[] itemNumbers = new int[menu_size];
        String[] itemName = new String[menu_size];
        Double[] itemPrice = new Double[menu_size];

        int total_items = menu_size * 3;
        for(int i = 0; i < menu_size; i++){
            int j = i *3;
            itemNumbers[i] = Integer.parseInt(menuString[j]);
            itemName[i] = menuString[j+1];
            itemPrice[i] = Double.parseDouble(menuString[j+2]);


        }

        for(int i = 0; i<menu_size; i++){

            itemName[i] = itemName[i].replaceAll("_", " ");
        }

        for(int i = 0; i < menu_size; i++){
            listOfItems[i] = new Item(itemNumbers[i], itemName[i], itemPrice[i]);
        }



        return listOfItems;
    }
}
