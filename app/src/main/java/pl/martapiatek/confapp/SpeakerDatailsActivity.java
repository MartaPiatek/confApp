package pl.martapiatek.confapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class SpeakerDatailsActivity extends AppCompatActivity {

    private TextView txtViewSpeakerName, txtViewSpeakerDescription;
    private String sTitle, sFirstName, sLastName, sDescription, name;
    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_datails);

        txtViewSpeakerName = (TextView) findViewById(R.id.txtViewSpeakerName);
        txtViewSpeakerDescription = (TextView) findViewById(R.id.txtViewSpeakerDescription);

        Bundle bundle = getIntent().getExtras();

        sTitle = bundle.get("SPEAKER_TITLE").toString();
        sFirstName = bundle.get("SPEAKER_FIRST_NAME").toString();
        sLastName = bundle.get("SPEAKER_LAST_NAME").toString();
        sDescription = bundle.get("SPEAKER_DESCRIPTION").toString();

        name = sTitle + " " + sFirstName + " " + sLastName;

        txtViewSpeakerName.setText(name);
        //txt.setEnabled(false);

        txtViewSpeakerDescription.setText(sDescription);

        mListView = (ListView) findViewById(R.id.events_list_view);
        mListView.setDivider(null);
        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();


        ratingBar = (RatingBar) findViewById(R.id.ratingBar); // initiate a rating bar
        Float ratingNumber = ratingBar.getRating(); // get rating number from a rating bar


        //dodaj przykładowe dane
        insertSomeEvents();

        Cursor cursor = mDbAdapter.fetchEventBySpeakerName(sFirstName + " " + sLastName);

        // z kolumn zdefiniowanych w bazie danych
        String[] from = new String[]{
                ConfAppDbAdapter.COL_EVENT_DATE, ConfAppDbAdapter.COL_EVENT_LOCATION,
                ConfAppDbAdapter.COL_EVENT_TITLE, ConfAppDbAdapter.COL_EVENT_DESCRIPTION,
                ConfAppDbAdapter.COL_EVENT_SPEAKER

        };

        // do identyfikatorów widoków w układzie graficznym
        int[] to = new int[]{
                R.id.row_date,
                R.id.row_location,
                R.id.row_title,
                R.id.row_description,
                R.id.row_speakerName

        };

        mCursorAdapter = new ConfAppSimpleCursorAdapter(
                // kontekst
                SpeakerDatailsActivity.this,
                // układ graficzny wiersza
                R.layout.events_rows,
                // kursor
                cursor,
                // z kolumn zdefiniowanych w bazie danych
                from,
                // do identyfikatorów widoków w układzie graficznym
                to,
                // znacznik - nieużywany
                0);

        mListView.setAdapter(mCursorAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                             @Override
                                             public void onItemClick(AdapterView<?> parent, View view, final int masterListPosition, long id) {


                                                 //  Speaker speaker =  mDbAdapter.fetchSpeakerById(getIdFromPosition(masterListPosition));
//
                                                 //                                               Intent myIntent = new Intent(view.getContext(),SpeakerDatailsActivity.class);
                                                 //                                             myIntent.putExtra("SPEAKER_TITLE", speaker.getTitle());
                                                 //                                           myIntent.putExtra("SPEAKER_FIRST_NAME", speaker.getFirstName());
                                                 //                                         myIntent.putExtra("SPEAKER_LAST_NAME", speaker.getLastName());
                                                 //                                       myIntent.putExtra("SPEAKER_DESCRIPTION", speaker.getDescription());

                                                 //                                     startActivity(myIntent);
                                             }
                                         }
        );


    } // onCreate

    private int getIdFromPosition(int nC) {
        return (int)mCursorAdapter.getItemId(nC);
    }

    private void insertSomeEvents() {
        mDbAdapter.createEvent( "2017-02-10" , "Bud A-1", "Aaaaaaaaa", "Jakis opis",
                "Jan Kowalski");
        mDbAdapter.createEvent( "2017-09-09" , "Bud c-1", "Bbbbbbbbbbbbbb", "Jakis opis",
                "Adam Nowak");
        mDbAdapter.createEvent( "2017-12-12" , "Bud D-1", "Cccccccc", "Jakis opis",
                "Adam Nowak");

        mDbAdapter.createEvent( "2017-12-12" , "Bud D-2", "Dddddddddddd", "Jakis opis",
                "Adam Nowak");

        mDbAdapter.createEvent( "2017-12-12" , "Bud C-13", "Eeeeeeeeeeee", "Jakis opis",
                "Joanna Kamińska");

        mDbAdapter.createEvent( "2017-12-12" , "Bud A-12", "Ffffffff", "Jakis opis",
                "Jan Kowalski");

        mDbAdapter.createEvent( "2017-12-12" , "Bud D-1", "Gggggggggg", "Jakis opis",
                "Jan Kowalski");

    }

}
