package com.example.fragmentapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment {

    TextView txtSnd;

    public static SecondFragment newInstance(String str){
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("input_string",str);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtSnd = (TextView) view.findViewById(R.id.txt_second);
        if(getArguments() != null)
        txtSnd.setText(getArguments().getString("input_string"));
    }
}
