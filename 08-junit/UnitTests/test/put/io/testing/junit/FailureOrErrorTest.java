package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FailureOrErrorTest {

    @Test
    public void test1(){
        Calculator calculator = new Calculator();
        int result = calculator.add(3,4);
        assertEquals(33, result);
    }

    @Test
    public void test2(){
        Calculator calculator = new Calculator();
        int results = calculator.addPositiveNumbers(-22,11);
        assertEquals(-11, results);
    }

    @Test
    public void test3(){
        Calculator calculator = new Calculator();
        try{
            assertEquals(1, calculator.add(-1,2));
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}
