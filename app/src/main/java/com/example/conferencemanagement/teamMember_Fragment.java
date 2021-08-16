package com.example.conferencemanagement;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class teamMember_Fragment extends Fragment {

    EditText editLimit, editProgress,editExplain;
    ImageView imageView;
    Gallery gallery;
    TextView name;
    ProgressBar progressBar;
    Button btnSave;

    roomDB roomDB;
    TeamDB teamDB;
    entryNameDB nameDB;

    SQLiteDatabase sql,sql1,sql2,sql3;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        roomDB = new roomDB(activity);
        teamDB = new TeamDB(activity);
        nameDB = new entryNameDB(activity);

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_team_member_, container, false);

        editLimit = (EditText) v.findViewById(R.id.edit_limitation);
        imageView = (ImageView) v.findViewById(R.id.image_user);
        gallery = (Gallery) v.findViewById(R.id.gallery1);
        name  = (TextView) v.findViewById(R.id.member_name);
        progressBar = (ProgressBar) v.findViewById(R.id.progress1);
        editProgress = (EditText) v.findViewById(R.id.progress_edit);
        editExplain = (EditText) v.findViewById(R.id.edit_explain);
        btnSave = (Button) v.findViewById(R.id.button_save);

        sql = roomDB.getReadableDatabase();
        sql1 = teamDB.getWritableDatabase();
        sql2 = nameDB.getReadableDatabase();
//        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;


        String name1 = null, name2 = null, name3 = null, name4 = null;
        String Username = null;

//        cursor = sql.rawQuery("SELECT name FROM roomDB;", null);
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                name1 = cursor.getString(0);
//
//            }
//            }

        String edit1 = null, edit2 = null, edit3 = null;
        cursor1 = sql1.rawQuery("SELECT limitation FROM team;",null);
        if(cursor1 != null){
            while (cursor1.moveToNext()) {
                edit1 = cursor1.getString(0);
            }
        }
        cursor1 = sql1.rawQuery("SELECT progress FROM team;",null);
        if(cursor1 != null){
            while (cursor1.moveToNext()) {
                edit2 = cursor1.getString(0);
            }
        }
        cursor1 = sql1.rawQuery("SELECT reason FROM team;",null);
        if(cursor1 != null){
            while (cursor1.moveToNext()) {
                edit3 = cursor1.getString(0);
            }
        }
        cursor2 = sql2.rawQuery("SELECT name FROM entryName;",null);
        if(cursor2 != null){
            while(cursor2.moveToNext()){
                Username = cursor2.getString(0);
            }
        }
        editLimit.setText(edit1);
        editProgress.setText(edit2);
        editExplain.setText(edit3);
        if(edit2 !=null){
        progressBar.setProgress(Integer.parseInt(edit2));}
        else{progressBar.setProgress(0);}
        name.setText(Username);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sql1.execSQL("INSERT INTO team VALUES (' " + editLimit.getText().toString()
            + "','" + editProgress.getText().toString() + "','" + editExplain.getText().toString() +"');");
                String gage;
                gage = editProgress.getText().toString();
                progressBar.setProgress(Integer.parseInt(gage));
                Toast.makeText(getActivity(), "저장되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        cursor1.close();
        cursor2.close();
        sql.close();
        sql2.close();

        return v;

    }


}
