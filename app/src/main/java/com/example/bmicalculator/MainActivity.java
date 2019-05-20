package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public float calculatebmi(int height, int weight){
        float bmi=(float)(weight/((height*height)/10000.0f));
        return bmi;
    }
    public void calculateAndDisplayBMI(View view){
        // To do here:
        // Done- Make this function be called automatically when the user clicks on the button
        // Get the number from height text box, weight textbox
        // Apply the formula
        // Display the result in the BMI text view

        EditText height = (EditText)findViewById(R.id.height_editText);
        EditText weight = (EditText)findViewById(R.id.weight_editText);
        TextView bmi = (TextView)findViewById(R.id.bmi_textView);
        int heightValue = Integer.parseInt(height.getText().toString());
        int weightValue = Integer.parseInt(weight.getText().toString());
        float result = calculatebmi(heightValue, weightValue);
        bmi.setText(String.format("BMI= %.2f",result));
    }
}
