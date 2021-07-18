package com.example.conferencemanagement;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnMake, btnAttend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btnMake = (Button) findViewById(R.id.btnMake);
        btnAttend = (Button) findViewById(R.id.btnAttend);
        btnMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), make_room.class);
                startActivity(intent);
            }
        });

        btnAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), entry_room.class);
                startActivity(intent);
            }
        });
//
    }

}