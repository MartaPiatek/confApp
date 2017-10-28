package pl.martapiatek.confapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConferenceActivity extends AppCompatActivity {

    private Button btnSpeakers, btnEvents, btnEventsByName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference);


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

        btnEventsByName = (Button) findViewById(R.id.btnEventsByName);

        btnEventsByName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),EventsByNameActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
