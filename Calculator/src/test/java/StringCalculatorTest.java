import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {
    private StringCalculator calculator;
    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }
    @Test
    public void whenNoNumberIsUsedExceptionIsThrown() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(NumberFormatException.class, () -> stringCalculator.add("1,twa,3"));
    }

    @Test
    public void whenMoreThan2NumbersAreUsedThenNoExceptionIsThrown() {
        StringCalculator stringCalculator = new StringCalculator();
        assertDoesNotThrow(() -> stringCalculator.add("1,2,3"));
    }

    @Test
    public void when2NumbersAreUsedThenNoExceptionisThrown() {
        StringCalculator stringCalculator = new StringCalculator();
        assertDoesNotThrow(() -> stringCalculator.add("1,2"));
    }

    @Test
    public void TestAdd_SingleNumber_ReturnsTheNumberItSelf() {
        // Arrange
        String input = "5";

        // Act
        int result = calculator.Add(input);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void TestAdd_TwoNumbersSeparatedByComma_ReturnsTheirSum() {
        // Arrange
        String input = "2,3";

        // Act
        int result = calculator.Add(input);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void TestAdd_ThreeNumbersSeparatedByComma_ReturnsTheirSum() {
        // Arrange
        String input = "2,3,5";

        // Act
        int result = calculator.Add(input);

        // Assert
        assertEquals(10, result);
    }

    @Test
    public void TestAdd_numbersSeparatedByMultipleCommas_ReturnsTheirSum() {
        // Arrange
        String input = "1,2,3,4,5";

        // Act
        int result = calculator.Add(input);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void TestAdd_NumbersSeparatedByNewLine_ReturnsTheirSum() {
        // Arrange
        String input = "1\n2,3\n4,5";

        // Act
        int result = calculator.Add(input);

        // Assert
        assertEquals(15, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAdd_NegativeNumbers_ThrowsException() {
        // Arrange
        String input = "-2,-3,-5";

        // Act
        calculator.Add(input);
    }

    @Test
    public void TestAdd_LargeNumber_ReturnCorrectSum() {
        // Arrange
        String input = "1000,2000,3000,4000,5000";

        // Act
        int result = calculator.Add(input);

        // Assert
        assertEquals(15000, result);
    }

    @Test
    public void TestAdd_EmptyString_ReturnZero() {
        // Arrange
        String input = "";

        // Act
        int result = calculator.Add(input);

        // Assert
        assertEquals(0, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAdd_NullString_ThrowException() {
        // Arrange
        String input = null;

        // Act
        int result = calculator.Add(input);

        // Assert
        assertEquals(0, result);
    }
}