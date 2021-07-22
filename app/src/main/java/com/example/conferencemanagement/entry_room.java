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
   // SearchView searchView;


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
                }else{

                    try {
                        String name = null;
                        sqlDB = myHelper.getReadableDatabase();

                        Cursor cursor;
                        cursor = sqlDB.rawQuery("SELECT name FROM roomDB WHERE code = "+ searchView.getText().toString() + ";",null);
                        if (cursor != null){
                            while (cursor.moveToNext()){
                                name = cursor.getString(cursor.getColumnIndex("name"));
                            }
                        }
                        Toast.makeText(entry_room.this,name,Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),room.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(entry_room.this,"존재하지 않는 방입니다",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


//https://stackoverflow.com/questions/33849446/searchview-show-result-from-database-to-listview -> DB랑 searchview연결하는거

//        searchView.setOnQueryTextFocusChangeListener(new SearchView.OnQueryTextListener(){
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                return true;
//            }
//
//        });

    }
}
