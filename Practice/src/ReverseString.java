import java.util.*;
public class ReverseString {
	static StringBuffer reverse(StringBuffer s) {
		if(s.length()==1) {
			return s;
		}
		else
			return reverse(new StringBuffer(s.substring(s.length()-1, s.length()))).append(reverse(s.delete(s.length()-1, s.length())));

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer s = new StringBuffer(sc.nextLine());
		//System.out.println(s.delete(s.length()-1, s.length()));
		System.out.println(reverse(s));
	}

}