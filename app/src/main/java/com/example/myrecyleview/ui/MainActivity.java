package com.example.myrecyleview.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myrecyleview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,mainFragment).commit();
    }
}
