package pl.martapiatek.confapp;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class SpeakersActivity extends AppCompatActivity {

    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;
    private ImageButton imageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);

        mListView = (ListView) findViewById(R.id.reminders_list_view);
        mListView.setDivider(null);
        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();

        //dodaj przykładowe dane
        insertSomeSpeakers();

        Cursor cursor = mDbAdapter.fetchAllSpeakers();

        // z kolumn zdefiniowanych w bazie danych
        String[] from = new String[]{
                    ConfAppDbAdapter.COL_SPEAKER_FIRST_NAME, ConfAppDbAdapter.COL_SPEAKER_LAST_NAME,
                    ConfAppDbAdapter.COL_SPEAKER_TITLE, ConfAppDbAdapter.COL_SPEAKER_DESCRIPTION

        };

        // do identyfikatorów widoków w układzie graficznym
        int[] to = new int[]{
                R.id.row_firstName,
                R.id.row_lastName,
                R.id.row_title,
                R.id.row_description

        };

        mCursorAdapter = new ConfAppSimpleCursorAdapter(
                // kontekst
                SpeakersActivity.this,
                // układ graficzny wiersza
                R.layout.speakers_rows,
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


                Speaker speaker =  mDbAdapter.fetchSpeakerById(getIdFromPosition(masterListPosition));

                Intent myIntent = new Intent(view.getContext(),SpeakerDatailsActivity.class);
                myIntent.putExtra("SPEAKER_TITLE", speaker.getTitle());
                myIntent.putExtra("SPEAKER_FIRST_NAME", speaker.getFirstName());
                myIntent.putExtra("SPEAKER_LAST_NAME", speaker.getLastName());
                myIntent.putExtra("SPEAKER_DESCRIPTION", speaker.getDescription());

                startActivity(myIntent);


                    }
            }
        );


    } // onCreate

    private int getIdFromPosition(int nC) {
        return (int)mCursorAdapter.getItemId(nC);
    }

    private void insertSomeSpeakers() {
        mDbAdapter.createSpeaker( "Adam", "Nowak", "dr", "CEO Google");
        mDbAdapter.createSpeaker( "Antoni", "Bodnar", "prof", "Politechnika Wrocławska");
        mDbAdapter.createSpeaker( "Jan", "Kowalski", "dr", "CEO Pied Pipper");
        mDbAdapter.createSpeaker( "Joanna", "Kaminska", "MD", "Facebook");

    }


}