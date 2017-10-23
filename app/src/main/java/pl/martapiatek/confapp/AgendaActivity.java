package pl.martapiatek.confapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class AgendaActivity extends AppCompatActivity {
    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        mListView = (ListView) findViewById(R.id.agenda_list_view);
        mListView.setDivider(null);
        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();

        //dodaj przykładowe dane
      //  insertSomeSpeakers();

       Cursor cursor = mDbAdapter.fetchAllEvents();

     //   Cursor cursor = mDbAdapter.fetchEventDate();

        // z kolumn zdefiniowanych w bazie danych
        String[] from = new String[]{

                ConfAppDbAdapter.COL_EVENT_DATE, ConfAppDbAdapter.COL_EVENT_LOCATION,
                ConfAppDbAdapter.COL_EVENT_TITLE, ConfAppDbAdapter.COL_EVENT_DESCRIPTION,
                ConfAppDbAdapter.COL_EVENT_SPEAKER
        };

        // do identyfikatorów widoków w układzie graficznym
        int[] to = new int[]{
                R.id.row_agendaDay


        };

        mCursorAdapter = new ConfAppSimpleCursorAdapter(
                // kontekst
                AgendaActivity.this,
                // układ graficzny wiersza
                R.layout.agenda_rows,
                // kursor
                cursor,
                // z kolumn zdefiniowanych w bazie danych
                from,
                // do identyfikatorów widoków w układzie graficznym
                to,
                // znacznik - nieużywany
                0);

        mListView.setAdapter(mCursorAdapter);


    } // onCreate

    private int getIdFromPosition(int nC) {
        return (int)mCursorAdapter.getItemId(nC);
    }




}
