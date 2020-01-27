package com.rvj.operator;

public class Addition extends MathsOperator {

    private static final String PLUS = "+";

    @Override
    public boolean isOperand(String operand) {
        return PLUS.equals(operand);
    }

    @Override
    protected int doOperation(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
