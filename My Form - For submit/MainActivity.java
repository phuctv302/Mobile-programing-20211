package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void checked(View view) {
        boolean check=true;
        EditText name=findViewById(R.id.name);
        EditText mssv=findViewById(R.id.mssv);
        EditText date=findViewById(R.id.date);
        EditText number=findViewById(R.id.phone);
        EditText email=findViewById(R.id.email);
        System.out.println(mssv.getText().toString().length());
        while (check) {
            if (mssv.getText().toString().length() == 0)
                displayToast("nhap mssv");
            if (name.getText().toString().length() == 0)
                displayToast("nhap ho ten");
            if (date.getText().toString().length() == 0)
                displayToast("nhap ngay sinh");
            if (number.getText().toString().length() == 0)
                displayToast("nhap so dien thoai");
            if (email.getText().toString().length() == 0)
                displayToast("nhap email");
            check=false;
        }
    }
}