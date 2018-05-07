package planner.venue.venue;

import org.junit.Test;

import static org.junit.Assert.*;


//designed by Matthew Ball for testing menuControllerClass
public class displayMenuControllerTest {

    //This is the info about the menu that is passed to the menuController on creation
    String rawMenuInfo = "0 Soft_Drink 4.00 1 Chicken_Burger 10.00 2 Beef_Burger 10.00 3 Steak 10.00 4 Chicken_Nuggets 8.00 5 Fish_and_Chips 12.00 6 Fries 5.00";




    @Test

    //test to see if the correct name and price of an item added to the trolly
    public void testName(){
        displayMenuController d1 = new displayMenuController(rawMenuInfo);
        d1.itemButtonPress(0);
        assertEquals(d1.trolly.get(0), "Soft Drink");
        assertEquals(d1.trolly_price.get(0), "4.0");
    }

    //test to check that adding mulitple orders puts them into the list in order, and calculates a correct price
    @Test
    public void testAddToTrolly(){
        displayMenuController d1 = new displayMenuController(rawMenuInfo);
        d1.itemButtonPress(0);
        d1.itemButtonPress(6);
        d1.itemButtonPress(4);
        assertEquals(d1.totalPrice, 17.0, 2);
        assertEquals(d1.trolly.get(2), "Chicken Nuggets");

    }



    @Test
    public void testRestartOrder(){
        displayMenuController d1 = new displayMenuController(rawMenuInfo);
        d1.itemButtonPress(0);
        d1.restartOrder();
        assertEquals(d1.trolly.size(), 0);
    }

}