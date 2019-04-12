import java.util.*;
import java.io.*;

public class JavaStack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.PUSH\n2.POP\n3.PEEK\n4.SEARCH");
			int ch=sc.nextInt();
			List<Integer> lt=new ArrayList<>();
			List<Integer> lt1=new LinkedList<>();
			List<Integer> lt2=new Vector<>();
			//Stack<Integer> s = new Stack<Integer>();
			//Vector<Integer> lt3=new Stack();
			List<Integer> lt4=new ArrayList<>();
			List<Integer> lt5=new ArrayList<>();
			List<Integer> lt6=new ArrayList<>();
			List<Integer> lt7=new ArrayList<>();
			List<Integer> lt8=new ArrayList<>();
			Stack st = new Stack(10);
			switch(ch) {
			case 1:
				int n=sc.nextInt();
				st.push("");
				break;
			case 2:System.out.println(st.pop());
			break;
			case 3:System.out.println(st.top);
			break;
			case 4: int k=sc.nextInt();
			//System.out.println(st.);
			}
		}while(true);
	}
}
