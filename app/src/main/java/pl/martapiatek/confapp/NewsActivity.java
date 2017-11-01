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

public class NewsActivity extends AppCompatActivity {

    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;
    private ImageButton imageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = (ListView) findViewById(R.id.news_list_view);
        mListView.setDivider(null);
        mDbAdapter = new ConfAppDbAdapter(this);
        mDbAdapter.open();

        //dodaj przykładowe dane
     //   insertSomeNews();

        Cursor cursor = mDbAdapter.fetchAllNews();

            //dodaj przykładowe dane
          //  insertSomeNews();


        // z kolumn zdefiniowanych w bazie danych
        String[] from = new String[]{
                ConfAppDbAdapter.COL_NEWS_DATE, ConfAppDbAdapter.COL_NEWS_TITLE,
                ConfAppDbAdapter.COL_NEWS_CONTENT

        };

        // do identyfikatorów widoków w układzie graficznym
        int[] to = new int[]{
                R.id.row_newsDate,
                R.id.row_newsTitle,
                R.id.row_newsContent

        };

        mCursorAdapter = new ConfAppSimpleCursorAdapter(
                // kontekst
                NewsActivity.this,
                // układ graficzny wiersza
                R.layout.news_rows,
                // kursor
                cursor,
                // z kolumn zdefiniowanych w bazie danych
                from,
                // do identyfikatorów widoków w układzie graficznym
                to,
                // znacznik - nieużywany
                0);

        mListView.setAdapter(mCursorAdapter);

      /*  mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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

    private void insertSomeNews() {
        mDbAdapter.createNews( "2012-09-09", "Pierwszy news", "Zmiana miejca eventu");
        mDbAdapter.createNews( "2012-09-10", "Drugi news", "Zmiana miejca eventu 2");

    }


}
