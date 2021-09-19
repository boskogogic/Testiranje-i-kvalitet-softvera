import static org.junit.Assert.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;






class CalculatorTest {
	

	private Calculator calculator = new Calculator();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculator() {
		assertNotNull(calculator);
	}

	@Test
	void testCalculateExceptions() {
		Exception exceptionFirst = assertThrows(NotSupportedOperationException.class, () -> calculator.calculate(2.33, 'a'));
		assertThat(exceptionFirst, is(instanceOf(NotSupportedOperationException.class)));
		
		Exception exceptionSecond = assertThrows(DivisionByZeroException.class, () -> calculator.calculate(0.0, '/'));
		assertThat(exceptionSecond, is(instanceOf(DivisionByZeroException.class)));
	}
	
	@Test
	void testSetCurrentValue() {
		Calculator result = new Calculator();
		result.setCurrentValue(213.25);
		Double expected = result.getCurrentValue();
		assertThat(expected,is(result.getCurrentValue()));
	}
	
	
	
	@ParameterizedTest
	@MethodSource("metodaSaParametrima")
	public void testCalculateParameterized(Double value, char operator) throws  NotSupportedOperationException, DivisionByZeroException {
		Double expected = value;
		Double beforeCalculating = calculator.getCurrentValue();
		
		calculator.calculate(value, operator);
	
		assertThat(calculator.getCurrentValue(), 
					 anyOf(is(expected), 
							is((-1.0)*expected), 
							is(0.0), 
							is(beforeCalculating + expected),
							is(beforeCalculating - expected),
							is(beforeCalculating * expected),
							is(beforeCalculating/expected)));
	
	
	}
	

	private static Stream<Arguments> metodaSaParametrima() {
		return Stream.of(
				Arguments.of(2.33, '+'),
				Arguments.of(1.33,'-'),
				Arguments.of(4.65, '*'),
				Arguments.of(5.25, '/')
				);
	}
}
