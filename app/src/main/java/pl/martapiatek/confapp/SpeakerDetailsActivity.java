package pl.martapiatek.confapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class SpeakerDetailsActivity extends Base2Activity {

    private TextView txtViewSpeakerName, txtViewSpeakerDescription;
    private String sTitle, sName, sDescription;
    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtViewSpeakerName = (TextView) findViewById(R.id.txtViewSpeakerName);
        txtViewSpeakerDescription = (TextView) findViewById(R.id.txtViewSpeakerDescription);

        Bundle bundle = getIntent().getExtras();

        sTitle = bundle.get("SPEAKER_TITLE").toString();
        sName = bundle.get("SPEAKER_NAME").toString();
        sDescription = bundle.get("SPEAKER_DESCRIPTION").toString();



        txtViewSpeakerName.setText(sName);
        //txt.setEnabled(false);

        txtViewSpeakerDescription.setText(sDescription);

        mListView = (ListView) findViewById(R.id.events_list_view);
        mListView.setDivider(null);
        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();




        //dodaj przykładowe dane
    //    insertSomeEvents();

        Cursor cursor = mDbAdapter.fetchEventBySpeakerName(sName);

        // z kolumn zdefiniowanych w bazie danych
        String[] from = new String[]{
                ConfAppDbAdapter.COL_EVENT_TITLE

        };

        // do identyfikatorów widoków w układzie graficznym
        int[] to = new int[]{

                R.id.row_notesTitle


        };

        mCursorAdapter = new ConfAppSimpleCursorAdapter(
                // kontekst
                SpeakerDetailsActivity.this,
                // układ graficzny wiersza
                R.layout.events_by_speaker_rows,
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

}
