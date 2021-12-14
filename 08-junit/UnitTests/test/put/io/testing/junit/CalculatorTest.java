package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    @Test
    public void testAdd(){

        int result = calculator.add(22,11);
        int result2 = calculator.add(3,4);
        assertEquals(33, result);
        assertEquals(7,result2);
    }

    @Test
    public void testMultiply(){

        int result = calculator.multiply(4,5);
        int result2 = calculator.multiply(2,3);
        assertEquals(20, result);
        assertEquals(6, result2);
    }

    @Test
    public void testAddPositiveNumbers(){

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(-22,11);
        }, "IllegalArgumentException was except");

        }

    @BeforeEach
    public void setUp(){

        calculator = new Calculator();

    }

    }

