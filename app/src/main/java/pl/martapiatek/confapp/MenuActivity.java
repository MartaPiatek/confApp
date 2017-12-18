package pl.martapiatek.confapp;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.NotificationCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import pl.martapiatek.confapp.repository.EventRepository;
import pl.martapiatek.confapp.repository.SpeakerRepository;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Dialog dialog;
    private Button btnData, btnCreateNotification;
    private ImageButton btnFacebook, btnTwitter, btnAgenda;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;

    private EventRepository eventRepository;
    private SpeakerRepository speakerRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      // mDbAdapter = new ConfAppDbAdapter(this);
     //   mDbAdapter.open();


        eventRepository = new EventRepository(MenuActivity.this);
        speakerRepository = new SpeakerRepository(MenuActivity.this);

        btnFacebook = (ImageButton) findViewById(R.id.btnFacobook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/Students.Science.Conference/?ref=br_rs"));
                startActivity(browserIntent);
            }
        });

        btnTwitter = (ImageButton) findViewById(R.id.btnTwitter);
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/SSCPWr"));
                startActivity(browserIntent);
            }
        });

        btnAgenda = (ImageButton) findViewById(R.id.btnAgenda);
        btnAgenda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent myIntent = new Intent(MenuActivity.this, AgendaActivity.class);
                startActivity(myIntent);
            }
        });

        btnData = (Button) findViewById(R.id.btnData);
        btnData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {



             mDbAdapter= eventRepository.openDb();

                   eventRepository.insertEvents(mDbAdapter);

                   speakerRepository.insertSpeakers(mDbAdapter);



                Toast.makeText(getApplicationContext(), "Załadowano dane",
                        Toast.LENGTH_LONG).show();

            }
        });

        btnCreateNotification = (Button) findViewById(R.id.btnCreateNotification);
        btnCreateNotification.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                createNotification("Computer analysis of normal and pathological vocal folds oscillations from videolaryngostroboscopic images");


            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_hamburger);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /*    @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    */
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

//TODO zrobić 2 warianty językowe PL i EN
            //   public void changeLanguage(String languageToLoad) {
            //for language change
            String languageToLoad = "en"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
            this.setContentView(R.layout.activity_menu);

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

            Intent myIntent = new Intent(MenuActivity.this, AgendaActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_news) {

            Intent myIntent = new Intent(MenuActivity.this, NewsActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_speakers) {
            Intent myIntent = new Intent(MenuActivity.this, SpeakersActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_calendar) {

            Intent myIntent = new Intent(MenuActivity.this, CalendarActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_facebook) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/Students.Science.Conference/?ref=br_rs"));
            startActivity(browserIntent);

        } else if (id == R.id.nav_twitter) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/SSCPWr"));
            startActivity(browserIntent);

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_maps) {

            Intent myIntent = new Intent(MenuActivity.this, MapsActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_notes) {

            Intent myIntent = new Intent(MenuActivity.this, NotesActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_awards) {

            Intent myIntent = new Intent(MenuActivity.this, AwardActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_aboutConference) {

            Intent myIntent = new Intent(MenuActivity.this, ConferenceActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_contact) {

            Intent myIntent = new Intent(MenuActivity.this, ContactActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_gallery) {

            Intent myIntent = new Intent(MenuActivity.this, GalleryActivity.class);
            startActivity(myIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {

        dialog = new Dialog(this, R.style.Theme_AppCompat_Dialog_Alert);
        dialog.setContentView(R.layout.dialog);

        Button btnYes = dialog.findViewById(R.id.btnYes);

        btnYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });

        Button btnNo = dialog.findViewById(R.id.btnNo);

        btnNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        //   dialog.setCancelable(false);
        dialog.show();

    }



    private void insertSomeNews() {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(Calendar.getInstance().getTime());


        mDbAdapter.createNews(date, "Zmiana sali prezentacji"
                , "Zmiana sali prezentacji pt. \"Optimal selection of wavelengths for estimation of oxy-, " +
                        "deoxy- hemoglobin and cytochrome-c-oxidase from time-resolved NIRS measurements\"",
                "\n Nowa sala B-2 aud. 111 ");


    }





    public void createNotification(String eventName) {
        Intent intent = new Intent(this, MenuActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.splashpeach);

        Notification noti = new NotificationCompat.Builder(this)
                .setContentTitle("Zbliżające się wydarzenie!")
                .
                        setContentText("Niebawem rozpocznie się  " + eventName)
                .setSmallIcon(R.drawable.splashpeach)
                .setLargeIcon(icon)
                .setAutoCancel(true)
                .setContentIntent(pIntent)
                .build();


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, noti);

    }
}
