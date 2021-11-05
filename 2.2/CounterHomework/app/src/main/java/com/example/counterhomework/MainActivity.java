package com.example.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView countTextview;
    private Button countButton;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countButton = findViewById(R.id.button_count);
        countTextview = findViewById((R.id.count_textview));

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count_text", 0);
            countTextview.setText(String.valueOf(count));
        }

        countButton.setOnClickListener(view -> {
            count++;
            countTextview.setText(String.valueOf(count));
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count_text", count);
    }
}