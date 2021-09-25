package com.example.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                // If the display already is a "0", we don't want to print "00".
                if ( display.getText().equals("0") ){
                    display.setText("0");
                    // Otherwise we add "0" to the right-side of the number
                } else {
                    display.setText(display.getText() + "0");
                }
            }
        });

        //Button 1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // If the display is "0", we replace it with this number because "01" doesn't make sense
                if ( display.getText().equals("0") ){
                    display.setText("1");
                    // Otherwise we add "1" to the right-side of the number
                } else {
                    display.setText(display.getText()+"1");
                }
            }
        });

        //Button 2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // If the display is "0", we replace it with this number because "02" doesn't make sense
                if ( display.getText().equals("0") ){
                    display.setText("2");
                } else {
                    // Otherwise we add "2" to the right-side of the number
                    display.setText(display.getText()+"2");
                }
            }
        });

        //Button 3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // If the display is "0", we replace it with this number because "02" doesn't make sense
                if ( display.getText().equals("0") ){
                    display.setText("3");
                } else {
                    // Otherwise we add "3" to the right-side of the number
                    display.setText(display.getText()+"3");
                }
            }
        });

        //Button 4
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // If the display is "0", we replace it with this number because "04" doesn't make sense
                if ( display.getText().equals("0") ){
                    display.setText("4");
                } else {
                    // Otherwise we add "4" to the right-side of the number
                    display.setText(display.getText()+"4");
                }
            }
        });

        //Button 5
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // If the display is "0", we replace it with this number because "05" doesn't make sense
                if ( display.getText().equals("0") ){
                    display.setText("5");
                } else {
                    // Otherwise we add "5" to the right-side of the number
                    display.setText(display.getText()+"5");
                }
            }
        });

        //Button 6
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // If the display is "0", we replace it with this number because "06" doesn't make sense
                if ( display.getText().equals("0") ){
                    display.setText("6");
                } else {
                    // Otherwise we add "6" to the right-side of the number
                    display.setText(display.getText()+"6");
                }
            }
        });

        //Button 7
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // If the display is "0", we replace it with this number because "07" doesn't make sense
                if ( display.getText().equals("0") ){
                    display.setText("7");
                } else {
                    // Otherwise we add "7" to the right-side of the number
                    display.setText(display.getText()+"7");
                }
            }
        });

        //Button 8
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // If the display is "0", we replace it with this number because "08" doesn't make sense
                if ( display.getText().equals("0") ){
                    display.setText("8");
                } else {
                    // Otherwise we add "8" to the right-side of the number
                    display.setText(display.getText()+"8");
                }
            }
        });

        //Button 9
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // If the display is "0", we replace it with this number because "09" doesn't make sense
                if ( display.getText().equals("0") ){
                    display.setText("9");
                } else {
                    // Otherwise we add "9" to the right-side of the number
                    display.setText(display.getText()+"9");
                }
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
                return;
            }
        });

        //Button subtract
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                return;
            }
        });

        //Button multiply
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                return;
            }
        });

        //Button divide
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                return;
            }
        });

        //Button equals
        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                return;
            }
        });

        //Button clear
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clears the screen. Do we need to also clear the saved operations and numbers?
                display.setText("");
            }
        });
    }
}