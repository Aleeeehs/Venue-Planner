package planner.venue.venue;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;


public class personalizationMenu extends AppCompatActivity {
    //profile photo
    ImageView profilePhoto;

    private Button buttonStartTimer, buttonStopTimer;
    private boolean timerRunning = true;
    private Chronometer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profilePhoto = findViewById(R.id.profilePhoto);
        setContentView(R.layout.personalization);;
        buttonStartTimer = findViewById(R.id.button_start_timer);
        buttonStopTimer =  findViewById(R.id.button_stop_timer);
        timer = findViewById(R.id.chronometer);

        buttonStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timerRunning)
                {
                    timer.setBase(SystemClock.elapsedRealtime());
                }
                else
                {

                }
                timer.start();
            }

        });

        buttonStopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.stop();
                timer.setBase(SystemClock.elapsedRealtime());
            }
        });
    }

}
