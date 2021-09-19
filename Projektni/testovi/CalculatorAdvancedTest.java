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

class CalculatorAdvancedTest {
	
	//private PitExample pitExample;
	private CalculatorAdvanced calculatorAdvanced = new CalculatorAdvanced();
	private CalculatorAdvanced calculatorArmstrongNumber;
	private CalculatorAdvanced calculatorPerfectNumber;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		//pitExample = new PitExample();
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculatorAdvanced() {
		assertNotNull(calculatorAdvanced);
	}
	
	@Test
	void testFactorielMethod() {
		int result = 1;
		CalculatorAdvanced calculateFactoriel = new CalculatorAdvanced();
		calculateFactoriel.setCurrentValue(0.0);
		int expected = calculateFactoriel.factoriel((int)calculateFactoriel.getCurrentValue());
		assertThat(result,is(expected));
		
		int result2 = 2;
		calculateFactoriel.setCurrentValue(2.23);
		int expected2 = calculateFactoriel.factoriel((int)calculateFactoriel.getCurrentValue());
		assertThat(result2,is(expected2));
	}

	@Test
	void testHasCharacteristicArmstrongNumber() throws NotSupportedOperationException, NumberNotInAreaException {
		calculatorArmstrongNumber = new CalculatorAdvanced();
		calculatorArmstrongNumber.setCurrentValue(153.20);

		Boolean expected = true;
		Boolean result = calculatorArmstrongNumber.hasCharacteristic('A');
		
		assertThat(expected, is(result));
	}
	
	@Test
	void testHasCharacteristicPerfectNumber() throws NotSupportedOperationException, NumberNotInAreaException {
		calculatorPerfectNumber = new CalculatorAdvanced();
		calculatorPerfectNumber.setCurrentValue(28.30);
		Boolean expected = true;
		Boolean result = calculatorPerfectNumber.hasCharacteristic('P');
		assertThat(expected, is(result));
		
	}
	
	@Test
	void testHasCharacteristicReturnFalse() throws  NotSupportedOperationException, NumberNotInAreaException {
		CalculatorAdvanced calculatorReturnFalse = new CalculatorAdvanced();
		calculatorReturnFalse.setCurrentValue(45.22);
		
		Boolean expected = false;
		Boolean result1 = calculatorReturnFalse.hasCharacteristic('P');
		assertThat(expected, is(result1));
		
		Boolean result2 = calculatorReturnFalse.hasCharacteristic('A');
		assertThat(expected,is(result2));
	}
	
	@Test
	void testHadCharacteristicException() {
		CalculatorAdvanced calculatorAdvanced2 = new CalculatorAdvanced();
		calculatorAdvanced2.setCurrentValue(34.11);
		Exception exceptionCalculateHasCharacteristicFirst = assertThrows(NotSupportedOperationException.class, () -> calculatorAdvanced2.hasCharacteristic('G'));
		assertThat(exceptionCalculateHasCharacteristicFirst, is(instanceOf(NotSupportedOperationException.class)));
		
		CalculatorAdvanced calculatorAdvanced3 = new CalculatorAdvanced();
		Double value = -3.24;
		calculatorAdvanced3.setCurrentValue(value);
		Exception exceptionCalculateHasCharacteristicSecond = assertThrows(NumberNotInAreaException.class, () -> calculatorAdvanced3.hasCharacteristic('A'));
		assertThat(exceptionCalculateHasCharacteristicSecond, is(instanceOf(NumberNotInAreaException.class)));	
		
	}
	
	
	@Test
	void testCalculateAdvancedException() {
		Exception exceptionFirst = assertThrows(NotSupportedOperationException.class, () -> calculatorAdvanced.calculateAdvanced('a'));
		assertThat(exceptionFirst, is(instanceOf(NotSupportedOperationException.class)));
		
		calculatorAdvanced.setCurrentValue(-2.33);
		Exception exceptionSecond = assertThrows(NumberNotInAreaException.class, () -> calculatorAdvanced.calculateAdvanced('!'));
		assertThat(exceptionSecond, is(instanceOf(NumberNotInAreaException.class)));
	}
	
	@Test
	void testCalculateAdvancedDegreeZeroValueOne() throws NotSupportedOperationException {
		CalculatorAdvanced calculatorAdvancedDegreeZeroValueOne = new CalculatorAdvanced();
		calculatorAdvancedDegreeZeroValueOne.setCurrentValue(2.33);
		
		int expected = 1;
		calculatorAdvancedDegreeZeroValueOne.calculateAdvanced('0');
		assertThat(expected,is((int)calculatorAdvancedDegreeZeroValueOne.getCurrentValue()));
	}
	
	@ParameterizedTest
	@MethodSource("metodaSaParametrimaPrva") 
	public void testCalculateAdvancedParameterized(char action) throws NotSupportedOperationException,NumberNotInAreaException {
		int result = 0;
		int expected = (int) Math.round(calculatorAdvanced.getCurrentValue());
		
		calculatorAdvanced.calculateAdvanced(action);
		result = (int) Math.round(calculatorAdvanced.getCurrentValue());
		
		assertThat(result, 
				anyOf(is(0),
					  is(1), 
					  is(expected), 
					  is(expected*expected), 
					  is(expected*expected*expected), 		
					  is(expected*expected*expected*expected), 
					  is(expected*expected*expected*expected*expected), 
					  is(expected*expected*expected*expected*expected*expected), 
					  is(expected*expected*expected*expected*expected*expected*expected),
					  is(expected*expected*expected*expected*expected*expected*expected*expected),
					  is(expected*expected*expected*expected*expected*expected*expected*expected*expected),
					  is(calculatorAdvanced.factoriel(expected))));
				
		
	}

	private static Stream<Arguments> metodaSaParametrimaPrva() {
		return Stream.of(
				Arguments.of('0'),
				Arguments.of('1'),
				Arguments.of('2'),
				Arguments.of('3'),
				Arguments.of('4'),
				Arguments.of('5'),
				Arguments.of('6'),
				Arguments.of('7'),
				Arguments.of('8'),
				Arguments.of('9'),
				Arguments.of('!')
				);
	}
	
	/*@ParameterizedTest
	@MethodSource("metodaSaParametrimaDruga")
	public void testHasCharacteristicParameterized(char value) {
		
		assertEquals("")
	}
	
	private static Stream<Arguments> metodaSaParametrimaDruga() {
		return Stream.of(
				Arguments.of('A'),
				Arguments.of('P')
				);
	}*/



}
