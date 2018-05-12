package planner.venue.venue;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;
import android.widget.ImageView;


public class personalizationMenu extends AppCompatActivity{

    ImageView profilePhoto;
    private Chronometer timeSinceClockIn;
    private boolean running;

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
        if(!running)
        {
            timeSinceClockIn.setBase(SystemClock.elapsedRealtime());
            timeSinceClockIn.start();
            running = true;
        }
        else
        {

        }
    }
}
