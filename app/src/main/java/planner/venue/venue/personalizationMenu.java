package planner.venue.venue;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;
import android.widget.ImageView;


public class personalizationMenu extends AppCompatActivity{

    ImageView profilePhoto;
    private Chronometer timeSinceClockIn;
    private long zero = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalization);
        profilePhoto = findViewById(R.id.profilePhoto);
        timeSinceClockIn = (Chronometer)findViewById(R.id.chronometer);
        startTime();
    }

    private void startTime()
    {
        if(zero == 0)
        {
            timeSinceClockIn.setBase(SystemClock.elapsedRealtime());
            timeSinceClockIn.start();
            zero +=1;
        }
        else
        {

        }
    }
}
