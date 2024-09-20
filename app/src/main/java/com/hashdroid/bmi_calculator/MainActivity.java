package com.hashdroid.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtWeight, ftHeight, inHeight;
        TextView txtResults;
        Button btnCalculate;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        ftHeight = findViewById(R.id.ftHeight);
        inHeight = findViewById(R.id.inHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResults = findViewById(R.id.txtResults);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(view -> {
            int weight = Integer.parseInt(edtWeight.getText().toString());
            int ft = Integer.parseInt(ftHeight.getText().toString());
            int in = Integer.parseInt(inHeight.getText().toString());

            int totalInches = ft*12 + in;
            double totalCentimeters = totalInches*2.53;
            double totalMeters = totalCentimeters/100;

            double bmi = weight / (totalMeters*totalMeters);

            if(bmi>25){
                txtResults.setText("You're OVERWEIGHT");
                llMain.setBackgroundColor(getResources().getColor(R.color.color_OV));
            }
            else if(bmi<18){
                txtResults.setText("You're UNDERWEIGHT");
                llMain.setBackgroundColor(getResources().getColor(R.color.color_UW));
            }
            else{
                txtResults.setText("You're HEALTHY");
                llMain.setBackgroundColor(getResources().getColor(R.color.color_Hl));
            }
        });
    }
}