import java.util.*;

public class TreeTraversal {
	
	void levelOrderTraversal(Node root) {
		if( root == null ) {
			return ;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while( !queue.isEmpty() ) {
			Node front = queue.remove();
			System.out.print( front.value + " ");
			
			if( front.left!=null ) {
				queue.add(front.left) ;
			}
			if( front.right!=null ) {
				queue.add(front.right) ;
			}
		}
	}
	
	void levelOrderSpiralTraversal(Node root) {
		if( root == null ) {
			return ;
		}
		
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(root);
		
		int level = 0 ;
		Node top;
		while( !stack1.isEmpty() || !stack2.isEmpty() ) {
			while( level%2 == 0 && !stack1.isEmpty() ) {
				top = stack1.pop() ;
				System.out.print( top.value + " ");
				if(top.right != null ) {
					stack2.push( top.right );
				}
				if(top.left != null ) {
					stack2.push( top.left );
				}
			}
			while( level%2 == 1 && !stack2.isEmpty() ) {
				top = stack2.pop() ;
				System.out.print( top.value + " ");
				if(top.left != null ) {
					stack2.push( top.left );
				}
				if(top.right != null ) {
					stack2.push( top.right );
				}
			}
			level++ ;
		}
	}
	
	void inOrderTraversal(Node node){
		if( node == null ) {
			return ;
		}
		
		inOrderTraversal( node.left );
		System.out.print( node.value + " ");
		inOrderTraversal( node.right );
	}
	
	void preOrderTraversal(Node node){
		if( node == null ) {
			 return ;
		}
		
		System.out.print( node.value + " ");
		inOrderTraversal( node.left );
		inOrderTraversal( node.right );
	}
	
	void postOrderTraversal(Node node){
		if( node == null ) {
			return ;
		}
		
		inOrderTraversal( node.left );
		inOrderTraversal( node.right );
		System.out.print( node.value + " ");
	}

	
	/******** Main Function **********/
	
}
