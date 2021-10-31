package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String oldText="";
    String oldNumber="";
    String op="+";
    boolean isNewOp = true;
    private EditText ed1;
    private EditText ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.input);
        ed2=findViewById(R.id.calculus);
    }


    public void numberEvent(View view) {
        if(isNewOp)
            ed1.setText("");
        isNewOp=false;
        String number =ed1.getText().toString();
        switch (view.getId()){
            case R.id.zero:
                number += '0' ;
                break;
            case R.id.one:
                number += '1' ;
                break;
            case R.id.two:
                number += '2' ;
                break;
            case R.id.three:
                number += '3' ;
                break;
            case R.id.four:
                number += '4' ;
                break;
            case R.id.five:
                number += '5' ;
                break;
            case R.id.six:
                number += '6' ;
                break;
            case R.id.seven:
                number += '7' ;
                break;
            case R.id.eight:
                number += '8' ;
                break;
            case R.id.nine:
                number += '9' ;
                break;
            case R.id.point:
                number += '.' ;
                break;
            case R.id.plusMinus:
                number = "-" +number ;
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {

        oldText=ed2.getText().toString();
        isNewOp=true;
        oldNumber=ed1.getText().toString();
        switch (view.getId()){
            case R.id.divide: op="÷"; break;
            case R.id.multiply: op="×"; break;
            case R.id.add: op="+"; break;
            case R.id.subtract: op="-"; break;
        }
        ed2.setText(oldText + oldNumber+op);

    }

    public void equalEvent(View view) {
        String newNumber= ed1.getText().toString();
        int result=0;
        oldText=ed2.getText().toString();
        ed2.setText(oldText+newNumber+"=");
        switch(op) {
            case "+":
                result= Integer.parseInt(oldNumber)+ Integer.parseInt(newNumber);
                break;
            case "-":
                result= Integer.parseInt(oldNumber)- Integer.parseInt(newNumber);
                break;
            case "×":
                result= Integer.parseInt(oldNumber)*Integer.parseInt(newNumber);
                break;
            case "÷":
                result= Integer.parseInt(oldNumber)/Integer.parseInt(newNumber);
                break;
        }
        ed1.setText(result +"");
    }
    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

    public void clearEvent(View view) {
        switch (view.getId()){
            case R.id.clearAll:
                ed1.setText("0");
                ed2.setText("");
                isNewOp=true;
                break;
            case R.id.clearE:
                ed1.setText("0");
                isNewOp=true;
                break;
            case R.id.backspace:
                int textLength=ed1.getText().length();
                String xx;
                if(textLength!=0){
                    xx=removeLastChar(ed1.getText().toString());
                }else xx="0";
                ed1.setText(xx);
                break;
        }
    }
}