

import java.io.IOException;


/**	@author Bosko Gogic
 * 
 * 	@version java 1.8
 * 
 * 
 * 	Class CalculatorAdvanced represents some advanced operations and imagined methods(operations) that can be done by calculator.
 * 
 */

public class CalculatorAdvanced extends Calculator {

	/**	Standard constructor. */
	public CalculatorAdvanced() {
		super();
	}
	
	/**	Method represents calculating of factoriel.*/
	public int factoriel(int value) {
		int valueInteger = value;
		int temporary = valueInteger;
		valueInteger = 1;
		while(temporary >= 1) {
			valueInteger = (valueInteger * temporary);
			temporary--;
		}
		
		if(value == 0) {
			return 1;
		}
		return valueInteger;
	}
	
	
	/**	Method calculateAdvanced represents calculating degree (in case that parametar 'action' is number in interval
	* 	[0,9]) or factorial of integer part of value(attribute) currentValue.
	* 
	* @param  action represents value in interval [0,9] or value '!' which means factoriel.
	* @throws NotSupportedOperationException in case that value action isn't represents value in interval [0,9] and value '!'.
	* @throws NumberNotInAreaException in case when attribute 'currentValue' isn't in legal interval[0,10](in case
	* 		  when user send '!' for parametar 'action').
	*/

	public void calculateAdvanced(char action) throws NotSupportedOperationException,NumberNotInAreaException {
		
		char operator0 = '0';
		char operator1 = '1';
		char operator2 = '2';
		char operator3 = '3';
		char operator4 = '4';
		char operator5 = '5';
		char operator6 = '6';
		char operator7 = '7';
		char operator8 = '8';
		char operator9 = '9';
		char operatorFactoriel = '!';

		
		/*	Temporary value for manipulating inside the method */
		int newValue = 0;
		newValue = (int) Math.round(this.getCurrentValue());
		
		if((newValue <= 0) && (operatorFactoriel != action)){
			newValue = ((-1) * newValue);
		}
		
		if(operatorFactoriel == action) {
			/**	Case if valueInteger is not in legal interval[0,10]. */
			if((newValue < 0) || (newValue > 10)) {
				throw new NumberNotInAreaException("Trenutna vrijednost parametra nije u dozvoljenom opsegu [0,10]");
			}
			/*	Calculating factorial. */
			int valueInteger = (int) Math.round(this.getCurrentValue());
			factoriel(valueInteger);
			this.setCurrentValue((double)valueInteger);
			}
		
		else if((operator1 == action) || (operator2 == action) || (operator3 == action) || (operator4 == action) || (operator5 == action) || (operator6 == action) || (operator7 == action) || (operator8 == action) || (operator9 == action )) {
			/**	Calculating degree.*/
			int value = Character.getNumericValue(action);
			
			if(value >= 1) {
				while(value != 1) {
					newValue *= newValue;
					value--;
				}
			}
			this.setCurrentValue((double)newValue);
		}
		else if(operator0 == action) {
			if(newValue == 0){
				newValue = 0;
				this.setCurrentValue((double)newValue);
			}
			else{
				newValue = 1;
				this.setCurrentValue((double)newValue);

			}
		}
		
		/**	Case if value of parametar 'action' isn't legal operation.*/
		else {
			throw new NotSupportedOperationException("Pokusaj upotrebe nelegalne operacije!");
		}
	}


	
	
	/**	Method hasCharacteristic which I use to check if the attribute(his integer part) currentValue is Armstrong Number.
	 * 	or Perfect number.
	 * 
	 * @param value represents value that can be "A" (represents Armstrong Number) or "P" (represents Perfect Number).
	 * @return true if the attribute(his integer part) currentValue is Armstrong Number or Perfect number.
	 * @return false if the attribute(his integer part) current value isn't Armstrong number and Perfect number.
	 * @throws NotSupportedOperationException in case when value isn't "A" or "P".
	 * @throws NumberNotInAreaException in case when attribute 'currentValue'(his integer part) is less then 1.
	 */
	public Boolean hasCharacteristic(char value) throws NotSupportedOperationException, NumberNotInAreaException {
		int valueInteger = (int)Math.round(this.getCurrentValue());
		
		char operatorArmstrongNumber = 'A';
		char operatorPerfectNumber = 'P';
		/**	Case if valueInteger is less then number 1.*/
		if(valueInteger < 1) {
			throw new NumberNotInAreaException("Vrijednost currentValue nije u dozvoljenom opsegu!");
		}
		
		/**	Checking if the attribute 'currentValue' (his integer part) is an Armstrong number.*/
		if(operatorArmstrongNumber == value) {
			int number = valueInteger;
			int i=0;
			int degree=0;
			int counter =0;
			int temporaryNumber = 0;
			int finalNumber = 0;
			
			while(number > 0 ) {
				counter++;
				number = number/10;
			}
			
			number = valueInteger;
			while(number > 0) {
				temporaryNumber = number % 10;
				degree=1;
				for(i = 1; i <= counter; i++) {
					degree*=temporaryNumber;
				}
				finalNumber += degree;
				number = number/10;
			}
			
			if((finalNumber == valueInteger)){
				return true;
			}
		}
		
		/**	Checking if the attribute 'currentValue' (his integer part) is an  Perfect number.*/
		else if(operatorPerfectNumber == value) {
			int number = valueInteger;
			int sum = 0;
			int divisor = 2;
			
			while(divisor < number) {
				if((number % divisor) == 0) {
					sum+= divisor;
					}
				divisor++;
				}
			sum = sum+1;
			number = valueInteger;
			if(sum == number) {
				return true;
			}
			
		}
		/**	Case if value of parametar 'value' isn't legal operation.*/
		else {
			throw new NotSupportedOperationException("Vrijednost parametra value nije dozvoljena operacija!");
		}
		
		return false;
	}	
}

