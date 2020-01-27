package com.rvj.operator;

import com.rvj.RpnStack;

public abstract class MathsOperator implements Operator{

    @Override
    public int doOperation(RpnStack numbers) {
        int result;
        Integer firstNumber = numbers.pop();
        Integer secondNumber = numbers.pop();

        result = doOperation(secondNumber, firstNumber);
        return result;
    }

    protected abstract int doOperation(int lhs, int rhs);
}
