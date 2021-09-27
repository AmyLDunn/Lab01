package com.example.lab01;

import android.util.Log;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;


/*
 * This class has three methods that each take an ArrayList form of an equation.
 * validExpression checks if the equation is valid (not something weird like (3+)5 )
 * changeToPostFix changes the ArrayList to postfix form
 * calculateFromPostFix calculates the answer from the postfix form
 *
 * Example input: ArrayList of Strings in the form ["(", "3", "+", "5", ")", "^", "6", "-", "4"]
 *                                                  (3+5)^6-4
 *
 */

public class PostfixCalculator {

    public static boolean validExpression(ArrayList<String> function) {

        // Stack to hold the brackets. Making sure that the open brackets match the closing brackets
        Stack<String> bracketStack = new Stack<String>();
        // Last thing added
        String lastPart = "";
        // If the function is empty, it is valid
        if ( function.size() == 0 ) {
            return true;
        }
        // If the last part of the function is an operator, it is not a valid function
        String last = function.get(function.size()-1);
        if ( last.equals("+") || last.equals("-") || last.equals("*") || last.equals("/") || last.equals("^") ) {
            return false;
        }
        for ( String i: function ) {
            Log.e("Last part", ": "+lastPart);
            if ( i.equals("(") ) {
                try {
                    Double.parseDouble(lastPart);
                    return false;
                } catch (Exception e) {
                    bracketStack.push(i);
                    lastPart = i;
                }
            } else if ( i.equals(")") ) {
                // If the current part is a close bracket and there are no open brackets saved, it is invalid
                if ( bracketStack.empty() ) {
                    return false;
                    // If the current part is an close bracket and the top of the stack is also a close bracket,
                    // then the brackets are improperly closed
                } else if ( bracketStack.pop().equals(")") ) {
                    return false;
                    // If the last part was an operator just before this closing bracket, it's not a good expression
                } else if ( lastPart.equals("+") || lastPart.equals("-") || lastPart.equals("*") || lastPart.equals("/") || lastPart.equals("^") ) {
                    return false;
                }
            } else if ( i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/") || i.equals("^") ) {
                // If an operator is found immediately after an opening bracket, it's not a good expression
                if ( lastPart.equals("(") ) {
                    return false;
                    // If two operators are next to each other, it's not a good expression
                } else if ( lastPart.equals("+") || lastPart.equals("-") || lastPart.equals("*") || lastPart.equals("/") || lastPart.equals("^") ) {
                    return false;
                }
                lastPart = i;
            } else {
                if ( lastPart.equals(")")){
                    return false;
                } else if ( lastPart.equals("/") && i.equals("0") ) {
                    return false;
                }
                lastPart = i;
            }
        }
        // If the bracketStack has items remaining (there are open brackets that haven't been closed), it is not good
        if ( !bracketStack.empty() ) {
            return false;
        }
        return true;

    }

    public static ArrayList<String> changeToPostfix(ArrayList<String> function) {

        // This hashtable holds the BEDMASS priority order
        Hashtable<String, Integer> priority = new Hashtable<String, Integer>();
        priority.put("^", 4);
        priority.put("*", 3);
        priority.put("/", 3);
        priority.put("+", 2);
        priority.put("-", 2);
        priority.put("(", 1);

        // This stack will hold the operators
        Stack<String> operatorStack = new Stack<String>();

        // This arraylist holds the postfix expression
        ArrayList<String> postfix = new ArrayList<String>();

        for ( String i: function ) {

            try {
                // If this part is a valid number, add it to the postfix expression
                double value = Double.parseDouble(i);
                postfix.add(i);
            } catch ( NumberFormatException e ) {
                // If the current part is an opening bracket, push it to the top of the stack
                if ( i.equals("(") ) {
                    operatorStack.push(i);
                    // If the current part is a closing bracket, pop all the operators and add them to the postfix
                    // expression until popping the associated open bracket
                } else if ( i.equals(")") ) {
                    String topOperator = operatorStack.pop();
                    while ( !topOperator.equals("(") ) {
                        postfix.add(topOperator);
                        topOperator = operatorStack.pop();
                    }
                    // All other operators
                } else {
                    // If there's something that's in the operatorStack that has a higher priority than the current
                    // part, pop it and add it to the postfix expression
                    while ( !operatorStack.empty() && priority.get(operatorStack.peek()) >= priority.get(i) ) {
                        postfix.add(operatorStack.pop());
                    }
                    // Push the current operator
                    operatorStack.push(i);
                }
            }

        }
        // Add any remaining operators from the stack to the postfix expression
        while ( !operatorStack.empty() ) {
            postfix.add(operatorStack.pop());
        }

        return postfix;

    }

    public static Double calculateFromPostfix(ArrayList<String> function){

        Stack<Double> operandStack = new Stack<Double>();
        for ( String i: function ) {
            try {
                // If the current part is a number, push it to the top of the stack
                Double newOperand = new Double(i);
                operandStack.push(newOperand);
            } catch (NumberFormatException e) {
                // If the current part is an operator, pop the top two numbers from the stack
                Double operand2 = operandStack.pop();
                Double operand1 = operandStack.pop();
                Double result;
                // Calculate the correct result given the numbers and the operator
                if ( i.equals("^") ) {
                    result = Math.pow(operand1, operand2);
                } else if ( i.equals("*") ) {
                    result = operand1*operand2;
                } else if ( i.equals("/") ) {
                    result = operand1/operand2;
                } else if ( i.equals("+") ) {
                    result = operand1+operand2;
                } else {
                    result = operand1-operand2;
                }
                // Push the new number back onto the stack
                operandStack.push(result);
            }
        }
        // At this point, there should only be one number in the stack, which is the answer
        if ( !operandStack.empty() ) {
            return operandStack.pop();
        }
        // If the stack is empty, there was never actually an expression and the answer is always 0.0
        return 0.0;

    }

}
