package com.rvj.operator;

import com.rvj.RpnStack;

public interface Operator {
    public int doOperation(RpnStack numbers);

    public boolean isOperand(String operand);
}
