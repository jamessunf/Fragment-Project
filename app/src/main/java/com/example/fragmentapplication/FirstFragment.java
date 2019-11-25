package com.example.fragmentapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    private TextView txtFst;
    private Button btnChange, btnNext;
    private SecondFragment secondFragment;

    public static FirstFragment newInstance(String str){

        FirstFragment firstFragment = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putString("input_string",str);
        firstFragment.setArguments(bundle);
        return firstFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtFst = (TextView) view.findViewById(R.id.txt_first);
        btnChange = (Button) view.findViewById(R.id.btn_fst_change);
        btnNext = (Button) view.findViewById(R.id.btn_fst_next);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(secondFragment == null)
                   secondFragment = new SecondFragment();

                Fragment fragment = getFragmentManager().findFragmentByTag("first_frag");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,secondFragment).addToBackStack(null).commitAllowingStateLoss();

                }else {
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, secondFragment).addToBackStack(null).commitAllowingStateLoss();
                }


            }
        });

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtFst.setText("This is change by itself.");
                PopupMenu popupMenu = new PopupMenu(getActivity(),btnChange);
                popupMenu.getMenuInflater().inflate(R.menu.my_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return true;
                    }
                });
                popupMenu.show();

            }
        });



        if(getArguments()!= null){

            txtFst.setText(getArguments().getString("input_string"));
        }


    }
}
