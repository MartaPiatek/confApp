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





public class AgendaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);






        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_agenda) {

            Intent myIntent = new Intent(AgendaActivity.this,AgendaActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_news) {

            Intent myIntent = new Intent(AgendaActivity.this,NewsActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_speakers) {
            Intent myIntent = new Intent(AgendaActivity.this,SpeakersActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_calendar) {

        } else if (id == R.id.nav_facebook) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/Students.Science.Conference/?ref=br_rs"));
            startActivity(browserIntent);

        }else if (id == R.id.nav_twitter) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/SSCPWr"));
            startActivity(browserIntent);

        }   else if (id == R.id.nav_help) {

        }else if (id == R.id.nav_maps) {

            Intent myIntent = new Intent(AgendaActivity.this,MapsActivity.class);
            startActivity(myIntent);

        }
        else if (id == R.id.nav_notes) {

            Intent myIntent = new Intent(AgendaActivity.this,NotesActivity.class);
            startActivity(myIntent);

        }
        else if (id == R.id.nav_notification) {

        }
        else if (id == R.id.nav_awards) {

            //  Intent myIntent = new Intent(MenuActivity.this,SpeakersActivity.class);
            //  startActivity(myIntent);

        }
        else if (id == R.id.nav_awards) {

            //  Intent myIntent = new Intent(MenuActivity.this,SpeakersActivity.class);
            //  startActivity(myIntent);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
