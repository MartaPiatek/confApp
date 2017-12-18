package pl.martapiatek.confapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

public class NewsActivity extends Base2Activity {

    private ListView mListView;
    private ConfAppDbAdapter mDbAdapter;
    private ConfAppSimpleCursorAdapter mCursorAdapter;

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



        Cursor cursor = mDbAdapter.fetchAllNews();


        // z kolumn zdefiniowanych w bazie danych
        String[] from = new String[]{
                ConfAppDbAdapter.COL_NEWS_DATE, ConfAppDbAdapter.COL_NEWS_TITLE,
                ConfAppDbAdapter.COL_NEWS_CONTENT

        };

        // do identyfikatorów widoków w układzie graficznym
        int[] to = new int[]{
                R.id.row_newsDate,
                R.id.row_title,
                R.id.row_newsContent

        };

        mCursorAdapter = new ConfAppSimpleCursorAdapter(
                // kontekst
                NewsActivity.this,
                // układ graficzny wiersza
       /////         R.layout.news_rows,
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

                                                 Intent myIntent = new Intent(view.getContext(),SpeakerDetailsActivity.class);
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




}
