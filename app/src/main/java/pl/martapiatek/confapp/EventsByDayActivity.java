package pl.martapiatek.confapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import pl.martapiatek.confapp.domain.Event;

public class EventsByDayActivity extends AppCompatActivity {

    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = (ListView) findViewById(R.id.agenda_list_view);
        mListView.setDivider(null);
        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();

        Bundle bundle = getIntent().getExtras();


        final String eventDate = bundle.get("EVENT_DATE").toString();

        Cursor mcursor =  mDbAdapter.fetchEventByDate(eventDate);
//
        // z kolumn zdefiniowanych w bazie danych
        String[] from = new String[]{

                ConfAppDbAdapter.COL_EVENT_DATE
                ,
                ConfAppDbAdapter.COL_EVENT_LOCATION,
                ConfAppDbAdapter.COL_EVENT_TITLE,
                ConfAppDbAdapter.COL_EVENT_SPEAKER

        };

        // do identyfikatorów widoków w układzie graficznym
        int[] to = new int[]{
                R.id.row_title,
                R.id.row_date,
                R.id.row_location


        };

        mCursorAdapter = new ConfAppSimpleCursorAdapter(
                // kontekst
                EventsByDayActivity.this,
                // układ graficzny wiersza
                R.layout.event_day_rows,
                // kursor
                mcursor,
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

                                                   Event event =  mDbAdapter.fetchEventById(getIdFromPosition(masterListPosition));
//
                                                                                                Intent myIntent = new Intent(view.getContext(),EventDetailsActivity.class);
                                                                                              myIntent.putExtra("EVENT_TITLE", event.getTitle());
                                                                                            myIntent.putExtra("EVENT_DATE", event.getDate());
                                                                                          myIntent.putExtra("EVENT_LOCATION", event.getLocation());
                                                                                         myIntent.putExtra("EVENT_DESCRIPTION", event.getDescription());
                                                                                        myIntent.putExtra("EVENT_SPEAKER", event.getSpeakerName());

                                                                                      startActivity(myIntent);

                                             }
                                         }
        );

    } // onCreate

    private int getIdFromPosition(int nC) {
        return (int)mCursorAdapter.getItemId(nC);
    }




}

