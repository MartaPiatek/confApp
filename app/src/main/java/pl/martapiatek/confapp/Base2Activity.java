package pl.martapiatek.confapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class Base2Activity extends AppCompatActivity {

    public Toolbar toolbar;

    ActionBarDrawerToggle mDrawerToggle;
    Context context;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected boolean useToolbar() {
        return true;
    }


    @Override
    public void setContentView(int layoutResID) {
        context = this;

        DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.drawer_main, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.frame);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

        super.setContentView(fullView);
        toolbar = (Toolbar) fullView.findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("MENU");
        toolbar.setTitle("");
        this.getSupportActionBar().setElevation(0);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorFont));
        //this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (useToolbar()) {
            setSupportActionBar(toolbar);
            setTitle("Places Near Me");
         //   mDrawerToggle.setDrawerIndicatorEnabled(false);
         //   this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        } else {
            toolbar.setVisibility(View.GONE);
        }

      //  getSupportActionBar().setHomeButtonEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                drawerLayout.closeDrawers();


                switch (menuItem.getItemId()) {
                    case R.id.nav_aboutConference:

                        startActivity(new Intent(getApplicationContext(),ConferenceActivity.class));
                        return true;
                    case R.id.nav_agenda:

                        startActivity(new Intent (getApplicationContext(),AgendaActivity.class));
                        return true;

                    case R.id.nav_awards:

                        startActivity(new Intent (getApplicationContext(),AwardActivity.class));
                        return true;
                    case R.id.nav_calendar:

                        startActivity(new Intent (getApplicationContext(),CalendarActivity.class));
                        return true;

                    case R.id.nav_contact:

                        startActivity(new Intent (getApplicationContext(),ContactActivity.class));
                        return true;

                    case R.id.nav_help:

                        //startActivity(new Intent (getApplicationContext(),HelpActivity.class));
                        return true;
                    case R.id.nav_maps:

                        startActivity(new Intent (getApplicationContext(),MapsActivity.class));
                        return true;
                    case R.id.nav_news:

                        startActivity(new Intent (getApplicationContext(),NewsActivity.class));
                        return true;
                    case R.id.nav_notes:

                        startActivity(new Intent (getApplicationContext(),NotesActivity.class));
                        return true;
                    case R.id.nav_speakers:

                        startActivity(new Intent (getApplicationContext(),SpeakersActivity.class));
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(), "Work in progress", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });


        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        View header = navigationView.getHeaderView(0);
        //drawerLayout.closeDrawer(GravityCompat.START);


       // ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,  R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

                mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,  R.string.navigation_drawer_open, R.string.navigation_drawer_close) {


            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };


     //   actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorFont));
     //   actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorFont));
        mDrawerToggle.setDrawerIndicatorEnabled(true);

        //actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
       // actionBarDrawerToggle.setDrawerArrowDrawable(R.drawable.ic_arrow_back_black_24dp);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   drawerLayout.setDrawerListener(actionBarDrawerToggle);
        drawerLayout.setDrawerListener( mDrawerToggle);
        mDrawerToggle.syncState();
    //    actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return mDrawerToggle.onOptionsItemSelected(item);
    }
}