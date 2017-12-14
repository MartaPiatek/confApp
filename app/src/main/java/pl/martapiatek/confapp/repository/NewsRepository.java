package pl.martapiatek.confapp.repository;


import android.content.Context;

import pl.martapiatek.confapp.ConfAppDbAdapter;

public class NewsRepository {


    private ConfAppDbAdapter mDbAdapter;
    private Context context;


    public NewsRepository(Context context) {
        this.context = context;
        mDbAdapter = new ConfAppDbAdapter(this.context);
    }

    public ConfAppDbAdapter openDb() {

        mDbAdapter.open();
        return mDbAdapter;
    }


}
