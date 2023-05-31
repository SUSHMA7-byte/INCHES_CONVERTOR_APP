package com.example.inches_converter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inchEditText;
    Button buttonCalc;
    TextView lines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
        buttonCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String inchesStr=inchEditText.getText().toString();
                if(inchesStr.isEmpty()){
                    Toast.makeText(MainActivity.this,"Plz Input a value: ",Toast.LENGTH_SHORT).show();
                }
                else{
                    double res = calcHeight(inchesStr);
                    displayResult(res);
                }
            }
        });
    }

    protected void findviews() {

        inchEditText = findViewById(R.id.inch_col);
        buttonCalc = findViewById(R.id.calc);
        lines = findViewById(R.id.line);
    }

    private void displayResult(double res) {
        DecimalFormat decimalFormatter = new DecimalFormat("0.00");
        String TextResult = decimalFormatter.format(res);
        lines.setText(TextResult+ " metres!");
    }

    private double calcHeight(String inchesStr) {
        int inch = Integer.parseInt(inchesStr);
        return (inch*0.0254);
    }




}