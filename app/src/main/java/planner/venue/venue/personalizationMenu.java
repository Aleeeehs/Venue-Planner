package planner.venue.venue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;


public class personalizationMenu extends AppCompatActivity {
    //profile photo
    ImageView profilePhoto;
    private static final long START_TIME_IN_MILLIS = 600000;
    private Button buttonStartTimer, buttonStopTimer, menuView, tableView, reservationsView, mainMenuView;
    private boolean timerRunning;
    private long restoreMins;
    private Chronometer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profilePhoto = findViewById(R.id.profilePhoto);
        setContentView(R.layout.personalization);
        buttonStartTimer = findViewById(R.id.button_start_timer);
        buttonStopTimer = findViewById(R.id.button_stop_timer);
        menuView = findViewById(R.id.menuButton);
        tableView = findViewById(R.id.viewTablesButton);
        reservationsView = findViewById(R.id.reservationsButton);
        mainMenuView = findViewById(R.id.endButton);

        timer = findViewById(R.id.chronometer);

        buttonStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerRunning) {

                } else {
                    timer.setBase(SystemClock.elapsedRealtime());
                }
                startTimer();
            }

        });
        buttonStopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.stop();
                timer.setBase(SystemClock.elapsedRealtime());
            }
        });
        menuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(personalizationMenu.this, displayMenu.class);
                startActivity(intent);
            }
        });
        mainMenuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(personalizationMenu.this, mainMenu.class);
                startActivity(intent);
            }
        });
        tableView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(personalizationMenu.this, tableViewer.class);
                startActivity(intent);
            }
        });
        reservationsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(personalizationMenu.this, "Not available yet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startTimer() {
        Toast.makeText(personalizationMenu.this, "Clocked in", Toast.LENGTH_SHORT).show();
        timerRunning = true;
        timer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("restoreMins", restoreMins);
        editor.putBoolean("timerRunning", timerRunning);
        //editor.putLong("endTime", mEndTime);
        editor.apply();
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        restoreMins = prefs.getLong("restoreMins", START_TIME_IN_MILLIS);
        timerRunning = prefs.getBoolean("timerRunning", false);

    }
}


