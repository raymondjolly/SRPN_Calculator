package com.rvj;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

    Calculate calculate;

    @BeforeAll
    static void beforeAllInit(){
        System.out.println("Starting calculation tests");
    }

    @BeforeEach
    void init(){
        calculate = new Calculate();
        calculate.push(10);
        calculate.push(20);
        calculate.push(30);
    }

    @AfterEach
    void cleanup(){
        System.out.println("Ran Test");
    }

    @Test
    void add() {
        calculate.add();
        assertEquals(50,calculate.peek());
    }

    @Test
    void addExceptionTest(){
        calculate.push(2147483647L);
        calculate.push(100000);
        calculate.add();
        assertEquals(2147483647L,calculate.peek());
        calculate.push(-2147483648L);
        calculate.push(-2147483648L);
        calculate.add();
        assertEquals(- 2147483648L, calculate.peek());
    }

    @Test
    void subtract() {
        calculate.subtract();
        assertEquals(-10, calculate.peek());
    }

    @Test
    void subtractExceptionTest(){
        calculate.push(-2147483647L);
        calculate.push(100);
        calculate.subtract();
        assertEquals(-2147483648L, calculate.peek());
    }

    @Test
    void multiply(){
        calculate.push(-4);
        calculate.push(-5);
        calculate.multiply();
        assertEquals(20, calculate.peek());
    }

    @Test
    void multiplyExceptionTest(){
        calculate.push(1000000);
        calculate.push(1000000);
        calculate.multiply();
        assertEquals(2147483647L, calculate.peek());
        calculate.push(-1000000);
        calculate.push(1000000);
        calculate.multiply();
        assertEquals(-2147483648L, calculate.peek());
    }

    @Test
    void power(){
        calculate.push(2);
        calculate.push(3);
        calculate.power();
        assertEquals(8, calculate.peek());
        calculate.push(1000000);
        calculate.push(900);
        calculate.power();
        assertEquals(2147483647L,calculate.peek());
    }

    @Test
    void divide(){
        calculate.push(20);
        calculate.push(5);
        calculate.divide();
        assertEquals(4, calculate.peek());
    }

}