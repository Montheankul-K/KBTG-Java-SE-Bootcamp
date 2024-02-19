import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class  CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("input 1 and 1 should be 2")
	void addShouldReturn2() {
		// Arrange
		// Calculator calculator = new Calculator();

		// Act
		int result = calculator.add(1, 1);

		// Assert
		assertEquals(2, result);
	}

	@Test
	@DisplayName("input 1 and 2  should be 3")
	void addShouldReturn3() {
		// Calculator calculator = new Calculator();

		int actual = calculator.add(1,2);
		int expected = 3;

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("input 1 and 1 output should be 0")
	void subtractShouldReturn0() {
		// Calculator calculator = new Calculator();

		int actual = calculator.subtract(1, 1);
		int expected = 0;

		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@CsvSource({"2, 1, 1", "2, 2, 0", "3, 3, 0"})
	@DisplayName("subtract return correctly")
	void subtract(int leftOperand, int rightOperand, int expected) {
		int result = calculator.subtract(leftOperand, rightOperand);

		assertEquals(expected, result);
	}
}
