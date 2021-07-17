package com.example.conferencemanagement;

import android.content.Context;
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
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class home_Fragment extends Fragment {

    Context mContext = getActivity();
    EditText edit_firstName, edit_secondName, edit_thirdName, edit_fourthName;
    EditText edit_firstRole, edit_secondRole, edit_thirdRole, edit_fourthRole;
    Button btn_homeSave, btn;
    TestDB testDB;
    SQLiteDatabase sql;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_, container, false);

        edit_firstName = (EditText) v.findViewById(R.id.edit_firstName);
        edit_secondName = (EditText)v.findViewById(R.id.edit_secondName);
        edit_thirdName = (EditText)v.findViewById(R.id.edit_thirdName);
        edit_fourthName = (EditText)v.findViewById(R.id.edit_fourthName);
        edit_firstRole = (EditText)v.findViewById(R.id.edit_firstRole);
        edit_secondRole = (EditText)v.findViewById(R.id.edit_secondRole);
        edit_thirdRole = (EditText)v.findViewById(R.id.edit_thirdRole);
        edit_fourthRole = (EditText)v.findViewById(R.id.edit_fourthRole);
        textView = (TextView)v.findViewById(R.id.textView);

        btn_homeSave =(Button) v.findViewById(R.id.btn_homeSave);
        btn = (Button) v.findViewById(R.id.btn);

        btn_homeSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Bundle bundle = new Bundle();
                bundle.putString("first_name", edit_firstName.getText().toString());
                bundle.putString("second_name", edit_secondName.getText().toString());
                bundle.putString("third_name", edit_thirdName.getText().toString());
                bundle.putString("fourth_name", edit_fourthName.getText().toString());

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                teamLeader_Fragment teamLeader_fragment = new teamLeader_Fragment();
                teamLeader_fragment.setArguments(bundle);
                transaction.add(R.id.container, teamLeader_fragment);
                transaction.replace(R.id.container, teamLeader_fragment);
                transaction.commit();


            }

        });



        return v;
    }


}
