import java.util.*;
class NodeExp{
	char data;
	NodeExp left,right;
	NodeExp(char data){
		this.data=data;
	}
}
public class ExpressionTree {
	NodeExp root;
	static HashSet<Character> hs=new HashSet<Character>();
	NodeExp expTree(String s) {
		Deque<NodeExp> dq=new LinkedList<NodeExp>();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			NodeExp node = new NodeExp(ch);
			if(hs.contains(ch)) {
				node.right=dq.pop();
				node.left=dq.pop();
			}
			dq.push(node);				
		}
		root=dq.pop();
		return root;
	}
	public static void main(String[] args) {
		hs.add('+');
		hs.add('-');
		hs.add('*');
		hs.add('/');
		hs.add('%');
		hs.add('^');
	}
}
