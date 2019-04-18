

import java.lang.*;


/*
 * 
 *		Exception defined for invalid input for a graph
 * 
 */
public class VertexOutOfBoundException extends Exception{
	VertexOutOfBoundException(String message){
		super(message);
	}
}