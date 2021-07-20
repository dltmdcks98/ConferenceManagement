package com.example.conferencemanagement;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class roomDB extends SQLiteOpenHelper {
    public roomDB(Context context){
        super(context,"roomDB",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE roomDB ( name VARCHAR(20)  , code INTEGER PRIMARY KEY );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS roomDB");
        onCreate(db);
    }
}
