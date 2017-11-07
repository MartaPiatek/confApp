package pl.martapiatek.confapp;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventDetailsActivity extends AppCompatActivity {
    private TextView txtViewEventDate, txtViewEventTitle, txtViewEventLocation, txtViewEventSpeaker,
            txtViewEventDescription, txtViewNoteText;
    private String sTitle, sDate, sLocation, sDescription, sSpeaker;
    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private Button btnAddNote, btnSaveNote, btnCancel, btnAddCalendar, getBtnAddCalendarGoogle;
    private Dialog dialogNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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

        getBtnAddCalendarGoogle = (Button) findViewById(R.id.btnAddCalendarGoogle);
        btnAddCalendar = (Button) findViewById(R.id.btnAddCalendar);
        btnSaveNote = (Button) dialogNote.findViewById(R.id.btnSave);
        btnCancel = (Button) dialogNote.findViewById(R.id.btnCancel);
        txtViewNoteText = (TextView) dialogNote.findViewById(R.id.txtViewNoteText);



        btnAddCalendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                mDbAdapter.createCalendarEvent(txtViewEventDate.getText().toString() ,
                        txtViewEventLocation.getText().toString(),
                        txtViewEventTitle.getText().toString());

                //wyswietlanie zindywidualizowanego toasta
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));

                ImageView image = (ImageView) layout.findViewById(R.id.image);
                // image.setImageResource(R.drawable.android);
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("Zapisano w terminarzu");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM, 0, 10);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();



            }
        });


        getBtnAddCalendarGoogle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {





                Intent intent = new Intent(Intent.ACTION_INSERT);
               // intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.setType("vnd.android.cursor.item/event");

                intent.putExtra(CalendarContract.Events.TITLE, txtViewEventTitle.getText().toString());
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, txtViewEventLocation.getText().toString());
             //   intent.putExtra(CalendarContract.Events.DESCRIPTION, "Download Examples");

                Date date = null;
                // Setting dates

               // String dtStart = "2017-10-28T22:03";
                String dtStart = txtViewEventDate.getText().toString();

               // SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

                SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    date = format.parse(dtStart);
                    System.out.println(date);
                    Log.d("DATA ", date.toString());
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        date.getTime());


// make it a full day event
                intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);



                // Making it private and shown as busy
                intent.putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PRIVATE);
                intent.putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);


                //Reminders
                intent.putExtra(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALARM);
                intent.putExtra(CalendarContract.Reminders.MINUTES, 3);


             //   startActivity(intent);







                //wyswietlanie zindywidualizowanego toasta
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));

                ImageView image = (ImageView) layout.findViewById(R.id.image);
                // image.setImageResource(R.drawable.android);
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("Zapisano w kalendarzu Google");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM, 0, 10);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();



            }
        });


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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {


            case android.R.id.home:
                Intent myIntent = new Intent(this,EventsByDayActivity.class);
                myIntent.putExtra("EVENT_DATE", sDate);
                startActivity(myIntent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
