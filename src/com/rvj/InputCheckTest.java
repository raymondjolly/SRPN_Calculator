package com.rvj;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class InputCheckTest {

    InputCheck inputCheck;

    @BeforeAll
    static void beforeAllInit(){
        System.out.println("Starting Input tests");
    }

    @BeforeEach
    void init(){
        inputCheck = new InputCheck();
    }

    @AfterEach
    void cleanup(){
        System.out.println("Ran Test");
    }

    @Test
    void isInt() {
        boolean test = inputCheck.isInt('7');
        assertTrue(test);

        test = inputCheck.isInt('T');
        assertFalse(test);
    }

    @Test
    void digitCount() {
        int test = inputCheck.digitCount(100);
        assertEquals(3, test);

        test = inputCheck.digitCount(1);
        assertEquals(1, test);
    }

}