package com.example.conferencemanagement;

import android.app.Activity;
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
import android.widget.Toast;


public class teamLeader_lock extends Fragment {
    roomDB myHelper;
    entryNameDB nameDB;
    Context mContext = getActivity();
    EditText edit_teamLeader_password;
    SQLiteDatabase sqlDB;
    Button btn_teamLeader_move;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        myHelper = new roomDB(activity);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_team_leader_lock, container, false);

        edit_teamLeader_password = (EditText) v.findViewById(R.id.edit_teamLeader_password);
        btn_teamLeader_move = (Button) v.findViewById(R.id.btn_teamLeader_move);

        btn_teamLeader_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_teamLeader_password.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                String pass = null;
                sqlDB = myHelper.getReadableDatabase();

                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT pass FROM roomDB;",null);
                if (cursor != null){
                    while (cursor.moveToNext()){
                        pass = cursor.getString(cursor.getColumnIndex("pass"));
                    }
                }
                FragmentTransaction transaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                teamLeader_Fragment teamLeader_fragment = new teamLeader_Fragment();
                transaction1.replace(R.id.container, teamLeader_fragment);
                transaction1.commit();
                edit_teamLeader_password.setText(null);

            }
        });


        return v;
    }
}