import java.io.IOException;

/**	@author Bosko Gogic
 * 
 * 	@version java 1.8
 * 
 * 	Class NotSupportedOperationException represents class that throws an exception in case that inside the method
 * 	public void calculate(Double value, char operator) parameter 'operator' doesn't represent legal operator(+,-,*,/) 
 * 	or in case that inside the method public void calculateAdvanced(char action) parameter action doesn't represent legal
 * 	operation.
 *
 */

public class NotSupportedOperationException extends Exception{

	/**	Standard constructor and constructor with message about the exception that occurred. */ 
	/*public  NotSupportedOperationException() {
		super();
	}*/
	
	public NotSupportedOperationException(String message) {
		super(message);
	}
}
