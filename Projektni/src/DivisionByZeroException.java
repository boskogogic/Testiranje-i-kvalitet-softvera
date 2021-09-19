import java.io.IOException;


/**	
 * 	@author Bosko Gogic
 *	@version java 1.8
 *
 *	Class DivisionByZeroException represents class which I use for implementing an exeception in situation when inside method
 *	public void calculate(Double value, char operator) in class Calculate user try to divide by zero.
 */

public class DivisionByZeroException extends ArithmeticException {
	
	/**	Standard constructor and constructor with message about the exception that occurred.*/ 
	/*public DivisionByZeroException() {
		super();
	}*/
	
	public DivisionByZeroException(String message) {
		super(message);
	}

}
