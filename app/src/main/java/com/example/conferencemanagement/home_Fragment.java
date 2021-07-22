package com.example.conferencemanagement;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class home_Fragment extends Fragment {

    Context mContext = getActivity();
    EditText edit_firstName, edit_secondName, edit_thirdName, edit_fourthName;
    EditText edit_firstRole, edit_secondRole, edit_thirdRole, edit_fourthRole;
    Button btn_homeSave, btn;
    TestDB testDB = null;
    SQLiteDatabase sql;
    TextView textView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        testDB = new TestDB(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sql = testDB.getWritableDatabase();


        View v = inflater.inflate(R.layout.fragment_home_, container, false);

        edit_firstName = (EditText) v.findViewById(R.id.edit_firstName);
        edit_secondName = (EditText) v.findViewById(R.id.edit_secondName);
        edit_thirdName = (EditText) v.findViewById(R.id.edit_thirdName);
        edit_fourthName = (EditText) v.findViewById(R.id.edit_fourthName);
        edit_firstRole = (EditText) v.findViewById(R.id.edit_firstRole);
        edit_secondRole = (EditText) v.findViewById(R.id.edit_secondRole);
        edit_thirdRole = (EditText) v.findViewById(R.id.edit_thirdRole);
        edit_fourthRole = (EditText) v.findViewById(R.id.edit_fourthRole);
        textView = (TextView) v.findViewById(R.id.textView);

        btn_homeSave = (Button) v.findViewById(R.id.btn_homeSave);
        btn = (Button) v.findViewById(R.id.btn);

        btn_homeSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                sql.execSQL("INSERT INTO member VALUES ( '" + edit_firstName.getText().toString() + "' , '" + edit_secondName.getText().toString() + "', '" + edit_thirdName.getText().toString() + "', '" + edit_fourthName.getText().toString() + "', '" + edit_firstRole.getText().toString() + "', '" + edit_secondRole.getText().toString() + "', '" + edit_thirdRole.getText().toString() + "', '" + edit_fourthRole.getText().toString() + "');");


                sql.close();

            }
        });


        return v;
    }


}
