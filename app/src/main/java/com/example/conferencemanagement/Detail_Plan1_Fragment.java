package com.example.conferencemanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Detail_Plan1_Fragment extends Fragment {

    TextView detail_plan1_member_name1, detail_plan1_member_name2, detail_plan1_member_name3, detail_plan1_member_name4;
    TextView text_plan_name1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detail__plan1_, container, false);

        detail_plan1_member_name1 = (TextView) v.findViewById(R.id.detail_plan1_member_name1);
        detail_plan1_member_name2 = (TextView)v.findViewById(R.id.detail_plan1_member_name2);
        detail_plan1_member_name3 = (TextView)v.findViewById(R.id.detail_plan1_member_name3);
        detail_plan1_member_name4 = (TextView)v.findViewById(R.id.detail_plan1_member_name4);

        text_plan_name1 =(TextView) v.findViewById(R.id.text_plan_name1);

        Bundle bundle = getArguments();

        if (bundle != null) {


            text_plan_name1.setText(bundle.getString("edit_plan_name1"));

        }

        return v;
    }
}