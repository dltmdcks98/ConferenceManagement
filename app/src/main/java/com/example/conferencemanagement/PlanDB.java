package com.example.conferencemanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;


public class PlanDB extends SQLiteOpenHelper {
    public PlanDB(Context context) {super(context, "PlanDB", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE planDB ( firstPlan VARCHAR(20), secondPlan VARCHAR(20), thirdPlan VARCHAR(20), fourthPlan VARCHAR(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS member";
        db.execSQL(sql);
        onCreate(db);
    }

}
