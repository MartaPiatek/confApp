package pl.martapiatek.confapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import pl.martapiatek.confapp.domain.Speaker;

public class SpeakersActivity extends Base2Activity {

    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;
    private ImageButton imageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = (ListView) findViewById(R.id.reminders_list_view);
        mListView.setDivider(null);
        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();

        //dodaj przykładowe dane
      //  insertSomeSpeakers();

        Cursor cursor = mDbAdapter.fetchAllSpeakers();

        // z kolumn zdefiniowanych w bazie danych
;

        String[] from = new String[]{
                    ConfAppDbAdapter.COL_SPEAKER_NAME,
                    ConfAppDbAdapter.COL_SPEAKER_TITLE,
                ConfAppDbAdapter.COL_SPEAKER_DESCRIPTION

        };

        // do identyfikatorów widoków w układzie graficznym
        int[] to = new int[]{
                R.id.row_notesTitle,
                R.id.row_personCompany


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

                Intent myIntent = new Intent(view.getContext(),SpeakerDetailsActivity.class);
                myIntent.putExtra("SPEAKER_TITLE", speaker.getTitle());
                myIntent.putExtra("SPEAKER_NAME", speaker.getName());
                myIntent.putExtra("SPEAKER_DESCRIPTION", speaker.getDescription());

                startActivity(myIntent);


                    }
            }
        );


    } // onCreate

    private int getIdFromPosition(int nC) {
        return (int)mCursorAdapter.getItemId(nC);
    }

}
