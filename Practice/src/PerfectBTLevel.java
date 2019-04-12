import java.util.*;
public class PerfectBTLevel {
	void specificLevelOrderTraversal(Node node){
		if(node==null) {
			return ;
		}
		LinkedList<Node> ll1=new LinkedList<Node>();
		LinkedList<Node> ll2=new LinkedList<Node>();
		ll1.add(node);
		ll1.addLast(null);
		System.out.print(node.data+" ");
		//ll2.add(node);
		//ll2.addLast(null);
		while(!ll1.isEmpty()) {
				while(ll1.peek()!=null) {
					Node temp=ll1.removeFirst();
					if(temp.left!=null) {
						ll1.addLast(temp.left);
						ll1.addLast(temp.right);
						ll2.addLast(temp.left);
						ll2.addLast(temp.right);
					}
				}
				ll1.removeFirst();
				ll1.addLast(null);
				while(!ll2.isEmpty()) {
					System.out.print(ll2.removeFirst().data+" ");
					if(!ll2.isEmpty())
						System.out.print(ll2.removeLast().data+" ");
				}
		}
	}
	void util(Node node) {
		if(node==null) {
			return;
		}
		System.out.print(node.data);
		if(node.left==null) {
			return;
		}
		//System.out.print(" "+node.left.data+" "+node.right.data);
		Queue<Node> q=new LinkedList<Node>();
		q.add(node.left);
		q.add(node.right);
		Node first=null,second=null;
		while(!q.isEmpty()) {
			first=q.remove();
			second=q.remove();
			System.out.println(" "+first.data+" "+second.data);
			if(first.left!=null) {
				q.add(first.left);
				q.add(second.right);
				q.add(first.right);
				q.add(second.left);
			}
		}
	}
}
