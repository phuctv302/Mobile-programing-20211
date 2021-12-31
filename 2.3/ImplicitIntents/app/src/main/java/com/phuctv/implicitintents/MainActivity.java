package com.phuctv.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText enterWebsite;
    private EditText enterLocation;
    private EditText enterSharedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterWebsite = findViewById(R.id.enter_website);
        enterLocation = findViewById(R.id.enter_location);
        enterSharedText = findViewById(R.id.enter_shared_text);
    }

    public void openWebsite(View view) {
        // Get data
        String websiteString = enterWebsite.getText().toString().trim();

        // Parse data into Uri
        Uri websiteUri = Uri.parse(websiteString);

        // Intent to perform view action
        Intent intent = new Intent(Intent.ACTION_VIEW, websiteUri);

        // start activity
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException err) {
            displaySnackBar(err.getMessage());
        }
    }

    public void openLocation(View view) {
        // Get data
        String location = enterLocation.getText().toString().trim();

        // Parse location into Uri with geo query
        Uri locationUri  = Uri.parse("geo:0,0?q=" + location);

        // Intent to perform view action
        Intent intent = new Intent(Intent.ACTION_VIEW, locationUri);

        // Start activity
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException err) {
            displaySnackBar(err.getMessage());
        }
    }

    public void shareText(View view) {
        // Get data string
        String text = enterSharedText.getText().toString().trim();

        // Define mimetype
        String mimetype = "text/plain";

        // Start activity
        new ShareCompat.IntentBuilder(this)
                .setType(mimetype)
                .setChooserTitle(R.string.chooser_title)
                .setText(text)
                .startChooser(); // show system chooser and send intent
    }

    public void displaySnackBar(String message) {
        Snackbar.make(enterWebsite, message, Snackbar.LENGTH_SHORT).show();
    }
}