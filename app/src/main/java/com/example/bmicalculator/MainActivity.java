package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        // Initially reset the output display
        TextView category = findViewById(R.id.category_textView);
        category.setText("");

        EditText heightEditText = (EditText)findViewById(R.id.height_editText);
        EditText weightEditText = (EditText)findViewById(R.id.weight_editText);
        TextView bmi = (TextView)findViewById(R.id.bmi_textView);

        // Reset the BMI text. This will be useful when the user input is not valid.00
        bmi.setText("BMI = --.--");
        String height = heightEditText.getText().toString();
        String weight = weightEditText.getText().toString();

        // Check whether if either of Height or Weight is empty, if empty
        // display appropriate error messages.
        if(height.equalsIgnoreCase("")) {
            heightEditText.setError("Height can't be empty");
            return;
        }
        if(weight.equalsIgnoreCase("")) {
            weightEditText.setError("Weight can't be empty");
            return;
        }
        int heightValue = Integer.parseInt(height);
        int weightValue = Integer.parseInt(weight);
        if(heightValue == 0) {
            heightEditText.setError("Height can't be zero");
            return;
        }
        if(weightValue == 0) {
            weightEditText.setError("Weight can't be zero");
            return;
        }
        float result = calculatebmi(heightValue, weightValue);
        bmi.setText(String.format("BMI = %.2f",result));
        displayBmiCategory(result);
    }

    public void displayBmiCategory(float bmi) {
        TextView category = findViewById(R.id.category_textView);
        if(bmi < 18.5f) {
            category.setText("Underweight");
        }
        else if(bmi >= 18.5f && bmi <= 25) {
            category.setText("Normal weight");
        }
        else if(bmi > 25f && bmi <= 30) {
            category.setText("Over-weight");
        }
        else if(bmi > 30) {
            category.setText("Obese");
        }
    }
}
