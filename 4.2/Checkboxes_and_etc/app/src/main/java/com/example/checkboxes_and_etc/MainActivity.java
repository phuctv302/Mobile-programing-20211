package com.example.checkboxes_and_etc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CheckBox chocolateCheckBox, sprinkles, crushedNuts, cherries, orioCookieCrumbles;
    ArrayList<String> toppings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find view
        chocolateCheckBox = findViewById(R.id.chocolate_check_box);
        sprinkles = findViewById(R.id.sprinkles_check_box);
        crushedNuts = findViewById(R.id.crushed_nuts_check_box);
        cherries = findViewById(R.id.cherries_check_box);
        orioCookieCrumbles = findViewById(R.id.orio_check_box);

        // Add all checkBoxes to a new array
        CheckBox[] checkBoxes = new CheckBox[]{chocolateCheckBox, sprinkles, crushedNuts, cherries, orioCookieCrumbles};

        // Set the listener for checkBox
        for (CheckBox c : checkBoxes) {
            if (c != null) {
                c.setOnClickListener(v -> {
                    if (c.isChecked()) {
                        String topping = c.getText().toString();
                        toppings.add(topping);
                        displayToast(toppings);
                    } else {
                        String topping = c.getText().toString();
                        toppings.remove(topping);
                        displayToast(toppings);
                    }
                });
            }
        }
    }

    public void displayToast(ArrayList<String> toppings) {
        String message;
        if (toppings.size() != 0)
            message = "Toppings: " + toppings.toString().replace("[", "").replace("]", "");
        else
            message = "Toppings: No topping";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}