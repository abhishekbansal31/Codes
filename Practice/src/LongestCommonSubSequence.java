import java.util.*;
public class LongestCommonSubSequence {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String arr=sc.next();
		int n=arr.length();
		String arr2=sc.next();
		int m=arr2.length();
		int a[][]=new int[n+1][m+1];
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(arr.charAt(i-1)==arr2.charAt(j-1)) {
					a[i][j]=a[i-1][j-1]+1;
				}
				else
					a[i][j]=Math.max(a[i-1][j], a[i][j-1]);
			}
				
		}
		System.out.println(a[n][m]);
		int i=n,j=m;
		StringBuffer sb=new StringBuffer();
		while(i>0 && j>0) {
			if(a[i][j]==a[i-1][j-1]+1) {
				sb.append(arr.charAt(i-1));
				i--;
				j--;
			}
			else if(a[i][j]==a[i-1][j-1]) {
				i--;
			}
			else
				j--;
		}
		StringBuffer s1=new StringBuffer();
		for(int k=sb.length()-1;k>=0;k--) {
			s1.append(sb.charAt(k));
		}
		System.out.println(s1);
	}
}
