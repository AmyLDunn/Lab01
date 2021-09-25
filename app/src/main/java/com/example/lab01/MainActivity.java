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
            btnDec, btnOpn, btnCls, btnExp, btnDel;

    //Calculator display
    TextView display, expressionDisplay;

    //ArrayList to hold the expression
    ArrayList<String> expression = new ArrayList<String>();

    //Booleans to show if the display is an error or a result
    boolean errorDis, resultDis;

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
        btnOpn = findViewById(R.id.btnOpn);
        btnCls = findViewById(R.id.btnCls);
        btnAdd = findViewById(R.id.btnAdd);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnSub = findViewById(R.id.btnSub);
        btnDec = findViewById(R.id.btnDec);
        btnClr = findViewById(R.id.btnClr);
        btnEql = findViewById(R.id.btnEql);
        btnExp = findViewById(R.id.btnExp);
        btnDel = findViewById(R.id.btnDel);

        //Display
        display = findViewById(R.id.display);
        expressionDisplay = findViewById(R.id.expression);

        // Button (
        btnOpn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addOperator("(");
            }
        });

        // Button )
        btnCls.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addOperator(")");
            }
        });

        //Button 0
        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addDigit("0");
            }
        });

        //Button 1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addDigit("1");
            }
        });

        //Button 2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addDigit("2");
            }
        });

        //Button 3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addDigit("3");
            }
        });

        //Button 4
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addDigit("4");
            }
        });

        //Button 5
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addDigit("5");
            }
        });

        //Button 6
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addDigit("6");
            }
        });

        //Button 7
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addDigit("7");
            }
        });

        //Button 8
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addDigit("8");
            }
        });

        //Button 9
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addDigit("9");
            }
        });

        //Button decimal
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Can't use the addDigit method because we have two possible outputs: "0." or "."
                if ( resultDis || errorDis ){
                    clearAll();
                }
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
                if ( display.getText().equals("")){
                    display.setText("-");
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

        //Button exponent
        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperator("^");
            }
        });

        //Button equals
        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( display.getText().equals("") ) {
                    expressionDisplay.setText(expressionDisplay.getText()+"=");
                } else {
                    expression.add(display.getText().toString());
                    expressionDisplay.setText(expressionDisplay.getText()+display.getText().toString()+" = ");
                }
                if (PostfixCalculator.validExpression(expression)) {
                    double answer = PostfixCalculator.calculateFromPostfix(PostfixCalculator.changeToPostfix(expression));
                    if (answer % 1 == 0) {
                        display.setText(String.valueOf((int) answer));
                    } else {
                        display.setText(String.valueOf(answer));
                    }
                    resultDis = true;
                } else {
                    setError();
                }
            }
        });

        //Button clear
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clears the screen. Do we need to also clear the saved operations and numbers?
                clearAll();
            }
        });
    }

    private void addDigit(String digit){
        if ( resultDis || errorDis ){
            clearAll();
        }
        // If the display already is a "0", we don't want to print "00"
        if ( display.getText().equals("0") ){
            display.setText(digit);
            // Otherwise we add "0" to the right-side of the number
        } else {
            display.setText(display.getText() + digit);
        }
    }

    private void addOperator(String operator){
        if (resultDis || errorDis){
            clearAll();
        }
        if ( !display.getText().equals("")) {
            expression.add(display.getText().toString());
            expression.add(operator);
            expressionDisplay.setText(expressionDisplay.getText() + display.getText().toString() + " " + operator + " ");
            display.setText("");
        } else {
            expression.add(operator);
            expressionDisplay.setText(expressionDisplay.getText() + " " + operator + " ");
            display.setText("");
        }
    }

    private void setError(){
        display.setText("ERROR");
        errorDis = true;
    }

    private void clearAll(){
        display.setText("");
        expressionDisplay.setText("");
        expression = new ArrayList<String>();
        errorDis = resultDis = false;
    }
}