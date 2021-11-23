package com.example.lab01;

import android.util.Log;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;


/**
 * This class has three methods that each take an ArrayList form of an equation.
 * validExpression checks if the equation is valid (not something weird like (3+)5 )
 * changeToPostFix changes the ArrayList to postfix form
 * calculateFromPostFix calculates the answer from the postfix form
 *
 * Example input: ArrayList of Strings in the form ["(", "3", "+", "5", ")", "^", "6", "-", "4"]
 *                                                  (3+5)^6-4
 *
 * @author Amy Dunn, 8093779
 * @author
 * @version 1.0
 */

public class PostfixCalculator {

    /**
     * Determines if a given ArrayList of Strings is a valid mathematical function
     * using +, -, *, / and numbers where each number or sign is an element in the list
     * @param function is the function to be analyzed in ArrayList form
     * @return true if it's a valid function or false otherwise
     */
    public static boolean validExpression(ArrayList<String> function) {

        // Last thing added
        String lastPart = "";
        // If the function is empty, it is valid
        if ( function.size() == 0 ) {
            return true;
        }
        // If the last part of the function is an operator, it is not a valid function
        String last = function.get(function.size()-1);
        if ( last.equals("+") || last.equals("-") || last.equals("*") || last.equals("/") ) {
            return false;
        }
        for ( String i: function ) {

            if ( i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/") ) {
                // If an operator is found immediately after an opening bracket, it's not a good expression
                if ( lastPart.equals("+") || lastPart.equals("-") || lastPart.equals("*") || lastPart.equals("/") ) {
                    return false;
                }
                lastPart = i;
            } else {
                if ( lastPart.equals("/") && i.equals("0") ) {
                    return false;
                }
                lastPart = i;
            }
        }
        return true;

    }

    /**
     * Changes a valid mathematical function from infix to postfix notation
     * The mathematical function can only contain +, -, *, /, (, ), and numbers and it must be
     * formatted into an ArrayList of Strings so that each number or symbol is a separate element
     * of the list
     * @param function is the valid mathematical function in ArrayList form
     * @return An ArrayList of Strings that represents the function in postfix notation
     */
    public static ArrayList<String> changeToPostfix(ArrayList<String> function) {

        // This hashtable holds the BEDMASS priority order
        Hashtable<String, Integer> priority = new Hashtable<String, Integer>();
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
                Double.parseDouble(i);
                postfix.add(i);
            } catch ( NumberFormatException e ) {
                // If there's something that's in the operatorStack that has a higher priority than the current
                // part, pop it and add it to the postfix expression
                while ( !operatorStack.empty() && priority.get(operatorStack.peek()) >= priority.get(i) ) {
                    postfix.add(operatorStack.pop());
                }
                // Push the current operator
                operatorStack.push(i);
            }

        }
        // Add any remaining operators from the stack to the postfix expression
        while ( !operatorStack.empty() ) {
            postfix.add(operatorStack.pop());
        }

        return postfix;

    }

    /**
     * Calculates the result of a mathematical function from postfix notation
     * The mathematical function can contain +, -, *, /, and numbers
     * It must be contained in an ArrayList of Strings where each element is a separate number or
     * symbol
     * @param function is the mathematical function in postfix notation
     * @return the result of the function
     */
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
