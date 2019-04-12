import java.util.*;
public class FindPermutations {
	static String[] find(String s) {
		int n=s.length();
		String  s1[];
		if(n==0) {
			s1=new String[1];
			s1[0]="Wrong input";
		}
		else {
			s1=new String[n*(n-1)];
			String s3[]=new String[n-1];
			if(n==1) {
				String s2[]=new String[1];
				s2[0]=s;
				return s2;
			}
			else {
				for(int i=0;i<n;i++) {
					s3=find(s.substring(0,i).concat(s.substring(i+1)));
					for(int j=i;j<n+i-1;j++) {
						s1[i+j]=s.substring(i,i+1).concat(s3[j-i]);
						System.out.println(s1[i+j]);
					}
				}
			}
		}
		return s1;
	}
	public static void main(String args[]) {
		Scanner sc =new Scanner(System.in);
		String s=sc.next();
		String arr[]=find(s);
			for(int i=1;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
	}
}
