package com.example.keyboarddialphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the listener for EditText
        EditText editText = findViewById(R.id.phone_text);
        if (editText != null) {
            editText.setOnEditorActionListener((v, actionId, event) -> {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    dialNumber();
                    handled = true;
                }
                return handled;
            });
        }
    }

    private void dialNumber() {
        try {
            // Find EditText
            EditText editText = findViewById(R.id.phone_text);
            String phoneNum = null;
            if (editText != null) {
                phoneNum = "tel: " + editText.getText().toString();
            }

            // Implicit intent
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(phoneNum));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.d("Implicit Intent", "Can't handle this");
        }
    }

}