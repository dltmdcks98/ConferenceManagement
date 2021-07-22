package com.example.conferencemanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class TestDB extends SQLiteOpenHelper {
    public TestDB(Context context) {
        super(context, "TestDB2", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE member (_id INTEGER PRIMARY KEY AUTOINCREMENT, Name1 char(20), Name2 char(20), Name3 char(20), Name4 char(20), Role1 char(10), Role2 char(10), Role3 char(10), Role4 char(10));");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS member";
        db.execSQL(sql);
        onCreate(db);
    }
}
