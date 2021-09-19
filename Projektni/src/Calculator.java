
import java.io.IOException;

/**	@author Bosko Gogic
 * 	@version java 1.8
 * 
 * 	
 * 	Class Calculator represents the calculator and arithmetic operations which can be done by calculator.
 * 
 */

public class Calculator {

	/**	Atribute currentValue represents value(for manipulating) of class Calculator. */
	private Double currentValue;
	
	/**	Standard constructor. */
	public Calculator() {
		this.currentValue = 0.0 ;
	}
	
	
	/**	Standard get and set methods for manipulating with atributes */
	public double getCurrentValue() {
		return currentValue;
	}
	
	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}
	
	/**	Method calculate represents basic operations of calculater.
	 * 
	 * @param value represents value for manipulating in this method. 
	 * @param operator represents basic operations of calculator (+,-,*,/).
	 * @throws NotSupportedOperationException if parameter 'operator' isn't represents legal operation(+,-,*,/).
	 * @throws DivisionByZeroException when user try to divide by 0.
	 * 
	 */
	
	public void calculate(Double value, char operator) throws NotSupportedOperationException, DivisionByZeroException {
			
			char operator1 = '+';
			char operator2 = '-';
			char operator3 = '*';
			char operator4 = '/';
			
			if(operator1 == operator) {
				this.currentValue = this.currentValue + value;
			}
			else if(operator2 == operator) {
				this.currentValue = this.currentValue - value;
			}
			else if(operator3 == operator) {
				this.currentValue = this.currentValue * value;
			}
			else if(operator4 == operator) {
				if(value == 0) {
					throw new DivisionByZeroException("Detektovano je dijeljenje sa nulom(0) !");
				}
				else {
					this.currentValue = this.currentValue / value;
				}
				
			}
			
			else {
				throw new NotSupportedOperationException("Operator nije iz grupe 'legalnih' operatora (+,-,*,/)");
			}
			
			
	}
}

