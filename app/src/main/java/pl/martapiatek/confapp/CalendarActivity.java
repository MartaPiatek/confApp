package pl.martapiatek.confapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CalendarActivity extends AppCompatActivity {

        private ListView mListView;
        private ConfAppDbAdapter mDbAdapter;
        private ConfAppSimpleCursorAdapter mCursorAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calendar);

            mListView = (ListView) findViewById(R.id.calendar_list_view);
            mListView.setDivider(null);
            mDbAdapter = new ConfAppDbAdapter(this);
            mDbAdapter.open();

            //dodaj przykładowe dane
            //  insertSomeEvents();

            Cursor cursor = mDbAdapter.fetchAllCalendarEvents();

            // z kolumn zdefiniowanych w bazie danych
            String[] from = new String[]{
                    ConfAppDbAdapter.COL_EVENT_DATE, ConfAppDbAdapter.COL_EVENT_LOCATION,
                    ConfAppDbAdapter.COL_EVENT_TITLE

            };

            // do identyfikatorów widoków w układzie graficznym
            int[] to = new int[]{
                    R.id.row_date,
                    R.id.row_location,
                    R.id.row_title

            };

            mCursorAdapter = new ConfAppSimpleCursorAdapter(
                    // kontekst
                    CalendarActivity.this,
                    // układ graficzny wiersza
                    R.layout.event_day_rows,
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




}
