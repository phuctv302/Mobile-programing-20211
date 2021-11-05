package com.tvphuc.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {
    private TextView mShowCount;
    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        mShowCount = findViewById(R.id.count_textview);

        Intent intent = getIntent();
        mCount = intent.getIntExtra(MainActivity.COUNT_MESSAGE, 0);

        mShowCount.setText(String.valueOf(mCount));
    }
}