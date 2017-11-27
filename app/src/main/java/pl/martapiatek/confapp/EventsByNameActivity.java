package pl.martapiatek.confapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class EventsByNameActivity extends AppCompatActivity {

    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        mListView = (ListView) findViewById(R.id.events_list_view);
        mListView.setDivider(null);
        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();

        //dodaj przykładowe dane
        insertSomeEvents();

        Cursor cursor = mDbAdapter.fetchEventBySpeakerName("Jan Kowalski");

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
                EventsByNameActivity.this,
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
                                                 //                                               Intent myIntent = new Intent(view.getContext(),SpeakerDetailsActivity.class);
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
