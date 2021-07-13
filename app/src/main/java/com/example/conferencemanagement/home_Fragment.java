package com.example.conferencemanagement;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

                sql = testDB.getWritableDatabase();

                sql.execSQL("INSERT INTO member VALUES(null,'" +
                        edit_firstName.getText() + "','" + edit_firstRole.getText() +
                        edit_secondName.getText() + "','" + edit_secondRole.getText() +
                        edit_thirdName.getText() + "','" + edit_thirdRole.getText() +
                        edit_fourthName.getText() + "','" + edit_fourthRole.getText() + "');"
                );


                sql.close();
            }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sql = testDB.getReadableDatabase();
                Cursor cursor;
                cursor = sql.rawQuery("SELECT * FROM MEMBER;", null);

                String Value2 = "Value" + "\r\n";

                while (cursor.moveToNext()) {
                    Value2 +=  cursor.getString(1) + " \t\t" + cursor.getString(2) + "\r\t"
                            + cursor.getString(3) + "\t\t" + cursor.getString(4) + "\r\n"
                            + cursor.getString(5) + "\t\t" + cursor.getString(6) + "\r\n"
                            + cursor.getString(7) + "\t\t" + cursor.getString(8) + "\r\n";
                }
                textView.setText(Value2);
                cursor.close();
                sql.close();

            }
        });

        return v;
    }


}
