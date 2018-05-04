package planner.venue.venue;

public class Table {
    int table_id;
    boolean avaliable;

    Table(int id, boolean avaliable){
        table_id = id;
        this.avaliable = avaliable;
    }

    int returnId(){
        return table_id;
    }


}
