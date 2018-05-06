package planner.venue.venue;

public class Order {

    int price;
    String[] selectedItems;

    Order(String[] selectedItems, int price){
        this.price = price;
        this.selectedItems = selectedItems;
    }

}
