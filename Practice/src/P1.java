import java.util.*;
class RelToAbsPath{
	String abs;
	String convert(String url) {
		StringTokenizer st = new StringTokenizer(url,"/");
		int count=st.countTokens();
		Stack s = new Stack(count+1);
		while(st.hasMoreTokens()) {
			String temp=st.nextToken();
			if(temp.equals(".")){
				continue;
			}
			else if(temp.equals("..")) {
				if(s.top==-1) {
					return "-1";
				}
				System.out.println(s.pop());
			}
			else {
				s.push(temp);
			}
		}
		abs=String.join("/", s.stack);
		abs=abs.replace("null/","");
		abs=abs.replace("null","");
		String abs2="/"+abs;
		return abs2;
	}
}
class Stack{
	int top;
	String[] stack;
	Stack(int n){
		top=-1;
		stack=new String[n];
	}
	void push(String s) {
		if(top==stack.length-1) {
			System.out.println("stack overflow");
		}
		top++;
		stack[top]=s;
	}
	String pop() {
		String temp=stack[top];
		stack[top]=null;
		top--;
		return(temp);
	}
}
public class P1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String url = sc.next();
		RelToAbsPath obj=new RelToAbsPath();
		System.out.println(obj.convert(url));
		sc.close();
		//System.out.println("hello");
	}
}
