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
    }

    @Test
    void subtract() {
        calculate.subtract();
        assertEquals(-10, calculate.peek());
    }


}