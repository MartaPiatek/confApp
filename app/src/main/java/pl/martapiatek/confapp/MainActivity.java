package pl.martapiatek.confapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements Runnable{

    private Button btnAgenda, btnMap, btnFacebook, btn_InfoConf;
    private Dialog splashDialog;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        showSplashScreen();
        handler = new Handler();
        AsyncTask.execute(this);

        btnAgenda = (Button) findViewById(R.id.btnAgenda);

        btnAgenda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),SearchActivity.class);
                startActivity(myIntent);
            }
        });

        btnMap = (Button) findViewById(R.id.btnMap);

        btnMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),MapsActivity.class);
                startActivity(myIntent);
            }
        });


        btnFacebook = (Button) findViewById(R.id.btn_Facebook);

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
       //         Intent myIntent = new Intent(view.getContext(),CalendarActivity.class);
         //       startActivity(myIntent);
            }
        });

        btn_InfoConf = (Button) findViewById(R.id.btn_InfoConf);
        btn_InfoConf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                         Intent myIntent = new Intent(view.getContext(),ConferenceActivity.class);
                       startActivity(myIntent);
            }
        });


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
