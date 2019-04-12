import java.util.Scanner;

public class LongestPallindrome {
	static int grPallindrome(String s,int b,int e) {
		if(b==e) {
			return 1;
		}
		if(b>e)
			return 0;
		if(s.charAt(b)==s.charAt(e)) {
			return grPallindrome(s,b+1,e-1)+2;
		}
		else
			return Math.max(grPallindrome(s,b+1,e),grPallindrome(s,b,e-1));
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s=sc.next();
		int n=s.length();
		//int b=0;
		//int e=n-1;
		//System.out.println(grPallindrome(s,b,e));
/*		int a[][]=new int[n/2+1][n/2+1];
		int x=n/2;
		if(n%2==1) {
			x+=1;
		}
			for(int i=n,k=1;i>x;i--,k++) {
				for(int j=1;j<=n/2;j++) {
					if(s.charAt(i-1)==s.charAt(j-1)) {
						a[k][j]=a[k-1][j-1]+2;
					}
					else
						a[k][j]=Math.max(a[k-1][j], a[k][j-1]);
			}
		}
			for(int i=0;i<=n/2;i++) {
				for(int j=0;j<=n/2;j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
		System.out.println(a[n/2][n/2]+1);
*/
		int arr[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			arr[i][i]=1;
		}
		for(int k=2;k<=n;k++) {
			for(int i=0;i<n-k+1;i++) {
				int j=i+k-1;
				if(s.charAt(i)==s.charAt(j) && k==2)  {
					arr[i][j]=1;
				}
				if(s.charAt(i)==s.charAt(j)) {
					arr[i][j]=arr[i+1][j-1]+2;
				}
				else
					arr[i][j]=Math.max(arr[i+1][j], arr[i][j-1]);
			}
		}
		System.out.print(" ");
		for(int i=0;i<n;i++) {
			System.out.print(" |"+s.charAt(i));
		}
		System.out.println();
		for(int i=0;i<2*n+2;i++) {
			System.out.print("-");
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			System.out.print(s.charAt(i)+" |");
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" |");
			}
			System.out.println();
			for(int t=0;t<3*n;t++) {
				System.out.print("-");
			}
			System.out.println();
		}
		
	}
	

}
