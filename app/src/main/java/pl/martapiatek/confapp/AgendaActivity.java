package pl.martapiatek.confapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import pl.martapiatek.confapp.domain.Event;


public class AgendaActivity extends Base2Activity {
    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
     //   this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
      //  this.getSupportActionBar().setTitle("Agenda");

      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



     //   toolbar.setEnabled(true);
      //  setSupportActionBar(toolbar);

    //    toolbar.setNavigationIcon(R.drawable.ic_hamburger);
    //    getSupportActionBar().setHomeButtonEnabled(true);




//

        mListView = (ListView) findViewById(R.id.agenda_list_view);
        mListView.setDivider(null);
        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();

        //dodaj przykładowe dane
      //  insertSomeSpeakers();

     //  Cursor cursor = mDbAdapter.fetchAllEvents();

        Cursor cursor = mDbAdapter.fetchAllDates();

        // z kolumn zdefiniowanych w bazie danych
        String[] from = new String[]{

                ConfAppDbAdapter.COL_EVENT_DATE
                //,
             //   ConfAppDbAdapter.COL_EVENT_LOCATION,
             //   ConfAppDbAdapter.COL_EVENT_TITLE,
             //   ConfAppDbAdapter.COL_EVENT_SPEAKER

        };

        // do identyfikatorów widoków w układzie graficznym
        int[] to = new int[]{
                R.id.row_title


        };

        mCursorAdapter = new ConfAppSimpleCursorAdapter(
                // kontekst
                AgendaActivity.this,
                // układ graficzny wiersza
                R.layout.agenda_rows,
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

                                                 Event event =  mDbAdapter.fetchEventById(getIdFromPosition(masterListPosition));
                                                 String eventDate = event.getDate();




                                                 Intent myIntent = new Intent(view.getContext(),EventsByDayActivity.class);
                                                 myIntent.putExtra("EVENT_DATE", event.getDate());

                                                 startActivity(myIntent);
                                             }
                                         }
        );

    } // onCreate




    private int getIdFromPosition(int nC) {
        return (int)mCursorAdapter.getItemId(nC);
    }






}
