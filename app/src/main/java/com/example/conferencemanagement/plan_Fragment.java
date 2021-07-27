package com.example.conferencemanagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
    Button btn_plan_move1, btn_plan_move2, btn_plan_move3, btn_plan_move4, btn_plan_save;
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

        btn_plan_move1 = (Button) v.findViewById(R.id.btn_plan_move1);
        btn_plan_move2 = (Button) v.findViewById(R.id.btn_plan_move2);
        btn_plan_move3 = (Button) v.findViewById(R.id.btn_plan_move3);
        btn_plan_move4 = (Button) v.findViewById(R.id.btn_plan_move4);
        btn_plan_save = (Button) v.findViewById(R.id.btn_plan_save);

        btn_plan_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sql_plan.execSQL("INSERT INTO member VALUES ( '" + edit_plan_name1.getText().toString() + "' , '" + edit_plan_name2.getText().toString() + "', '" + edit_plan_name3.getText().toString() + "', '" + edit_plan_name4.getText().toString() + "');");
                sql_plan.close();
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