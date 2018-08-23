package com.example.android.smile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.smile.AlphabetFragment;
import com.example.android.smile.R;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new NumberFragment())
                .commit();
    }
}