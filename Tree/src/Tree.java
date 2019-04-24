

abstract public class Tree {	
	Node root;
	
	abstract int height(Node node);
	
	abstract void insert(int value);
	
	abstract Node search(int value);
	
	abstract void inOrderTraversal(Node node);

	abstract void preOrderTraversal(Node node);

	abstract void postOrderTraversal(Node node);	
	
	abstract Node delete(int value);

}
