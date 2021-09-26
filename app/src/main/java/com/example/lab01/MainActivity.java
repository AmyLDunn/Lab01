package com.example.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*

    Remove the following issues when they're solved (or add to the list if you find some):

    - The first time you press an operator it won't show up on the screen. It still works,
      but you just can't see it.

    - You can see what the correct answer is, but they're smaller than they should be (e.g.
      6 + 6 = 0.12, 9 * 9 = 0.0081)

    - I don't know how to get it to only display one operator (e.g. when you press 1 +, and
      then press -, the text should ONLY display 1 -, but it will display 1 +- ...)

    - When you press (operand) (operator) (equals) it produces a value. The equal button
      should not do anything if only one value exists.

    There are probably plenty of more errors, but these are the ones I could find.

 */

public class MainActivity extends AppCompatActivity {

    //Buttons used to input numbers, operations, etc
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
            btn9, btnAdd, btnDiv, btnMul, btnClr, btnSub, btnEql,
            btnDec;

    //Calculator display
    TextView display;

    //Values used in calculator operations
    double val1, val2;

    //Boolean values that will determine what operation is requested
    boolean add, mul, div, sub;

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

        //Button 0
        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //Determining if the number will be a part of val1 or val2
                if (add == false && div == false && mul == false && sub == false) {
                    val1 = Double.parseDouble( String.valueOf(val1) + "0");
                } else {
                    val2 = Double.parseDouble( String.valueOf(val2) + "0");
                }

                addOperand("0");
            }
        });

        //Button 1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Determining if the number will be a part of val1 or val2
                if (add == false && div == false && mul == false && sub == false) {
                    val1 = Double.parseDouble( String.valueOf(val1) + "1");
                } else {
                    val2 = Double.parseDouble( String.valueOf(val2) + "1");
                }

                addOperand("1");
            }
        });

        //Button 2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Determining if the number will be a part of val1 or val2
                if (add == false && div == false && mul == false && sub == false) {
                    val1 = Double.parseDouble( String.valueOf(val1) + "2");
                } else {
                    val2 = Double.parseDouble( String.valueOf(val2) + "2");
                }

                addOperand("2");
            }
        });

        //Button 3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Determining if the number will be a part of val1 or val2
                if (add == false && div == false && mul == false && sub == false) {
                    val1 = Double.parseDouble( String.valueOf(val1) + "3");
                } else {
                    val2 = Double.parseDouble( String.valueOf(val2) + "3");
                }

                addOperand("3");
            }
        });

        //Button 4
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Determining if the number will be a part of val1 or val2
                if (add == false && div == false && mul == false && sub == false) {
                    val1 = Double.parseDouble( String.valueOf(val1) + "4");
                } else {
                    val2 = Double.parseDouble( String.valueOf(val2) + "4");
                }

                addOperand("4");
            }
        });

        //Button 5
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Determining if the number will be a part of val1 or val2
                if (add == false && div == false && mul == false && sub == false) {
                    val1 = Double.parseDouble( String.valueOf(val1) + "5");
                } else {
                    val2 = Double.parseDouble( String.valueOf(val2) + "5");
                }

                addOperand("5");
            }
        });

        //Button 6
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Determining if the number will be a part of val1 or val2
                if (add == false && div == false && mul == false && sub == false) {
                    val1 = Double.parseDouble( String.valueOf(val1) + "6");
                } else {
                    val2 = Double.parseDouble( String.valueOf(val2) + "6");
                }

                addOperand("6");
            }
        });

        //Button 7
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Determining if the number will be a part of val1 or val2
                if (add == false && div == false && mul == false && sub == false) {
                    val1 = Double.parseDouble( String.valueOf(val1) + "7");
                } else {
                    val2 = Double.parseDouble( String.valueOf(val2) + "7");
                }

                addOperand("7");
            }
        });

        //Button 8
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Determining if the number will be a part of val1 or val2
                if (add == false && div == false && mul == false && sub == false) {
                    val1 = Double.parseDouble( String.valueOf(val1) + "8");
                } else {
                    val2 = Double.parseDouble( String.valueOf(val2) + "8");
                }

                addOperand("8");
            }
        });

        //Button 9
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Determining if the number will be a part of val1 or val2
                if (add == false && div == false && mul == false && sub == false) {
                    val1 = Double.parseDouble( String.valueOf(val1) + "9");
                } else {
                    val2 = Double.parseDouble( String.valueOf(val2) + "9");
                }

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

                //Letting system which operator is in use
                addOperator("+");
                add = true;
                mul = false;
                div = false;
                sub = false;

            }
        });

        //Button subtract
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Letting system which operator is in use
                addOperator("-");
                add = false;
                mul = false;
                div = false;
                sub = true;

            }
        });

        //Button multiply
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Letting system which operator is in use
                addOperator("*");
                add = false;
                mul = true;
                div = false;
                sub = false;

            }
        });

        //Button divide
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Letting system which operator is in use
                addOperator("/");
                add = false;
                mul = false;
                div = true;
                sub = false;

                //

            }
        });

        //Button equals
        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Determining which operator will be used
                if (add) {
                    val1 = val1 + val2;
                } else if (div) {
                    val1 = val1 / val2;
                } else if (mul) {
                    val1 = val1 * val2;
                } else if (sub) {
                    val1 = val1 - val2;
                }

                //Resetting val2
                val2 = 0;

                //Displaying the new value
                display.setText("" + val1);

            }
        });

        //Button clear
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clears the screen. Do we need to also clear the saved operations and numbers?
                display.setText("");

                //Clearing operators
                add = false;
                div = false;
                mul = false;
                sub = false;

                //Clearing operands
                val1 = 0;
                val2 = 0;
            }
        });
    }

    private void addOperand(String num){
        if ( display.getText().equals("0") ){
            display.setText(num);
        } else {
            // Otherwise we add num to the right-side of the number
            display.setText(display.getText()+num);
        }
    }

    private void addOperator(String operator) {
        if (!display.getText().equals("")) {
            if (add) {
                display.setText(display.getText() + operator);
            } else if (mul) {
                display.setText(display.getText() + operator);
            } else if (div) {
                display.setText(display.getText() + operator);
            } else if (sub) {
                display.setText(display.getText() + operator);
            }

        }
    }
}