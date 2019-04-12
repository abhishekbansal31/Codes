
		/*						FOLDABLE TREE
		 * 
		 * 
		 * 		Both child of this tree are structure wise mirror image of each other.
		 * 
		 */
		


public class FoldableTree {
	boolean isFoldable(Node node) {
		if(node==null) {
			return true;
		}
		return isFoldableUtil(node.left,node.right);
	}
	boolean isFoldableUtil(Node n1,Node n2) {
		if(n1==null && n2==null) {
			return true;
		}
		if(n1==null || n2==null) {
			return false;
		}
		return isFoldableUtil(n1.left,n2.right) && isFoldableUtil(n1.right,n2.left);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
