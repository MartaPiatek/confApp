package pl.martapiatek.confapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button btnMessage = (Button) findViewById(R.id.btnMessage);
        btnMessage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent startIntent = new Intent(getApplicationContext(),MailContactActivity.class);
                startActivity(startIntent);
            }
        });

    }
}
