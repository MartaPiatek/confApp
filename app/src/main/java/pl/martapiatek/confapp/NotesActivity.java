package pl.martapiatek.confapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class NotesActivity extends AppCompatActivity {

    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;
    private ImageButton imageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mListView = (ListView) findViewById(R.id.notes_list_view);
        mListView.setDivider(null);
        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();

        //dodaj przykładowe dane
        insertSomeNotes();

        Cursor cursor = mDbAdapter.fetchAllNotes();

        // z kolumn zdefiniowanych w bazie danych
        String[] from = new String[]{
                ConfAppDbAdapter.COL_NOTE_DATE, ConfAppDbAdapter.COL_NOTE_TITLE,
                ConfAppDbAdapter.COL_NOTE_CONTENT

        };

        // do identyfikatorów widoków w układzie graficznym
        int[] to = new int[]{
                R.id.row_notesDate,
                R.id.row_notesTitle,
                R.id.row_notesContent

        };

        mCursorAdapter = new ConfAppSimpleCursorAdapter(
                // kontekst
                NotesActivity.this,
                // układ graficzny wiersza
                R.layout.notes_rows,
                // kursor
                cursor,
                // z kolumn zdefiniowanych w bazie danych
                from,
                // do identyfikatorów widoków w układzie graficznym
                to,
                // znacznik - nieużywany
                0);

        mListView.setAdapter(mCursorAdapter);

     /*   mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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
*/

    } // onCreate

    private int getIdFromPosition(int nC) {
        return (int)mCursorAdapter.getItemId(nC);
    }

    private void insertSomeNotes() {
        mDbAdapter.createNote("2017-12-23", "Tytuł prezki", "To jest jakas notatka");


    }


}
