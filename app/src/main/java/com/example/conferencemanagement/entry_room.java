package com.example.conferencemanagement;

import android.app.Activity;
import android.os.Bundle;
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
   // SearchView searchView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_room);

        name = (EditText)findViewById(R.id.name);
        //searchView = (SearchView)findViewById(R.id.search);
        confirm = (Button)findViewById(R.id.confirm);
        searchView = (EditText)findViewById(R.id.search);




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
