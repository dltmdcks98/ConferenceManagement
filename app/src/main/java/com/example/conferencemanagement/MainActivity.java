    package com.example.conferencemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment fragment_team_leader;
    Fragment fragment_team_Member;
    Fragment fragment_home;
    Fragment fragment_plan;
    Fragment fragment_calendar;
    Button btnMake,btnAttend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMake = (Button)findViewById(R.id.btnMake);
        btnAttend = (Button)findViewById(R.id.btnAttend);
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
                Intent intent = new Intent(getApplicationContext(),entry_room.class);
                startActivity(intent);
            }
        });
//        fragment_team_leader = new teamLeader_Fragment();
//        fragment_team_Member = new teamMember_Fragment();
//        fragment_home = new home_Fragment();
//        fragment_plan = new plan_Fragment();
//        fragment_calendar = new calendar_Fragment();
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_home).commit();
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom);
//        bottomNavigationView.setOnNavigationItemSelectedListener(
//                new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        switch (item.getItemId()) {
//
//                            case R.id.tab_teamLeader:
//                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_team_leader).commit();
//                                return true;
//                            case R.id.tab_teamMember:
//                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_team_Member).commit();
//                                return true;
//                            case R.id.tab_home:
//                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_home).commit();
//                                return true;
//                            case R.id.tab_plan:
//                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_plan).commit();
//                                return true;
//                            case R.id.tab_calendar:
//                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_calendar).commit();
//                                return true;
//                        }
//
//                        return false;
//                    }
//                }
//        );
    }

}