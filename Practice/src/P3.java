import java.util.*;
public class P3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s=sc.next();
		StringBuffer sb =new StringBuffer();
		int count;
		for(int i=0;i<s.length();i++) {
			count=1;
			int j=i;
			while(j<s.length()-1 && s.charAt(j)==s.charAt(j+1)) {
				count++;
				j++;
			}
			sb.append(s.charAt(i)).append(String.valueOf(count));
			i+=count-1;
		}
		s=sb.toString();
		System.out.println(s);
	}
}
