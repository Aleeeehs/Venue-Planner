package planner.venue.venue;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the list of countries
    private final ArrayList<String>information;
    private final ArrayList<String> price;



    public CustomListAdapter(Activity context, ArrayList<String> informationParam, ArrayList<String> priceParam){

        super(context,R.layout.listview_row , informationParam);
        this.context = context;
        this.price = priceParam;
        this.information = informationParam;

    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);
        TextView informationField = (TextView)rowView.findViewById(R.id.information);
        TextView priceField = (TextView)rowView.findViewById(R.id.price);

        informationField.setText(information.get(position));
        priceField.setText(price.get(position));
        return rowView;
    }
}
