package com.example.conferencemanagement;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class make_room extends Activity {
    EditText roomCode,roomName;
    Button ranbomCode,btnSave;
    String Code;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_room);

        roomCode = (EditText)findViewById(R.id.roomCode);
        roomName = (EditText)findViewById(R.id.roomName);
        ranbomCode = (Button)findViewById(R.id.ranbomCode);
        btnSave = (Button)findViewById(R.id.btnSave);

        ranbomCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Code = String.valueOf((int)(Math.random() * (99999 - 10000 + 1)) + 10000);
                roomCode.setText(Code);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomCode==null){

                }else if(roomName==null){

                }else {
                    //DB에 저장
                }

            }
        });

    }
}
