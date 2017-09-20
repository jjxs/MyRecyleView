package com.example.myrecyleview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.myrecyleview.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_activity);
        TestFragment mainFragment = new TestFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,mainFragment).commit();
    }
}
