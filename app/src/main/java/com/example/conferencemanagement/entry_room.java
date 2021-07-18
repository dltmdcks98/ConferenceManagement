package com.example.conferencemanagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.widget.SearchView.*;

public class entry_room extends AppCompatActivity {
    EditText name,searchView;
    Button confirm;
    myDBHelper myDBHelper;
    SQLiteDatabase sqlDB;
   // SearchView searchView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_room);

        name = (EditText)findViewById(R.id.name);
        //searchView = (SearchView)findViewById(R.id.search);
        confirm = (Button)findViewById(R.id.confirm);
        searchView = (EditText)findViewById(R.id.search);

        confirm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchView.getText().toString().equals("")){
                    Toast.makeText(entry_room.this,"코드를 입력해주세요",Toast.LENGTH_SHORT).show();
                }else if(name.getText().toString().equals("")){
                    Toast.makeText(entry_room.this,"닉네임을 입력해주세요",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(),room.class);
                    startActivity(intent);
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
    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context){
            super(context,"roomDB",null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE roomDB ( name VARCHAR(20) PRIMARY KEY , code INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS roomDB");
            onCreate(db);
        }
    }
}
