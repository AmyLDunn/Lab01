package com.example.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Buttons used to input numbers, operations, etc
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
            btn9, btnAdd, btnDiv, btnMul, btnClr, btnSub, btnEql,
            btnDec;

    //Calculator display
    TextView display, expressionDisplay;

    //Values used in calculator operations
    //double val1, val2;

    //ArrayList to hold the equation
    ArrayList<String> equation = new ArrayList<String>();

    //Boolean values that will determine what operation is requested
    //boolean add, mul, div, sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Defaults
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        //Operators
        btnAdd = findViewById(R.id.btnAdd);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnSub = findViewById(R.id.btnSub);
        btnDec = findViewById(R.id.btnDec);
        btnClr = findViewById(R.id.btnClr);
        btnEql = findViewById(R.id.btnEql);

        //Display
        display = findViewById(R.id.display);
        expressionDisplay = findViewById(R.id.expressiondisplay);

        //Button 0
        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addOperand("0");
            }
        });

        //Button 1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addOperand("1");
            }
        });

        //Button 2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addOperand("2");
            }
        });

        //Button 3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addOperand("3");
            }
        });

        //Button 4
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addOperand("4");
            }
        });

        //Button 5
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addOperand("5");
            }
        });

        //Button 6
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addOperand("6");
            }
        });

        //Button 7
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addOperand("7");
            }
        });

        //Button 8
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addOperand("8");
            }
        });

        //Button 9
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addOperand("9");
            }
        });

        //Button decimal
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( display.getText().equals("") ){
                    // If the display is empty, pressing a decimal should display "0."
                    display.setText("0.");
                } else {
                    // Otherwise we add "." to the right-side of the number
                    display.setText(display.getText()+".");
                }
            }
        });

        //Button add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperator("+");
            }
        });

        //Button subtract
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( display.getText().equals("") ) {
                    display.setText(display.getText()+"-");
                } else {
                    addOperator("-");
                }
            }
        });

        //Button multiply
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperator("*");
            }
        });

        //Button divide
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperator("/");
            }
        });

        //Button equals
        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!display.getText().equals("")) {
                    expressionDisplay.setText(expressionDisplay.getText()+display.getText().toString()+" = ");
                    equation.add(display.getText().toString());
                } else {
                    expressionDisplay.setText(expressionDisplay.getText()+" = ");
                }
                if ( PostfixCalculator.validExpression(equation) ) {
                    double answer = PostfixCalculator.calculateFromPostfix(PostfixCalculator.changeToPostfix(equation));
                    display.setText(String.valueOf(answer));
                }
            }
        });

        //Button clear
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearScreen();
            }
        });
    }


    private void clearScreen(){
        display.setText("");
        equation = new ArrayList<String>();
        expressionDisplay.setText("");
    }

    private void addOperand(String num){
        if ( display.getText().equals("0") ){
            display.setText(num);
        } else {
            display.setText(display.getText()+num);
        }
    }

    private void addOperator(String operator) {
        if (!display.getText().equals("")) {
            expressionDisplay.setText(expressionDisplay.getText()+display.getText().toString()+" "+operator+" ");
            equation.add(display.getText().toString());
            equation.add(operator);
            display.setText("");
        }
    }
}