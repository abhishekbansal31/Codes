import java.util.*;
public class P2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		String s3=sc.next();
		StringBuffer sb1=new StringBuffer(s1);
		StringBuffer sb2=new StringBuffer(s2);
		for(int i=0;i<sb1.length();i++) {
			char temp=sb1.charAt(i);
			if(temp=='a' || temp=='e' ||temp=='i' ||temp=='o' ||temp=='u' || temp=='A' || temp=='E' ||temp=='I' ||temp=='O' ||temp=='U') {
				sb1=sb1.replace(i,i+1,"$");
			}
		}
		for(int i=0;i<sb2.length();i++) {
			char temp=sb2.charAt(i);
			if(temp!='a' && temp!='e' && temp!='i' && temp!='o' && temp!='u' && temp!='A' && temp!='E' && temp!='I' &&temp!='O' &&temp!='U') {
				sb2=sb2.replace(i, i+1,"#");
			}
		}
		s3=s3.toUpperCase();
		s1=sb1.toString();
		s2=sb2.toString();
		System.out.println(s1+s2+s3);
	}
}
