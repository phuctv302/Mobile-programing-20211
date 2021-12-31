package com.phuctv.implicitintentsreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView showUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showUri = findViewById(R.id.show_uri);

        /*
         * Process Intent received from Implicit Intent app
         * */
        // Get Uri received
        Uri uri = getIntent().getData();

        if (uri != null) {
            // Create String from Uri
            String uriString = "URI: " + uri.toString();

            // Show URI in a TextView
            showUri.setText(uriString);
        }

    }
}