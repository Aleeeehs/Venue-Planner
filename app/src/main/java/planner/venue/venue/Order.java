package planner.venue.venue;

public class Order {
    int OrderNumber;
    int tableNumber;
    Item[] selectedItems;

    Order(int tableNumber, Item[] selectedItems){
        this.tableNumber = tableNumber;
        this.selectedItems = selectedItems;
    }

}
