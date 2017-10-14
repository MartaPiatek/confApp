package pl.martapiatek.confapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAgenda, btnMap, btnFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnAgenda = (Button) findViewById(R.id.btnAgenda);

        btnAgenda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),AgendaActivity.class);
                startActivity(myIntent);
            }
        });

        btnMap = (Button) findViewById(R.id.btnMap);

        btnAgenda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),MapsActivity.class);
                startActivity(myIntent);
            }
        });

    }
}