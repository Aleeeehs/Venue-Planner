package planner.venue.venue;

public class Item {

    int ID;
    double price;
    String name;

    Item(int ID, String name, double price){
        this.name = name;
        this.ID = ID;
        this.price = price;

    }

    public double getPrice(){
        return price;
    }

}
