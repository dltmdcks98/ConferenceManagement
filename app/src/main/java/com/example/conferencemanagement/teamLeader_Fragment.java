package com.example.conferencemanagement;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class teamLeader_Fragment extends Fragment {

    TextView text_profile_1_name, text_profile_2_name, text_profile_3_name, text_profile_4_name;
    TextView text_profile_1_limit, text_profile_2_limit, text_profile_3_limit, text_profile_4_limit;
    TestDB testDB;
    TeamDB teamDB;
    SQLiteDatabase sql, sql2;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        testDB = new TestDB(activity);
        teamDB = new TeamDB(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_team_leader_, container, false);
        text_profile_1_name = (TextView) v.findViewById(R.id.text_profile_1_name);
        text_profile_2_name = (TextView) v.findViewById(R.id.text_profile_2_name);
        text_profile_3_name = (TextView) v.findViewById(R.id.text_profile_3_name);
        text_profile_4_name = (TextView) v.findViewById(R.id.text_profile_4_name);
        text_profile_1_limit = (TextView) v.findViewById(R.id.text_profile_1_limit);
        text_profile_2_limit = (TextView) v.findViewById(R.id.text_profile_2_limit);
        text_profile_3_limit = (TextView) v.findViewById(R.id.text_profile_3_limit);
        text_profile_4_limit = (TextView) v.findViewById(R.id.text_profile_4_limit);


        sql = testDB.getReadableDatabase();
        Cursor cursor;
        String name1 = null, name2 = null, name3 = null, name4 = null, role1 = null, role2 = null, role3 = null, role4 = null;

        cursor = sql.rawQuery("SELECT * FROM MEMBER;", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                name1 = cursor.getString(0);
                name2 = cursor.getString(1);
                name3 = cursor.getString(2);
                name4 = cursor.getString(3);
                role1 = cursor.getString(4);
                role2 = cursor.getString(5);
                role3 = cursor.getString(6);
                role4 = cursor.getString(7);
            }
        }

        sql2 = teamDB.getReadableDatabase();
        Cursor cursor1;
        String limit_1 = null; // , limit_2 = null, limit_3 = null, limit_4 = null;

        cursor1 = sql2.rawQuery("SELECT limitation FROM team;",null);
        if(cursor1 != null){
            while (cursor1.moveToNext()) {
                limit_1 = cursor1.getString(0);
            }
        }

        text_profile_1_name.setText(name1);
        text_profile_2_name.setText(name2);
        text_profile_3_name.setText(name3);
        text_profile_4_name.setText(name4);

        text_profile_1_limit.setText(limit_1);


        cursor.close();
        cursor1.close();
        sql.close();
        sql2.close();




        return v;

    }
}