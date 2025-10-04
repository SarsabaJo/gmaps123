package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //OnClickListener implemented for the buttons functions

    // Object declaration for UI components
    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    EditText editTextN1, editTextN2;
    TextView textView;

    // Data Variables
    int num1 = 0, num2 = 0;
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objectInstantiation();
        buttonClickListener();
    }

    public void objectInstantiation(){
        //instantiation of UI components with the Id from the activity_main.xml
        this.buttonAdd = findViewById(R.id.btn_add);
        this.buttonSub = findViewById(R.id.btn_sub);
        this.buttonMul = findViewById(R.id.btn_mul);
        this.buttonDiv = findViewById(R.id.btn_div);

        this.editTextN1 = findViewById(R.id.number1);
        this.editTextN2 = findViewById(R.id.number2);

        this.textView = findViewById(R.id.answer);
    }

    public void buttonClickListener(){
        //applying On Click Listener for the operation buttons
        this.buttonAdd.setOnClickListener(this);
        this.buttonSub.setOnClickListener(this);
        this.buttonMul.setOnClickListener(this);
        this.buttonDiv.setOnClickListener(this);
    }

    // Handle button click events
    @Override
    public void onClick(View view) {
        // input numbers will get stored in these variables
        this.num1 = getIntFromEditText(editTextN1);
        this.num2 = getIntFromEditText(editTextN2);

        calculate(this.textView, this.num1, this.num2, view);
    }

    //function that perform the calculations based on buttons clicked
    public void calculate(TextView textView, int num1, int num2, View view){
        // calculation for the two numbers when a specific button is clicked
        if (view.getId() == R.id.btn_add){
            this.result = num1 + num2;
            textView.setText(getString(R.string.answer_format, String.valueOf(this.result)));
        }

        else if (view.getId() == R.id.btn_sub){
            this.result = num1 - num2;
            textView.setText(getString(R.string.answer_format, String.valueOf(this.result)));
        }

        else if (view.getId() == R.id.btn_mul){
            this.result = num1 * num2;
            textView.setText(getString(R.string.answer_format, String.valueOf(this.result)));
        }

        else if (view.getId() == R.id.btn_div){
            if(num2 == 0)
                textView.setText(R.string.division_by_zero);

            else{
                this.result = (float)num1 / (float)num2;
                textView.setText(getString(R.string.answer_format, String.valueOf(this.result)));
            }

        }
    }

    //function to get integer value from EditText
    public int getIntFromEditText(EditText editText){
        if(editText.getText().toString().isEmpty()){
            Toast.makeText( this, R.string.enter_number, Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Integer.parseInt(editText.getText().toString());
        // return the input number
    }
}