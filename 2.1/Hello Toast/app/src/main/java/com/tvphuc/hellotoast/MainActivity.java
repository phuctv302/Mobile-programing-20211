package com.tvphuc.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String COUNT_MESSAGE = "com.tvphuc.main.countMessage";
    private int mCount;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.show_count);

    }

    public void sayHello(View view) {
        Intent intent = new Intent(this, HelloActivity.class);
        intent.putExtra(COUNT_MESSAGE, mCount);
        startActivity(intent);
    }

    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}