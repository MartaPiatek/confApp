package pl.martapiatek.confapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;





public class AgendaActivity extends AppCompatActivity {
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
                R.id.row_agendaDay


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
