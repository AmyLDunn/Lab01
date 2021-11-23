package com.example.lab01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PostfixCalculatorTest {

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

        expressionOnePostfix = new ArrayList<>(); // 3 4 5 * +
        expressionOnePostfix.add("3");
        expressionOnePostfix.add("4");
        expressionOnePostfix.add("5");
        expressionOnePostfix.add("*");
        expressionOnePostfix.add("+");

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

        expressionTwoPostfix = new ArrayList<>(); // 10 4 6 * - 5 3 / +
        expressionTwoPostfix.add("10");
        expressionTwoPostfix.add("4");
        expressionTwoPostfix.add("6");
        expressionTwoPostfix.add("*");
        expressionTwoPostfix.add("-");
        expressionTwoPostfix.add("5");
        expressionTwoPostfix.add("3");
        expressionTwoPostfix.add("/");
        expressionTwoPostfix.add("+");

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
    public void testValidExpression() {

        assertTrue("Valid expression test 3+4*5 failed", PostfixCalculator.validExpression(expressionOne));
        assertTrue("Valid expression test 10-4*6+5/3 failed", PostfixCalculator.validExpression(expressionTwo));
        assertFalse("Invalid expression test 2 adjacent operators failed", PostfixCalculator.validExpression(expressionThree));
        assertFalse("Invalid expression test ending with operator failed", PostfixCalculator.validExpression(expressionFour));

    }

    @Test
    public void testChangeToPostfix(){

        assertEquals("Infix to postfix test one failed", expressionOnePostfix, PostfixCalculator.changeToPostfix(expressionOne));
        assertEquals("Infix to postfix test two failed", expressionTwoPostfix, PostfixCalculator.changeToPostfix(expressionTwo));

    }

    @Test
    public void testCalculateFromPostfix(){
        double answer;

        answer = PostfixCalculator.calculateFromPostfix(expressionOnePostfix);
        assertEquals("Calculate from postfix test one failed", 23.0, answer, 0.001);
        answer = PostfixCalculator.calculateFromPostfix(expressionTwoPostfix);
        assertEquals("Calculate from postfix test two failed", -12.333333, answer, 0.001);

    }

}