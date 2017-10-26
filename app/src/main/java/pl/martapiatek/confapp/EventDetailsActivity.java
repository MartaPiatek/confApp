package pl.martapiatek.confapp;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventDetailsActivity extends AppCompatActivity {
    private TextView txtViewEventDate, txtViewEventTitle, txtViewEventLocation, txtViewEventSpeaker,
            txtViewEventDescription, txtViewNoteText;
    private String sTitle, sDate, sLocation, sDescription, sSpeaker;
    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private Button btnAddNote, btnSaveNote, btnCancel;
    private Dialog dialogNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        txtViewEventDate = (TextView) findViewById(R.id.txtViewEventDate);
        txtViewEventDescription = (TextView) findViewById(R.id.txtViewEventDescription);
        txtViewEventLocation = (TextView) findViewById(R.id.txtViewEventLocation);
        txtViewEventSpeaker = (TextView) findViewById(R.id.txtViewEventSpeaker);
        txtViewEventTitle = (TextView) findViewById(R.id.txtViewEventTitle);



        btnAddNote = (Button) findViewById(R.id.btnAddNote);

        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();

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

        dialogNote = new Dialog(EventDetailsActivity.this, R.style.Theme_AppCompat_Dialog_Alert);
        dialogNote.setContentView(R.layout.note);

        btnSaveNote = (Button) dialogNote.findViewById(R.id.btnSave);
        btnCancel = (Button) dialogNote.findViewById(R.id.btnCancel);
        txtViewNoteText = (TextView) dialogNote.findViewById(R.id.txtViewNoteText);

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                dialogNote.show();
            }
        });


        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Date curDate = new Date();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                String DateToStr = format.format(curDate);
                System.out.println(DateToStr);

                mDbAdapter.createNote(DateToStr, txtViewEventTitle.getText().toString(),
                        txtViewNoteText.getText().toString() );

                Toast.makeText(EventDetailsActivity.this, "Zapisano notatkę!",
                        Toast.LENGTH_LONG).show();

                dialogNote.dismiss();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                dialogNote.dismiss();
            }
        });

        //txt.setEnabled(false);


    }
}
