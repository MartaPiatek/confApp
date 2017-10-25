package pl.martapiatek.confapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class EventDetailsActivity extends AppCompatActivity {
    private TextView txtViewEventDate, txtViewEventTitle, txtViewEventLocation, txtViewEventSpeaker, txtViewEventDescription;
    private String sTitle, sDate, sLocation, sDescription, sSpeaker;
    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        txtViewEventDate = (TextView) findViewById(R.id.txtViewEventDate);
        txtViewEventDescription = (TextView) findViewById(R.id.txtViewEventDescription);
        txtViewEventLocation = (TextView) findViewById(R.id.txtViewEventLocation);
        txtViewEventSpeaker = (TextView) findViewById(R.id.txtViewEventSpeaker);
        txtViewEventTitle = (TextView) findViewById(R.id.txtViewEventTitle);

        Bundle bundle = getIntent().getExtras();

        sTitle = bundle.get("EVENT_TITLE").toString();
        sDate = bundle.get("EVENT_DATE").toString();
        sLocation = bundle.get("EVENT_LOCATION").toString();
        sDescription = bundle.get("EVENT_DESCRIPTION").toString();
        sSpeaker = bundle.get("EVENT_SPEAKER").toString();


        txtViewEventDate.setText(sDate);
        txtViewEventTitle.setText(sTitle);
        txtViewEventLocation.setText(sLocation);
        txtViewEventSpeaker.setText(sSpeaker);
        txtViewEventDescription.setText(sDescription);


        //txt.setEnabled(false);


    }
}
