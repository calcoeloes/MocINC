package com.example.android.mocinc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Akhdan on 4/29/2017.
 */

public class DataHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "moc.db";

    public DataHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(" +
                "NAMA TEXT," +
                "TGL_LAHIR DATE," +
                "EMAIL TEXT," +
                "ALAMAT TEXT," +
                "USERNAME TEXT PRIMARY KEY," +
                "PASSWORD TEXT");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);
    }
}
