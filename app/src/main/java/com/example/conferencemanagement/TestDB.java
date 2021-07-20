package com.example.conferencemanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TestDB extends SQLiteOpenHelper {
    public TestDB(Context context) {
        super(context, "TestDB2", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE if not exists member ("
                + " _id integer primary key autoincrement, "
                + " Name char(20),"
                + " Role char(20));";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE if exists member";
        db.execSQL(sql);
        onCreate(db);
    }
}
