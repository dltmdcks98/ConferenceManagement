package com.example.conferencemanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.text.NoCopySpan;


public class PlanDB extends SQLiteOpenHelper {
    public PlanDB(Context context) {super(context, "PlanDB2", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE planDB ( firstName VARCHAR(10), secondName VARCHAR(10), thirdName VARCHAR(10), fourthName VARCHAR(10), firstDate VARCHAR(10), secondDate VARCHAR(10), thirdDate VARCHAR(10), fourthDate VARCHAR(10));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS planDB";
        db.execSQL(sql);
        onCreate(db);
    }



}
