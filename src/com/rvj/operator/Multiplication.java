package com.rvj.operator;

public class Multiplication extends MathsOperator {

    private static final String MULTIPLY = "*";

    @Override
    public boolean isOperand(String operand) {
        return MULTIPLY.equals(operand);
    }

    @Override
    protected int doOperation(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
