package com.example.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContainerActivity extends AppCompatActivity {

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private Button btnShift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

       firstFragment = FirstFragment.newInstance("This is test!!");
       secondFragment = SecondFragment.newInstance("This is Second test");

       btnShift = (Button) findViewById(R.id.btn_shift);

       btnShift.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,secondFragment).commitAllowingStateLoss();
           }
       });

        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,firstFragment).commitAllowingStateLoss();

    }
}
