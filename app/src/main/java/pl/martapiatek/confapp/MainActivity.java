package pl.martapiatek.confapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class MainActivity extends Base2Activity {

    private Button btnAgenda, btnMap, btnFacebook, btn_InfoConf, btnNews, btnNotes;
    private Dialog splashDialog, dialog;
    private Handler handler;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_agenda:
                            //mTextMessage.setText(R.string.title_home);

                           // Intent dash = new Intent(getApplicationContext(),AgendaActivity.class);
                           // startActivity(dash);
                            return true;

                        case R.id.nav_aboutConference:
                           // Intent dash2 = new Intent(getApplicationContext(),ConferenceActivity.class);
                          //  startActivity(dash2);
                            return true;

                    }
                    return false;
                }

            };

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame); //Remember this is the FrameLayout area within your activity_main.xml
      //   getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);

       // mTextMessage = (TextView) findViewById(R.id.message);
      //  BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
      //  navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);








       //         Intent myIntent = new Intent(view.getContext(),CalendarActivity.class);
         //       startActivity(myIntent);

/*
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, "Learn Android");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Home suit home");
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Download Examples");

// Setting dates
                GregorianCalendar calDate = new GregorianCalendar(2017, 11, 02);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        calDate.getTimeInMillis());
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        calDate.getTimeInMillis());

// make it a full day event
                intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

// make it a recurring Event
                intent.putExtra(CalendarContract.Events.RRULE, "FREQ=WEEKLY;COUNT=11;WKST=SU;BYDAY=TU,TH");

// Making it private and shown as busy
                intent.putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PRIVATE);
                intent.putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);

*/







    }




}
