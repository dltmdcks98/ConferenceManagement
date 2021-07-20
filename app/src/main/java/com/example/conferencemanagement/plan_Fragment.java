package com.example.conferencemanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class plan_Fragment extends Fragment {

    EditText edit_plan_name1, edit_plan_name2, edit_plan_name3, edit_plan_name4;
    Button btn_plan_move1, btn_plan_move2, btn_plan_move3, btn_plan_move4, btn_plan_save;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plan_, container, false);

        edit_plan_name1 = (EditText) v.findViewById(R.id.edit_plan_name1);
        edit_plan_name2 = (EditText) v.findViewById(R.id.edit_plan_name2);
        edit_plan_name3 = (EditText) v.findViewById(R.id.edit_plan_name3);
        edit_plan_name4 = (EditText) v.findViewById(R.id.edit_plan_name4);

        btn_plan_move1 = (Button) v.findViewById(R.id.btn_plan_move1);
        btn_plan_move2 = (Button) v.findViewById(R.id.btn_plan_move2);
        btn_plan_move3 = (Button) v.findViewById(R.id.btn_plan_move3);
        btn_plan_move4 = (Button) v.findViewById(R.id.btn_plan_move4);
        btn_plan_save = (Button) v.findViewById(R.id.btn_plan_save);

        btn_plan_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();


                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                Detail_Plan1_Fragment detail_plan1_fragment = new Detail_Plan1_Fragment();
                detail_plan1_fragment.setArguments(bundle);

                bundle.putString("edit_plan_name1", edit_plan_name1.getText().toString());


                transaction.commit();


            }
        });


        return v;
    }
}