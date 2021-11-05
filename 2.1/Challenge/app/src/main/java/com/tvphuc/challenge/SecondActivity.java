package com.tvphuc.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView mPassageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mPassageTextView = findViewById(R.id.passage_text_view);

        Intent intent = getIntent();
        String passage = intent.getStringExtra(MainActivity.EXTRA_PASSAGE);
        mPassageTextView.setText(passage);
    }
}