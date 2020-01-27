package com.rvj.operator;

public class Subtraction extends MathsOperator {

    private static final String SUBTRACT = "-";

    @Override
    public boolean isOperand(String operand) {
        return SUBTRACT.equals(operand);
    }

    @Override
    protected int doOperation(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
