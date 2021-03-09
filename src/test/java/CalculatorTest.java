import calculator.Calculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    Calculator calc = new Calculator();

    @Test
    public void sqrtTruePositive(){
        assertEquals("Evaluating square root of a non-negative number for True Positive",2.0,calc.sqrt(4), DELTA);
        assertEquals("Evaluating square root of a negative number for True Positive", Double.NaN, calc.sqrt(-4), DELTA);
    }

    @Test
    public void sqrtFalsePositive(){
        assertNotEquals("Evaluating square root of a non-negative number for False Positive",1.0,calc.sqrt(4), DELTA);
        assertNotEquals("Evaluating square root of a negative number for False Positive",0.0,calc.sqrt(-4), DELTA);
    }

    @Test
    public void factTruePositive(){
        assertEquals("Evaluating factorial of a non-negative number for True Positive",6.0,calc.fact(3), DELTA);
        assertEquals("Evaluating factorial of a negative number for True Positive", Double.NaN, calc.fact(-2), DELTA);
    }

    @Test
    public void factFalsePositive(){
        assertNotEquals("Evaluating factorial of a non-negative number for False Positive",1.0,calc.fact(3), DELTA);
        assertNotEquals("Evaluating factorial of a negative number for False Positive",0.0,calc.fact(-2), DELTA);
    }

    @Test
    public void nlogTruePositive(){
        assertEquals("Evaluating natural log of a non-zero positive number for True Positive",0.0,calc.nlog(1), DELTA);
        assertEquals("Evaluating natural log of a negative number for True Positive", Double.NaN, calc.nlog(-2), DELTA);
    }

    @Test
    public void nlogFalsePositive(){
        assertNotEquals("Evaluating natural log of a non-negative number for False Positive",1.0, calc.nlog(1), DELTA);
        assertNotEquals("Evaluating natural log of a negative number for False Positive",0.0, calc.nlog(-2), DELTA);
    }

    @Test
    public void powTruePositive(){
        assertEquals("Evaluating power function on two numbers for True Positive",27.0,calc.pow(3,3), DELTA);
        assertEquals("Evaluating power function on two numbers for True Positive", Double.NaN, calc.pow(0,0), DELTA);
    }

    @Test
    public void powFalsePositive(){
        assertNotEquals("Evaluating power function on two numbers for False Positive",1.0,calc.pow(3,3), DELTA);
        assertNotEquals("Evaluating power function on two numbers for False Positive",0.0,calc.pow(0,0), DELTA);
    }
}
