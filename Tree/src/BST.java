import java.util.Scanner;

public class BST extends Tree{

	/*
	* Return the Height of the node
	* 
	* (non-Javadoc)
	* @see Tree#height(Node)
	*/
	int height(Node node){
		if( node == null ) {
			return 0;
		}
		return Math.max( height(node.left), height(node.right) ) + 1 ;
	}
	 
 
	/* 
	 * Insert a Node in a Binary Search Tree (BST)
	 * 
	 * (non-Javadoc)
	 * @see Tree#insert(int)
	 */
	void insert(int value){
		Node node = new Node(value);
		 
		if( this.root == null ) {
			this.root = node ;
			return;
		}
		 
		Node tempNode = this.root , parent = this.root;
		
		while( tempNode != null ) {
			parent = tempNode;
			if( node.value >= tempNode.value ) {
				tempNode = tempNode.right;
			}
			else {
				tempNode = tempNode.left ;
			}
		}
		 
		if( node.value < parent.value ) {
			parent.left = node ;
		}
		else {
			parent.right = node ;
		}
	}
	
	  
	/*
	 * Search a node in a BST
	 * (non-Javadoc)
	 * @see Tree#search(int)
	 */
	Node search(int reqNodeValue){
		Node reqNode = this.root ;
		 
		while(reqNode != null && reqNode.value != reqNodeValue) {
			if(reqNode.value < reqNodeValue) {
				reqNode = reqNode.right ; 
			}
			else {
				reqNode = reqNode.left ;
			}
		}
		if(reqNode == null) {
			System.out.println("No such node exists in the tree");
		}
		return reqNode;
	}


	/*
	 * Three types of traversals   ( In-Order , Pre-Order , Post-Order )
	 * (non-Javadoc)
	 * @see Tree#inOrderTraversal(Node), Tree#preOrderTraversal(Node), Tree#postOrderTraversal(Node)
	 */
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
	
	 
	/*
	 * Delete and return it back
	 * (non-Javadoc)
	 * @see Tree#delete(Node)
	 */
	Node deleteSuccessor(Node node) {
		Node successor = node.right , parentSuccessor = node ;
		while( successor.left != null ) {
			parentSuccessor = successor ;
			successor = successor.left ;
		}
		int value = node.value ;
		node.value = successor.value ;
		successor.value = value ;
		
		if( parentSuccessor == node ) {
			node.right = successor.right ;
		}
		else {
			parentSuccessor.left = successor.right ;
		}
		successor.left = null ;
		successor.right = null ;
		return successor;
	}
	Node delete(int value){
		// If empty tree
		if( root == null ) {
			System.out.println("Not such node exists");
			return null;
		}
		
		Node node = root, parent = null;
		/******	if delete root ********/
		if(root.value == value) {
			// If no child of root node or single child of root
			if(root.left == null || root.right == null) {
				if( root.left == null ) {
					root = root.right ;
				}
				else {
					root = root.left ;
				}
				node.left = null ;
				node.right = null ;
				return node;
			}
			
			// if root has both children
			return this.deleteSuccessor(root);
			
		}
		
		/********** If other node than root node ********/
		
		 		// Search the node and it's parent node
		while( node !=null && node.value != value ) {
			parent = node ;
			if(value < node.value) {
				node = node.left;
			}
			else {
				node = node.right;
			}
		}
				// node with same value not present in the tree
		if( node == null ) {
			System.out.println("Not such node exists");
			return null;
		}

		// if node has no child i.e. a leaf node  OR if node has single child
		if( node.left == null || node.right == null ) {
			if( node.value < parent.value) {
				if(node.right == null) {
					parent.left = node.left ;
				}
				else {
					parent.left = node.right ;
				}
			}
			else {
				if(node.left == null) {
					parent.right = node.right ;
				}
				else {
					parent.right = node.left ;
				}
			}
			node.left = null ;
			node.right = null ;
			return node;
		}
		// If node has both children then change the node with it's successor node and delete the successor node
		return this.deleteSuccessor(node);
	}


	public static void main(String[] args) {
	 
		Scanner sc = new Scanner(System.in);
		
		Tree tree = new BST() ;
		
		boolean chooseAgain = true ;
		do {

			System.out.println("1. Insert\n2. Delete\n3. inOrder Traversal\n4. preOrder Traversal\n5. postOrder Traversal\n6. Height of tree");
			
			int choice = sc.nextInt();
			switch( choice ) {
			case 1 :
				System.out.println("Enter value : ");
				tree.insert( sc.nextInt() );
				break;
				
			case 2 :
				System.out.println("Enter value of the node to be deleted : ");
				tree.delete( sc.nextInt() );
				break;

			case 3 :
				tree.inOrderTraversal( tree.root );
				break;
				
			case 4 :
				tree.preOrderTraversal( tree.root );
				break;
				
			case 5 :
				tree.postOrderTraversal( tree.root );
				break;
				
			case 6 :
				System.out.println("Height of the tree : " + tree.height(tree.root));
				break;
				
			default :
				System.out.println("Wrong choice");
				break;
			}
			
			System.out.println("Wanna continue with same tree, Y/N");
			sc.nextLine() ;
			String str = sc.nextLine();
			if(str.equals("Y") || str.equals("y")) {
				chooseAgain = true;
			}
			else if(str.equals("N") || str.equals("n")) {
				chooseAgain = false;
			}
			else {
				System.out.println("Wrong input, Try Again");
			}
			
		}while(chooseAgain);
		sc.close();
	}
}
