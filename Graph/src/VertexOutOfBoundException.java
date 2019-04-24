

import java.lang.*;


/*
 * 
 *		Exception defined for invalid input for a graph
 * 		works as IllegalArgumentException
 */
public class VertexOutOfBoundException extends IllegalArgumentException{
	VertexOutOfBoundException(String message){
		super(message);
	}
}