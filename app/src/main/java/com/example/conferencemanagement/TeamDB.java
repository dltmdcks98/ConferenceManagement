package com.example.conferencemanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TeamDB extends SQLiteOpenHelper{
        public TeamDB(Context context){
            super(context,"TeamDB",null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE team ( limitation VARCHAR(40)  , progress INTEGER, reason VARCAHR(200));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "DROP TABLE IF EXISTS team";
            db.execSQL(sql);
            onCreate(db);
        }
}
