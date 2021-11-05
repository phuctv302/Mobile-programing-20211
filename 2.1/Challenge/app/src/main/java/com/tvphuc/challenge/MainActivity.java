package com.tvphuc.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_PASSAGE = "com.tvphuc.PASSAGE";
    private String passage;

    private Button button1;
    private Button button2;
    private Button button3;
/*
    public String getPassageNumber(int buttonNum) {
        String passage = null;
        if (buttonNum == 1) {
            passage = getResources().getString(R.string.passage1);
        } else if (buttonNum == 2) {
            passage = getResources().getString(R.string.passage2);
        } else if (buttonNum == 3) {
            passage = getResources().getString(R.string.passage3);
        }
        return passage;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button_text1);
        button2 = findViewById(R.id.button_text2);
        button3 = findViewById(R.id.button_text3);

        /*button1.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            passage = getPassageNumber(1);
            intent.putExtra(EXTRA_PASSAGE, passage);
            startActivity(intent);
        });

        button2.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            passage = getPassageNumber(2);
            intent.putExtra(EXTRA_PASSAGE, passage);
            startActivity(intent);
        });

        button3.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            passage = getPassageNumber(3);
            intent.putExtra(EXTRA_PASSAGE, passage);
            startActivity(intent);
        });*/
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        if (button1.isPressed()) {
            passage = getResources().getString(R.string.passage1);
        } else if (button2.isPressed()) {
            passage = getResources().getString(R.string.passage2);
        } else if (button3.isPressed()) {
            passage = getResources().getString(R.string.passage3);
        }

        intent.putExtra(EXTRA_PASSAGE, passage);
        startActivity(intent);
    }
}