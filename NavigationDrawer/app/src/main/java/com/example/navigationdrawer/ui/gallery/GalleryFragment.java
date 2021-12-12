package com.example.navigationdrawer.ui.gallery;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    private Spinner spinner_src, spinner_des;
    private String[] items ={"BIN", "OCT", "DEC", "HEX"};
    private String src="BIN", des="BIN";
    private EditText number;
    private TextView result;
    private int dec;
    String n;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        spinner_src = binding.spinnerSrc;
        spinner_des = binding.spinnerDes;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, items);
        spinner_src.setAdapter(adapter);
        spinner_des.setAdapter(adapter);


        number = binding.number;
        result = binding.result;

        spinner_src.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                src = adapter.getItem(i);
                pro_src();
                pro_des();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_des.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                des = adapter.getItem(i);

                pro_src();
                pro_des();


            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String n=""+number.getText().toString();
                if(n=="") {
                    result.setText("-");
                }else {


                    pro_src();
                    pro_des();

                }


            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });



        return root;
    }

    public void pro_src(){

        if (src.equals("BIN")) {
            try {
                dec = Integer.parseInt(number.getText().toString(), 2);
            }catch(Exception e){
                number.setText("0");
                dec= 0;
            }
        } else if (src.equals("OCT")) {
            try {
                dec = Integer.parseInt(number.getText().toString(), 8);
            }catch(Exception e){
                number.setText("0");
                dec= 0;
            }
        } else if (src.equals("DEC")) {
            try {
                dec = Integer.parseInt(number.getText().toString());
            }catch (Exception e){
                number.setText("0");
                dec=0;
            }
        } else if (src.equals("HEX")) {
            try {
                dec = Integer.parseInt(number.getText().toString(), 16);
            }catch(Exception e){
                number.setText("0");
                dec= 0;
            }
        }

    }
    public void pro_des(){
        if (des.equals("BIN")) {
            result.setText(Integer.toBinaryString(dec));
        } else if (des.equals("OCT")) {
            result.setText(Integer.toOctalString(dec));
        } else if (des.equals("DEC")) {
            result.setText(Integer.toString(dec));
        } else if (des.equals("HEX")) {
            result.setText(Integer.toHexString(dec));
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}