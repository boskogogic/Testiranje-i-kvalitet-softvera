import java.io.IOException;

/**	@author Bosko Gogic
*	@version java 1.8
*
*	Class NumberNotInAreaException represents class which I use for implementing an exception in situation 
*	when parameter 'action' in class public void calculateAdvanced(char action) doesn't represent number 
*	inside interval[0,10].
*/


public class NumberNotInAreaException extends ArithmeticException {

	/**	Standard constructor and constructor with message about the exception that occurred.*/ 
	/*public NumberNotInAreaException() {
		super();
	}*/
	
	public NumberNotInAreaException(String message) {
		super(message);
	}
}
