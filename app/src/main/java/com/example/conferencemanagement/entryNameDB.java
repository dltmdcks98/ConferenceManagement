package com.example.conferencemanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class entryNameDB extends SQLiteOpenHelper {
        public entryNameDB(Context context){
            super(context,"entryNameDB",null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE entryName ( name VARCHAR(20) PRIMARY KEY);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS entryName");
            onCreate(db);
        }
}

