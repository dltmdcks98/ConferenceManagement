package com.example.conferencemanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class teamLeader_Fragment extends Fragment {

    TextView text_profile_1_name, text_profile_2_name, text_profile_3_name, text_profile_4_name;
    TextView text_profile_1_limit, text_profile_2_limit, text_profile_3_limit, text_profile_4_limit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_team_leader_, container, false);
        text_profile_1_name = (TextView) v.findViewById(R.id.text_profile_1_name);
        text_profile_2_name = (TextView) v.findViewById(R.id.text_profile_2_name);
        text_profile_3_name = (TextView) v.findViewById(R.id.text_profile_3_name);
        text_profile_4_name = (TextView) v.findViewById(R.id.text_profile_4_name);

        text_profile_1_limit = (TextView) v.findViewById(R.id.text_profile_1_limit);
        text_profile_2_limit = (TextView) v.findViewById(R.id.text_profile_2_limit);
        text_profile_3_limit = (TextView) v.findViewById(R.id.text_profile_3_limit);
        text_profile_4_limit = (TextView) v.findViewById(R.id.text_profile_4_limit);

        Bundle bundle = getArguments();

        if (bundle != null) {


            text_profile_1_name.setText(bundle.getString("first_name"));
            text_profile_2_name.setText(bundle.getString("second_name"));
            text_profile_3_name.setText(bundle.getString("third_name"));
            text_profile_4_name.setText(bundle.getString("fourth_name"));

            text_profile_1_limit.setText(bundle.getString("first_limit"));
            text_profile_2_limit.setText(bundle.getString("second_limit"));
            text_profile_3_limit.setText(bundle.getString("third_limit"));
            text_profile_4_limit.setText(bundle.getString("fourth_limit"));

        }


        return v;

    }
}