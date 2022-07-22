package com.exentric.demo2.util;

import com.exentric.demo2.util.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class CalculatorTest {
    @BeforeEach
    public void Oninit(){
        System.out.println("initial");
    } 

    @AfterEach
    public void OnDestroy(){
        System.out.println("destroy");
    } 

    @DisplayName("Add 測試")
    @Test
    void add() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        assertEquals(3, result);
        assertNotNull(result);
        assertTrue(result > 0);
    }

    @Disabled
    @Test
    public void dividByZero_thenTrhowException(){
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class,()->{
            calculator.divid(3,0);
        });
    }
}
