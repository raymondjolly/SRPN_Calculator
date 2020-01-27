package com.rvj.operator;



public class Division extends MathsOperator {

    private static String DIVIDE = "/";

    @Override
    public boolean isOperand(String operand) {
        return DIVIDE.equals(operand);
    }

    @Override
    protected int doOperation(int firstNumber, int secondNumber) {
        try {
            return firstNumber / secondNumber;
        } catch (ArithmeticException e){
            System.out.println("Division by zero");
            return Integer.MIN_VALUE;
        }

    }
}
