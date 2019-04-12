//    	https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
import java.util.*;
public class SpiralTraversal {

		void printSpiral(Node n) throws NullPointerException{
			Deque<Node> s1 = new LinkedList<Node>();
			//Stack<Node> s1 = new Stack<Node>();
			s1.push(n);
			int level=1;
			while(!s1.isEmpty()){
				Deque<Node> s2 = new LinkedList<Node>();
				//Stack<Node> s2=new Stack<Node>();
				if(level%2==1){
					while(!s1.isEmpty()){
						Node temp=(Node)s1.peek();
						s1.pop();
						if (temp.right != null)
						    s2.push(temp.right);
						if (temp.left != null)
						    s2.push(temp.left);
						System.out.print(temp.data+" ");
					}
				}
				else{
					while(!s1.isEmpty()){
						Node temp=(Node)s1.peek();
						s1.pop();
						if (temp.left != null)
						    s2.push(temp.left);
						if (temp.right != null)
						    s2.push(temp.right);
						System.out.print(temp.data+" ");
					}
				}
				s1=s2;
				level++;
			}
		}
}