package com.example.conferencemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class room extends AppCompatActivity {
    Fragment fragment_team_leader_lock;
    Fragment fragment_team_Member;
    Fragment fragment_home;
    Fragment fragment_plan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room);

        fragment_team_leader_lock = new teamLeader_lock();
        fragment_team_Member = new teamMember_Fragment();
        fragment_home = new home_Fragment();
        fragment_plan = new plan_Fragment();


        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_home).commit();

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.tab_teamLeader_lock:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_team_leader_lock).commit();
                                return true;
                            case R.id.tab_teamMember:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_team_Member).commit();
                                return true;
                            case R.id.tab_home:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_home).commit();
                                return true;
                            case R.id.tab_plan:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_plan).commit();
                                return true;
                            case R.id.tab_calendar:
                                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                                startActivity(intent);
                                return true;
                        }

                        return false;
                    }
                }
        );
    }
}
