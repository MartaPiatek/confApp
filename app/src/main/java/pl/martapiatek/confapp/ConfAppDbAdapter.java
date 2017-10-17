package pl.martapiatek.confapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class ConfAppDbAdapter {

    //nazwy kolumn
    public static final String COL_SPEAKER_ID = "_id";
    public static final String COL_SPEAKER_FIRST_NAME = "firstName";
    public static final String COL_SPEAKER_LAST_NAME = "lastName";
    public static final String COL_SPEAKER_TITLE = "speakerTitle";
    public static final String COL_SPEAKER_DESCRIPTION = "speakerDescription";

    //indeksy

    public static final int INDEX_SPEAKER_ID = 0;
    public static final int INDEX_SPEAKER_FIRST_NAME = INDEX_SPEAKER_ID + 1;
    public static final int INDEX_SPEAKER_LAST_NAME = INDEX_SPEAKER_ID + 2;
    public static final int INDEX_SPEAKER_TITLE = INDEX_SPEAKER_ID + 3;
    public static final int INDEX_SPEAKER_DESCRIPTION = INDEX_SPEAKER_ID + 4;

    //dziennik zdarzeń
    public static final String TAG = "ConfAppDbAdapter";

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "dba_confApp";

    private static final String TABLE_SPEAKER_NAME = "tbl_speaker";

    private static final int DATABASE_VERSION = 1;

    private Context mCtx;

    //SQL do utworzenia tabel bazy danych
    private static final String CREATE_TABLE_SPEAKER =
                    "CREATE TABLE if not exists " + TABLE_SPEAKER_NAME + " ( " +
                     COL_SPEAKER_ID + " INTEGER PRIMARY KEY autoincrement, " +
                     COL_SPEAKER_FIRST_NAME + " TEXT, " +
                     COL_SPEAKER_LAST_NAME + " TEXT, " +
                     COL_SPEAKER_TITLE + " TEXT, " +
                     COL_SPEAKER_DESCRIPTION + " TEXT ); "
            ;


    public ConfAppDbAdapter(Context ctx) {
        mCtx = ctx;
    }

    // otwarcie
    public void open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
    }

    // zamknięcie
    public void close() {
        if(mDbHelper != null){
            mDbHelper.close();
        }
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context,DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            Log.w(TAG, CREATE_TABLE_SPEAKER);
            db.execSQL(CREATE_TABLE_SPEAKER);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            Log.w(TAG, "Aktualizacja bazy danych z wersji "+ oldVersion + " do wersji " +
                    newVersion + " , co powoduje wyczyszczenie zawartości bazy danych.");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPEAKER_NAME);
            onCreate(db);
        }
    }

    // TWORZENIE
    public void createSpeaker( String firstName, String lastName, String title, String description){
        ContentValues values = new ContentValues();
        values.put(COL_SPEAKER_FIRST_NAME, firstName);
        values.put(COL_SPEAKER_LAST_NAME, lastName);
        values.put(COL_SPEAKER_TITLE, title);
        values.put(COL_SPEAKER_DESCRIPTION, description);
        mDb.insert(TABLE_SPEAKER_NAME, null, values);
    }


    public long createSpeaker(Speaker speaker){
        ContentValues values = new ContentValues();
        values.put(COL_SPEAKER_FIRST_NAME, speaker.getFirstName());
        values.put(COL_SPEAKER_LAST_NAME, speaker.getLastName());
        values.put(COL_SPEAKER_TITLE, speaker.getTitle());
        values.put(COL_SPEAKER_DESCRIPTION, speaker.getDescription());
        return mDb.insert(TABLE_SPEAKER_NAME, null, values);
    }

    // ODCZYT
    public Speaker fetchSpeakerById(int id) {

        Cursor cursor = mDb.query(TABLE_SPEAKER_NAME, new String[]{COL_SPEAKER_ID,
                        COL_SPEAKER_FIRST_NAME, COL_SPEAKER_LAST_NAME, COL_SPEAKER_TITLE,
                        COL_SPEAKER_DESCRIPTION}, COL_SPEAKER_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        return new Speaker(
                cursor.getInt(INDEX_SPEAKER_ID),
                cursor.getString(INDEX_SPEAKER_FIRST_NAME),
                cursor.getString(INDEX_SPEAKER_LAST_NAME),
                cursor.getString(INDEX_SPEAKER_TITLE),
                cursor.getString(INDEX_SPEAKER_DESCRIPTION) );
    }


    public Cursor fetchAllSpeakers(){
        Cursor mCursor = mDb.query(TABLE_SPEAKER_NAME, new String[]{COL_SPEAKER_ID,
                        COL_SPEAKER_FIRST_NAME, COL_SPEAKER_LAST_NAME, COL_SPEAKER_TITLE, COL_SPEAKER_DESCRIPTION},
                null, null, null, null, COL_SPEAKER_FIRST_NAME);
        if(mCursor != null)
            mCursor.moveToFirst();

        return mCursor;
    }

    // USUNIĘCIE
    public void deleteSpeakerById(int nId){
        mDb.delete(TABLE_SPEAKER_NAME, COL_SPEAKER_ID + "=?", new String[]{String.valueOf(nId)});
    }

    public void deleteAllSpeakers(){
        mDb.delete(TABLE_SPEAKER_NAME, null, null);
    }

}

