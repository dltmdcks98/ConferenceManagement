package com.example.conferencemanagement;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.annotation.Nullable;

public class entry_room extends Activity {
    EditText name;
    SearchView searchView;
    Button confirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_room);

        name = (EditText)findViewById(R.id.name);
        searchView = (SearchView)findViewById(R.id.search);
        confirm = (Button)findViewById(R.id.confirm);


    }
}
