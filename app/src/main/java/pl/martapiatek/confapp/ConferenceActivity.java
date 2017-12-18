package pl.martapiatek.confapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConferenceActivity extends Base2Activity {

    private Button btnSpeakers, btnEvents;
    ScaleGestureDetector skalaGestureDetector;
    TextView txtViewAboutConference;


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        skalaGestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference);
        txtViewAboutConference = (TextView) findViewById(R.id.txtViewAboutConference);

        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        skalaGestureDetector = new ScaleGestureDetector(this, new MojOnScaleGestureListener());


    }

    public class MojOnScaleGestureListener extends
            ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float wspolczynnikSkalowania = detector.getScaleFactor();

            float zoomFactor = txtViewAboutConference.getTextSize() * wspolczynnikSkalowania;

            txtViewAboutConference.setText(Float.toString(zoomFactor));
            txtViewAboutConference.setTextSize(zoomFactor);

            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector czujnik) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector czujnik) {

        }
    }
}
