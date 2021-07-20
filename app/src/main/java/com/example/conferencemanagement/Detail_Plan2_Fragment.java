package com.example.conferencemanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Detail_Plan2_Fragment extends Fragment {
    TextView detail_plan2_member_name1, detail_plan2_member_name2, detail_plan2_member_name3, detail_plan2_member_name4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail__plan1_, container, false);

        detail_plan2_member_name1 = v.findViewById(R.id.detail_plan2_member_name1);
        detail_plan2_member_name2 = v.findViewById(R.id.detail_plan2_member_name2);
        detail_plan2_member_name3 = v.findViewById(R.id.detail_plan2_member_name3);
        detail_plan2_member_name4 = v.findViewById(R.id.detail_plan2_member_name4);

        Bundle bundle = getArguments();

        if (bundle != null) {


            detail_plan2_member_name1.setText(bundle.getString("edit_plan_name1"));
            detail_plan2_member_name2.setText(bundle.getString("edit_plan_name2"));
            detail_plan2_member_name3.setText(bundle.getString("edit_plan_name3"));
            detail_plan2_member_name4.setText(bundle.getString("edit_plan_name4"));

        }

        return v;
    }
}