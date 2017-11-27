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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Runnable {

    private Dialog splashDialog, dialog;
    private Handler handler;
    private Button btnData, btnCreateNotification;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showSplashScreen();
        handler = new Handler();
        AsyncTask.execute(this);


        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();


        btnData = (Button) findViewById(R.id.btnData);
        btnData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                //dodaj przykładowe dane
                insertSomeEvents();
                insertSomeNews();
                insertSomeSpeakers();

                //wyswietlanie zindywidualizowanego toasta
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));

                ImageView image = (ImageView) layout.findViewById(R.id.image);
                // image.setImageResource(R.drawable.android);
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("Załadowano dane");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM, 0, 30);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();

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

            Intent myIntent = new Intent(MenuActivity.this,AgendaActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_news) {

            Intent myIntent = new Intent(MenuActivity.this,NewsActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_speakers) {
            Intent myIntent = new Intent(MenuActivity.this,SpeakersActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_calendar) {

            Intent myIntent = new Intent(MenuActivity.this,CalendarActivity.class);
            startActivity(myIntent);

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

            Intent myIntent = new Intent(MenuActivity.this,MapsActivity.class);
            startActivity(myIntent);

        }
        else if (id == R.id.nav_notes) {

            Intent myIntent = new Intent(MenuActivity.this,NotesActivity.class);
            startActivity(myIntent);

        }

        else if (id == R.id.nav_awards) {

            Intent myIntent = new Intent(MenuActivity.this,AwardActivity.class);
            startActivity(myIntent);

        }
        else if (id == R.id.nav_aboutConference) {

              Intent myIntent = new Intent(MenuActivity.this,ConferenceActivity.class);
              startActivity(myIntent);

        }
        else if (id == R.id.nav_contact) {

              Intent myIntent = new Intent(MenuActivity.this,ContactActivity.class);
              startActivity(myIntent);

        }
        else if (id == R.id.nav_gallery) {

            Intent myIntent = new Intent(MenuActivity.this,GalleryActivity.class);
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

        Button btnYes =  dialog.findViewById(R.id.btnYes);

        btnYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });

        Button btnNo =  dialog.findViewById(R.id.btnNo);

        btnNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        //   dialog.setCancelable(false);
        dialog.show();

    }


    private void insertSomeEvents() {
        mDbAdapter.createEvent( "2017-11-10" , "B-2 aud. 100",
                "Usage of ICP Algorithm for Initial Alignment in B-Splines FFD Image " +
                        "Registration in Breast Cancer Radiotherapy Planning ",
                "Estimation of a resected tumor lodge localization after a breast cancer " +
                        "surgery is a demanding task for the radiotherapy planning. The image registration " +
                        "techniques can be used to improve the radiotherapy. The initial alignment of two volumes " +
                        "is an important aspect of medical image registration procedure. We propose usage of the " +
                        "iterative closest point in two different scenarios: as a initial alignment, replacing intensity " +
                        "based rigid registration and as a initial transform to speed-up traditional rigid registration " +
                        "process. Two versions of the algorithm are presented: a point matching between bone structures " +
                        "and a line matching between volume edges. The correctness and usefulness are evaluated using:" +
                        " a target registration error, comparison of the computation time and convergence ratios, and " +
                        "visual inspection. The results demonstrate that the usage of iterative closest point algorithm " +
                        "significantly improve the initial alignment process in terms of the computation time.",
                "Marek Wodzinski");


        mDbAdapter.createEvent( "2017-11-10" , "B-2 aud. 122",
                "Computer analysis of normal and pathological vocal folds oscillations from videolaryngostroboscopic images",
                "Videostroboscopy is a common technique used by phoniatricians for diagnosing vocal" +
                        " folds status by imaging their oscillations. Implementation of image processing methods " +
                        "allows to extract qualitative description and quantitative indices. Such an analysis approach" +
                        " allows to detect glottal pathological changes and monitor the voice quality. Presented analysis " +
                        "of the videostroboscopic sequences were carried for 12 individuals i.e. 6 patients with diagnosed " +
                        "vocal nodules and 6 normophonic individuals classified as a control group. Image pre-processing " +
                        "and image segmentation algorithms were applied to compute the glottal area waveform (GAW) and " +
                        "the glottovibragram during phonation and to build a novel representation of vocal folds oscillations " +
                        "which we called the glottocorrelogram. The obtained results confirm that computer analysis and new " +
                        "representations of the phonation process of the glottis can aid the phoniatricians in diagnosis of " +
                        "voice disorders.",
                "Bartosz Kopczyński");

        mDbAdapter.createEvent( "2017-11-11" , "B-2 aud. 100",
                "Optimal selection of wavelengths for estimation of oxy-, deoxy- hemoglobin and cytochrome-c-oxidase " +
                        "from time-resolved NIRS measurements  ",
                "We analyze broadband near-infrared spectroscopic measurements obtained from newborn piglets " +
                        "subjected to hypoxia-ischemia and we aim to identify optimal wavelength combinations for" +
                        " monitoring cerebral tissue chromophores. We implement an optimization routine based on the " +
                        "genetic algorithm to perform a heuristic search for discrete wavelength combinations that can " +
                        "provide accurate concentration information when benchmarked against the gold standard of 121 wavelengths. The results indicate that it is possible to significantly reduce the number of measurement wavelengths used in conjunction with spectroscopic algorithms and still achieve a high performance in estimating changes in concentrations of oxyhemoglobin, deoxyhemoglobin, and oxidized cytochrome c oxidase. While the use of a 3-wavelength combination leads to mean recovery errors of up to 10%, these errors drop to less than 4% with 4 or 5 wavelengths and to even less than 2% with 8 wavelengths.",
                "Aleh Sudakou");
/*
        mDbAdapter.createEvent( "2017-02-12" , "B-1 aud. 320",
                " ",
                "",
                "");

        mDbAdapter.createEvent( "" , "",
                " ",
                "",
                "");
*/
    }

    private void insertSomeNews() {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(Calendar.getInstance().getTime());


        mDbAdapter.createNews( date, "Zmiana sali prezentacji"
                ,"Zmiana sali prezentacji pt. \"Optimal selection of wavelengths for estimation of oxy-, " +
                        "deoxy- hemoglobin and cytochrome-c-oxidase from time-resolved NIRS measurements\"" ,
                        "\n Nowa sala B-2 aud. 111 ");


    }




    private void insertSomeSpeakers() {
        mDbAdapter.createSpeaker( "Bartosz Kopczyński",
                "Lodz University of Technology",
                "");
        mDbAdapter.createSpeaker( "Aleh Sudakou",
                "Nalecz Institute of Biocybernetics and Biomedical Engineering Polish Academy of Sciences",
                "");
        mDbAdapter.createSpeaker( "Marek Wodzinski",
                "AGH University of Science and Technology, Department of Measurement and Electronics",
                "");


    }



    public void createNotification(String eventName) {
        Intent intent = new Intent(this, MenuActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.splashpeach);

        Notification noti = new NotificationCompat.Builder(this)
                               .setContentTitle("Zbliżające się wydarzenie!")
                               .
        setContentText("Niebawem rozpocznie się  " + eventName )
                               .setSmallIcon(R.drawable.splashpeach)
                              .setLargeIcon(icon)
                                .setAutoCancel(true)
                                .setContentIntent(pIntent)
                                .build();



                                NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, noti);

    }

    @Override
    protected void onPause() {
        super.onPause();
        dismissSplashScreen();
    }

    private void showSplashScreen() {
        splashDialog = new Dialog(this, R.style.splash_screen);
        splashDialog.setContentView(R.layout.activity_splash);
        splashDialog.setCancelable(false);
        splashDialog.show();
    }

    private void dismissSplashScreen() {
        if (splashDialog != null) {
            splashDialog.dismiss();
            splashDialog = null;
        }
    }
    @Override
    public void run() {
        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    dismissSplashScreen();
                                }
                            }, 5000
        );
    }
}
