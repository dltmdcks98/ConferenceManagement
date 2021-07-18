package com.example.conferencemanagement;


import android.app.Activity;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class make_room extends Activity {
    roomDB myHelper;
    EditText roomCode, roomName;
    Button ranbomCode, btnSave, btnReset;
    String Code;
    SQLiteDatabase sqlDB;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_room);

        roomCode = (EditText) findViewById(R.id.roomCode);
        roomName = (EditText) findViewById(R.id.roomName);
        ranbomCode = (Button) findViewById(R.id.ranbomCode);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnReset = (Button)findViewById(R.id.btnReset);

        myHelper = new roomDB(this);

        ranbomCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Code = String.valueOf((int) (Math.random() * (99999 - 10000 + 1)) + 10000);
                roomCode.setText(Code);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB,1,2);
                sqlDB.close();
                Toast.makeText(make_room.this, "DB를 초기화 합니다.", Toast.LENGTH_SHORT).show();
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (roomCode.getText().toString().equals("")) {
                    Toast.makeText(make_room.this, "code가 비였습니다.", Toast.LENGTH_SHORT).show();
                } else if (roomName.getText().toString().equals("")) {
                    Toast.makeText(make_room.this, "name이 비었습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    //DB에 저장
                    sqlDB = myHelper.getWritableDatabase();
                    try {
                        sqlDB.execSQL("INSERT INTO roomDB VALUES ( '"
                                + roomName.getText().toString() + "' , "
                                + roomCode.getText().toString() + ");");
                        Toast.makeText(make_room.this, "저장.", Toast.LENGTH_SHORT).show();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        Toast.makeText(make_room.this, "중복된 코드 입니다.", Toast.LENGTH_SHORT).show();
                    }
                    sqlDB.close();

                }

            }
        });

    }
}


