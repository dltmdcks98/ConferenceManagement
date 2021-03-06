package com.example.conferencemanagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.content.ContentValues.TAG;
import static android.widget.SearchView.*;

public class entry_room extends AppCompatActivity {
    EditText name,searchView;
    Button confirm;
    SQLiteDatabase sqlDB;
    roomDB myHelper;

//210816test
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_room);

        name = (EditText)findViewById(R.id.name);
        //searchView = (SearchView)findViewById(R.id.search);
        confirm = (Button)findViewById(R.id.confirm);
        searchView = (EditText)findViewById(R.id.search);

        myHelper = new roomDB(this);

        confirm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchView.getText().toString().equals("")){
                    Toast.makeText(entry_room.this,"코드를 입력해주세요",Toast.LENGTH_SHORT).show();
                }else if(name.getText().toString().equals("")){
                    Toast.makeText(entry_room.this,"닉네임을 입력해주세요",Toast.LENGTH_SHORT).show();
                }else
                {
                    String code = null;
                    sqlDB = myHelper.getReadableDatabase();
                    Cursor cursor;
                    cursor = sqlDB.rawQuery("SELECT code FROM roomDB WHERE code = " +searchView.getText().toString() +";",null);
                    if (cursor != null){
                        while (cursor.moveToNext()){
                            code = cursor.getString(cursor.getColumnIndex("code"));
                        }
                        if(searchView.getText().toString().equals(code)){

                            Toast.makeText(entry_room.this,name.getText().toString()+"로 입장하셨습니다.",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),room.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(entry_room.this,"해당 코드와 일치하는 방이 없습니다.",Toast.LENGTH_SHORT).show();
                        }
                    }

                }

            }
        });
    }
}
