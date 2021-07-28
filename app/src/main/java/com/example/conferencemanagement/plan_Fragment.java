package com.example.conferencemanagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class plan_Fragment extends Fragment {

    Context mContext = getActivity();
    EditText edit_plan_name1, edit_plan_name2, edit_plan_name3, edit_plan_name4;
    EditText edit_first_date, edit_second_date, edit_third_date, edit_fourth_date;
    Button btn_plan_move1, btn_plan_move2, btn_plan_move3, btn_plan_move4, btn_plan_save, btn_plan_show;
    PlanDB planDB = null;
    SQLiteDatabase sql_plan;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        planDB = new PlanDB(activity);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sql_plan = planDB.getWritableDatabase();

        View v = inflater.inflate(R.layout.fragment_plan_, container, false);

        edit_plan_name1 = (EditText) v.findViewById(R.id.edit_plan_name1);
        edit_plan_name2 = (EditText) v.findViewById(R.id.edit_plan_name2);
        edit_plan_name3 = (EditText) v.findViewById(R.id.edit_plan_name3);
        edit_plan_name4 = (EditText) v.findViewById(R.id.edit_plan_name4);

        edit_first_date = (EditText) v.findViewById(R.id.edit_first_date);
        edit_second_date = (EditText) v.findViewById(R.id.edit_second_date);
        edit_third_date = (EditText) v.findViewById(R.id.edit_third_date);
        edit_fourth_date = (EditText) v.findViewById(R.id.edit_fourth_date);

        btn_plan_move1 = (Button) v.findViewById(R.id.btn_plan_move1);
        btn_plan_move2 = (Button) v.findViewById(R.id.btn_plan_move2);
        btn_plan_move3 = (Button) v.findViewById(R.id.btn_plan_move3);
        btn_plan_move4 = (Button) v.findViewById(R.id.btn_plan_move4);
        btn_plan_save = (Button) v.findViewById(R.id.btn_plan_save);
        btn_plan_show = (Button) v.findViewById(R.id.btn_plan_show);

        btn_plan_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sql_plan.execSQL("INSERT INTO planDB VALUES ( '" + edit_plan_name1.getText().toString() + "' , '" + edit_plan_name2.getText().toString() + "', '" + edit_plan_name3.getText().toString() + "', '" + edit_plan_name4.getText().toString() + "', '" + edit_first_date.getText().toString() + "' , '" + edit_second_date.getText().toString() + "', '" + edit_third_date.getText().toString() + "', '" + edit_fourth_date.getText().toString() + "');");
                sql_plan.close();


            }
        });

        btn_plan_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sql_plan = planDB.getReadableDatabase();
                Cursor cursor_plan;
                String firstName = null, secondName = null, thirdName = null, fourthName = null;
                String firstDate = null, secondDate = null, thirdDate = null, fourthDate = null;

                cursor_plan = sql_plan.rawQuery("SELECT * FROM planDB;", null);
                if (cursor_plan != null) {
                    while (cursor_plan.moveToNext()) {
                        firstName = cursor_plan.getString(0);
                        secondName = cursor_plan.getString(1);
                        thirdName = cursor_plan.getString(2);
                        fourthName = cursor_plan.getString(3);
                        firstDate = cursor_plan.getString(4);
                        secondDate = cursor_plan.getString(5);
                        thirdDate = cursor_plan.getString(6);
                        fourthDate = cursor_plan.getString(7);

                    }

                }
                edit_plan_name1.setText(firstName);
                edit_plan_name2.setText(secondName);
                edit_plan_name3.setText(thirdName);
                edit_plan_name4.setText(fourthName);

                edit_first_date.setText(firstDate);
                edit_second_date.setText(secondDate);
                edit_third_date.setText(thirdDate);
                edit_fourth_date.setText(fourthDate);


            }
        });

        btn_plan_move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                Detail_Plan1_Fragment detail_plan1_fragment = new Detail_Plan1_Fragment();
                transaction1.replace(R.id.container, detail_plan1_fragment);
                transaction1.commit();
            }
        });
        btn_plan_move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                Detail_Plan2_Fragment detail_plan2_fragment = new Detail_Plan2_Fragment();
                transaction2.replace(R.id.container, detail_plan2_fragment);
                transaction2.commit();
            }
        });
        btn_plan_move3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction3 = getActivity().getSupportFragmentManager().beginTransaction();
                Detail_Plan3_Fragment detail_plan3_fragment = new Detail_Plan3_Fragment();
                transaction3.replace(R.id.container, detail_plan3_fragment);
                transaction3.commit();
            }
        });

        btn_plan_move4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction4 = getActivity().getSupportFragmentManager().beginTransaction();
                Detail_Plan4_Fragment detail_plan4_fragment = new Detail_Plan4_Fragment();
                transaction4.replace(R.id.container, detail_plan4_fragment);
                transaction4.commit();
            }
        });

        return v;
    }
}