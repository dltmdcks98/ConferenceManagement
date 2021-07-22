package com.example.conferencemanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class TestDB extends SQLiteOpenHelper {
    public TestDB(Context context) {
        super(context, "TestDB", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE member ( firstName VARCHAR(20), secondName VARCHAR(20), thirdName VARCHAR(20), fourthName VARCHAR(20), firstRole VARCHAR(10), secondRole VARCHAR(10), thirdRole VARCHAR(10), fourthRole VARCHAR(10));");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS member";
        db.execSQL(sql);
        onCreate(db);
    }
}
