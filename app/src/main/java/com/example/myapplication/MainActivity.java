package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // Setup button angka
        setNumberClickListener(R.id.btn0, "0");
        setNumberClickListener(R.id.btn1, "1");
        setNumberClickListener(R.id.btn2, "2");
        setNumberClickListener(R.id.btn3, "3");
        setNumberClickListener(R.id.btn4, "4");
        setNumberClickListener(R.id.btn5, "5");
        setNumberClickListener(R.id.btn6, "6");
        setNumberClickListener(R.id.btn7, "7");
        setNumberClickListener(R.id.btn8, "8");
        setNumberClickListener(R.id.btn9, "9");

        // Setup button operasi
        setOperatorClickListener(R.id.btnPlus, "+");
        setOperatorClickListener(R.id.btnMinus, "-");
        setOperatorClickListener(R.id.btnMultiply, "*");
        setOperatorClickListener(R.id.btnDivide, "/");

        // Setup button hasil
        findViewById(R.id.btnEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondNumber = Double.parseDouble(display.getText().toString());
                double result = 0;

                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = firstNumber / secondNumber;
                        break;
                }

                display.setText(String.valueOf(result));
                isOperatorClicked = false;
            }
        });

        // Setup button hapus
        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("0");
                firstNumber = 0;
                secondNumber = 0;
                operator = "";
                isOperatorClicked = false;
            }
        });
    }

    private void setNumberClickListener(int buttonId, final String number) {
        findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOperatorClicked) {
                    display.setText(number);
                    isOperatorClicked = false;
                } else {
                    display.setText(display.getText().toString().equals("0") ? number : display.getText() + number);
                }
            }
        });
    }

    private void setOperatorClickListener(int buttonId, final String op) {
        findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNumber = Double.parseDouble(display.getText().toString());
                operator = op;
                isOperatorClicked = true;
            }
        });
    }
}
