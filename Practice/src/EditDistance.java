import java.util.*;
public class EditDistance {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		int n=s1.length();
		int m=s2.length();
		int a[][]=new int[n+1][m+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				if(i==0) {
					a[i][j]=j;
				}
				else if(j==0) {
					a[i][j]=i;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					a[i][j]=a[i-1][j-1];
				}
				else {
					a[i][j]=1+Math.min(a[i][j-1], Math.min(a[i-1][j-1], a[i-1][j]));
				}
			}
		}
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(a[n][m]);
	}
}
