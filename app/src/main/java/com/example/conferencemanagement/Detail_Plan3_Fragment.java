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


public class Detail_Plan3_Fragment extends Fragment {
    TextView detail_plan3_member_name1, detail_plan3_member_name2, detail_plan3_member_name3, detail_plan3_member_name4;
    TextView text_plan_name3;
    Button btn_pan_detail_3_show;

    TestDB testDB = null;
    SQLiteDatabase sql;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        testDB = new TestDB(activity);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detail__plan3_, container, false);
        detail_plan3_member_name1 =(TextView) v.findViewById(R.id.detail_plan3_member_name1);
        detail_plan3_member_name2 = (TextView)v.findViewById(R.id.detail_plan3_member_name2);
        detail_plan3_member_name3 = (TextView)v.findViewById(R.id.detail_plan3_member_name3);
        detail_plan3_member_name4 = (TextView)v.findViewById(R.id.detail_plan3_member_name4);
        btn_pan_detail_3_show = (Button) v.findViewById(R.id.btn_pan_detail_3_show);
        text_plan_name3 = (TextView) v.findViewById(R.id.text_plan_name3);

        sql = testDB.getReadableDatabase();
        Cursor cursor;
        String name1 = null, name2 = null, name3 = null, name4 = null;

        cursor = sql.rawQuery("SELECT * FROM MEMBER;", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                name1 = cursor.getString(0);
                name2 = cursor.getString(1);
                name3 = cursor.getString(2);
                name4 = cursor.getString(3);
            }
        }

        detail_plan3_member_name1.setText(name1);
        detail_plan3_member_name2.setText(name2);
        detail_plan3_member_name3.setText(name3);
        detail_plan3_member_name4.setText(name4);

        cursor.close();
        sql.close();



        return v;
    }
}