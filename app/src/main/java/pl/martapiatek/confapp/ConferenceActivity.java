package pl.martapiatek.confapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ConferenceActivity extends AppCompatActivity {

    private Button btnSpeakers, btnEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSpeakers = (Button) findViewById(R.id.btnSpeakers);

        btnSpeakers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(),SpeakersActivity.class);
                startActivity(myIntent);
            }
        });


        btnEvents = (Button) findViewById(R.id.btnEvents);

        btnEvents.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),EventsActivity.class);
                startActivity(myIntent);
            }
        });



    }
}
