package com.example.navigationdrawer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private TextView calculation, result;
    private String curr, res;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnCE, btnC, btnAdd, btnSub, btnMulti, btnDiv, btnEqual, btnSigned;
    private ImageButton btnBackSpace;
    private int signed;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        calculation = binding.caculation;
        result = binding.result;

        curr="";
        res="";
        signed=0;


        btn0 = binding.btn0;
        btn1 = binding.btn1;
        btn2 = binding.btn2;
        btn3 = binding.btn3;
        btn4 = binding.btn4;
        btn5 = binding.btn5;
        btn6 = binding.btn6;
        btn7 = binding.btn7;
        btn8 = binding.btn8;
        btn9 = binding.btn9;
        btnCE = binding.btnCE;
        btnC = binding.btnC;
        btnBackSpace = binding.btnBackspace;
        btnAdd = binding.btnAdd;
        btnSub = binding.btnSub;
        btnMulti = binding.btnMulti;
        btnDiv = binding.btnDiv;
        btnSigned = binding.btnSigned;
        btnEqual = binding.btnEqual;

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(res!="") {
                    res = res + "0";
                    displayTwo();
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"1";
                displayTwo();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"2";
                displayTwo();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"3";
                displayTwo();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"4";
                displayTwo();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"5";
                displayTwo();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"6";
                displayTwo();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"7";
                displayTwo();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"8";
                displayTwo();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"9";
                displayTwo();
            }
        });
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayCE();
                displayOne();
                displayTwo();
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayC();
                displayTwo();
                displayOne();
            }
        });
        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayBackspace();
                displayTwo();
            }
        });
        btnSigned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaySigned();
                displayTwo();
            }

        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                curr=res+" + ";
                res="";

                displayOne();
                displayTwo();

            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                curr=res+" - ";
                res="";

                displayOne();
                displayTwo();

            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                curr=res+" × ";
                res="";

                displayOne();
                displayTwo();

            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                curr=res+" ÷ ";
                res="";

                displayOne();
                displayTwo();

            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+res+" = ";
                String[] tokens = curr.split(" ");
                switch (tokens[1].charAt(0)){
                    case '+':
                        res=Double.toString(Double.parseDouble(tokens[0])+Double.parseDouble(tokens[2]));
                        break;
                    case '-':
                        res=Double.toString(Double.parseDouble(tokens[0])-Double.parseDouble(tokens[2]));
                        break;
                    case '×':
                        res=Double.toString(Double.parseDouble(tokens[0])*Double.parseDouble(tokens[2]));
                        break;
                    case '÷':
                        res=Double.toString(Double.parseDouble(tokens[0])/Double.parseDouble(tokens[2]));
                        break;
                }
                displayOne();
                displayTwo();
            }

        });




        return root;
    }

    public void displayOne(){
        calculation.setText(curr);

    }

    public void displayTwo(){
        result.setText(res);
    }

    public void displayCE(){
        res = "";
    }

    public void displayC(){
        curr = "";
        res = "";
    }

    public void displayBackspace(){
        if(!res.isEmpty()){
            res = res.substring(0, res.length()-1);
        }
    }
    public void displaySigned(){
        signed++;
        if(res!="") {
            if (signed % 2 == 1)
                res = "-" + res;
            else res = res.substring(1, res.length());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}