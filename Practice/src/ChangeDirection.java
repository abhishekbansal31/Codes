import java.util.*;
public class ChangeDirection {
	void changeDirection(Node node) {
		if(node==null)
			return;
		int count=0;
		Queue<Node> q = new LinkedList<Node>();
		Deque<Node> dq = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		while(!q.isEmpty() || q.peek()==null) {
			count=0;
			while(count<2) {
				while(!q.isEmpty() && q.peek()!=null) {
					Node temp=q.peek();
					q.remove();
					System.out.print(temp.data+" ");
					if(temp.left!=null) {
						q.add(temp.left);
					}
					if(temp.right!=null) {
						q.add(temp.right);
					}
				}
				q.remove();
				if(!q.isEmpty())
					System.out.println();
				q.add(null);
				count++;
			}
			count=0;
			while(count<2) {
				while(!q.isEmpty() && q.peek()!=null) {
					Node temp=q.peek();
					q.remove();
					if(temp.left!=null) {
						q.add(temp.left);
					}
					if(temp.right!=null) {
						q.add(temp.right);
					}
					dq.push(temp);
				}
				while(!dq.isEmpty()) {
					System.out.print(dq.pop().data+" ");
				}
				if(!q.isEmpty()) {
					q.remove();
					q.add(null);
					System.out.println();
				}
				count++;
			}
		}
	}
}
