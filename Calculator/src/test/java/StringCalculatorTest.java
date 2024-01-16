import org.example.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {
    private Calculator calculator;
    @Before
    public void setUp() throws Exception {
        calculator = new Calculator(); // Initialize the calculator instance in the setup method
    }
//    @Test
//    public void whenNoNumberIsUsedExceptionIsThrown() {
//        Calculator Calculator = new Calculator();
//        assertThrows(NumberFormatException.class, () -> Calculator.add("1,two,3"));
//    }

    @Test
    public void whenMoreThan2NumbersAreUsedThenNoExceptionIsThrown() {
        Calculator calculator = new Calculator();
        Assertions.assertDoesNotThrow(() -> calculator.add("1,2,3"));
    }

    @Test
    public void when2NumbersAreUsedThenNoExceptionisThrown() {
        Calculator calculator = new Calculator();
        Assertions.assertDoesNotThrow(() -> calculator.add("1,2"));
    }

//    @Test
//    public void testAdd() {
//        // Use the instance variable for calculator
//        assertEquals(3, calculator.add(1, 2));
//        assertEquals(-3, calculator.add(-1, -2));
//        assertEquals(9, calculator.add(9, 0));
//    }
//
//    @Test
//    public void testSubtract() {
//        assertEquals(1, calculator.subtract(2, 1));
//        assertEquals(-1, calculator.subtract(-2, -1));
//        assertEquals(0, calculator.subtract(2, 2));
//    }
//
//    @Test
//    public void testMultiply() {
//        Calculator cal = new Calculator();
//        int result = cal.add("1,2,3,4,5");
//        assertEquals(15, result);
//    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        calculator.divide(10, 0);
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2), 0.001); // Test for double equality with a tolerance
        assertEquals(-2.5, calculator.divide(-5, 2), 0.001);
        assertEquals(0, calculator.divide(0, 5), 0.001);
    }

    @Test
    public void TestAdd_EmptyString_ReturnZero() {
        // Arrange
        String input = "";

        // Act
        int result = calculator.add(input);

        // Assert
        assertEquals(0, result);
    }
}