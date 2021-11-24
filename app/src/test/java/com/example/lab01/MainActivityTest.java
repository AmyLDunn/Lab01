package com.example.lab01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class MainActivityTest {

    ArrayList<String> expressionOne, expressionOnePostfix, expressionTwo, expressionTwoPostfix;
    ArrayList<String> expressionThree, expressionFour;

    @Before
    public void setup(){

        expressionOne = new ArrayList<>(); // 3+4*5
        expressionOne.add("3");
        expressionOne.add("+");
        expressionOne.add("4");
        expressionOne.add("*");
        expressionOne.add("5");

        expressionTwo = new ArrayList<>(); // 10-4*6+5/3
        expressionTwo.add("10");
        expressionTwo.add("-");
        expressionTwo.add("4");
        expressionTwo.add("*");
        expressionTwo.add("6");
        expressionTwo.add("+");
        expressionTwo.add("5");
        expressionTwo.add("/");
        expressionTwo.add("3");

        expressionThree = new ArrayList<>(); // 3+*5
        expressionThree.add("3");
        expressionThree.add("+");
        expressionThree.add("*");
        expressionThree.add("5");

        expressionFour = new ArrayList<>(); // 3+4*
        expressionFour.add("3");
        expressionFour.add("+");
        expressionFour.add("4");
        expressionFour.add("*");

    }

    @Test
    public void testGetStringToDisplay(){

        assertEquals("23", MainActivity.getStringToDisplay(expressionOne));
        assertEquals("-12.33333", MainActivity.getStringToDisplay(expressionTwo));
        assertEquals("Error", MainActivity.getStringToDisplay(expressionThree));
        assertEquals("Error", MainActivity.getStringToDisplay(expressionFour));

    }

}
