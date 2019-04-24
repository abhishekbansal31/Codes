import java.util.*;
import java.util.Map.Entry;

public class TreeView {
	
	void leftView(Node root) {
		if( root == null ) {
			return ;
		}

		System.out.println( root.value + " ");
		
		Queue<Node> queue = new LinkedList<Node>() ;
		if( root.left != null ) {
			queue.add(root.left) ;
		}
		if( root.right != null ) {
			queue.add(root.right) ;
		}
		queue.add(null);
		
		while( queue.peek() != null && !queue.isEmpty() ) {
			Node front = queue.remove();
			System.out.println( front.value + " ");
			
			while( front != null ) {
				if( front.left != null ) {
					queue.add(front.left) ;
				}
				if( front.right != null ) {
					queue.add(front.right) ;
				}
				front = queue.remove();
			}
			queue.add(null);
		}
	}

	void rightView(Node root) {
		if( root == null ) {
			return ;
		}

		System.out.println( root.value + " ");
		
		Queue<Node> queue = new LinkedList<Node>() ;
		if( root.right != null ) {
			queue.add(root.right) ;
		}
		if( root.left != null ) {
			queue.add(root.left) ;
		}
		queue.add(null);
		
		while( queue.peek() != null && !queue.isEmpty() ) {
			Node front = queue.remove();
			System.out.println( front.value + " ");
			
			while( front != null ) {
				if( front.right != null ) {
					queue.add(front.right) ;
				}
				if( front.left != null ) {
					queue.add(front.left) ;
				}
				front = queue.remove();
			}
			queue.add(null);
		}
		
	}
	/*******  Create new class for saving node and it's horizontal distance  ***********/
	class HorizontalDistanceNode{
		Node node;
		int horizontalDistance;
		HorizontalDistanceNode(Node node, int horizontalDistance){
			this.node = node ;
			this.horizontalDistance = horizontalDistance;
		}
	}
	void topView(Node root) {
		if( root == null ) {
			return ;
		}
		
		int horizontalDistance = 0 ;
		
		//	Create a map to store nodes with corresponding to their horizontal distance in sorted form
		Map<Integer, Node> horizontalDistanceNodeMap = new TreeMap<Integer, Node>();
		horizontalDistanceNodeMap.put(horizontalDistance, root);
		//	create a queue to traverse
		Queue<HorizontalDistanceNode> queue = new LinkedList<HorizontalDistanceNode>();
		queue.add( new HorizontalDistanceNode(root, horizontalDistance ));
		
		while( !queue.isEmpty() ) {
			Node front = queue.peek().node ;
			horizontalDistance = queue.peek().horizontalDistance ;
			queue.remove() ;
			
			if( front.left != null ) {
				queue.add( new HorizontalDistanceNode( front.left , horizontalDistance-1 ));
				if( !horizontalDistanceNodeMap.containsKey(horizontalDistance - 1) ) {
					horizontalDistanceNodeMap.put( horizontalDistance-1 , front.left );
				}
			}
			if( front.right != null ) {
				queue.add( new HorizontalDistanceNode( front.right , horizontalDistance+1 ));
				if( !horizontalDistanceNodeMap.containsKey(horizontalDistance + 1) ) {
					horizontalDistanceNodeMap.put( horizontalDistance+1 , front.right );
				}
			}
		}
		Set< Entry<Integer,Node> > set = horizontalDistanceNodeMap.entrySet();
		Iterator< Entry<Integer,Node> > itr = set.iterator();
		while( itr.hasNext() ) {
			System.out.print(itr.next().getValue().value + " ");
		}
	}

	void bottomView(Node root) {
		if( root == null ) {
			return ;
		}
		
		int horizontalDistance = 0;
		
		Map<Integer, Node> horizontalDistanceNodeMap = new TreeMap<Integer, Node>();
		horizontalDistanceNodeMap.put(0, root);

		Queue<HorizontalDistanceNode> queue = new LinkedList<HorizontalDistanceNode>();
		queue.add( new HorizontalDistanceNode(root, horizontalDistance ));
		
		while( !queue.isEmpty() ) {
			Node front = queue.peek().node ;
			horizontalDistance = queue.peek().horizontalDistance ;
			queue.remove() ;
			
			if( front.left != null ) {
				queue.add( new HorizontalDistanceNode(front.left, horizontalDistance-1 ));
				horizontalDistanceNodeMap.put(horizontalDistance-1, front.left);
			}
			if( front.right != null ) {
				queue.add( new HorizontalDistanceNode(front.right, horizontalDistance+1 ));
				horizontalDistanceNodeMap.put(horizontalDistance+1, front.right);
			}
		}
		
		Set<Entry<Integer , Node>> set = horizontalDistanceNodeMap.entrySet();
		Iterator<Entry<Integer, Node>> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next().getValue().value + " ");
		}
	}

	/******** Main Function **********/
	
}
