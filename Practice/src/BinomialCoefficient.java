import java.util.*;
public class BinomialCoefficient {
	static int coff(int n,int k) {
		int a[][]=new int[n+1][];
		a[0]=new int[2];
		a[0][0]=1;
		for(int i=1;i<=n;i++) {
			int j=i+1;
			a[i]=new int[j+1];
			a[i][0]=1;
			for(int r=1;r<j;r++) {
				a[i][r]=a[i-1][r-1]+a[i-1][r];
			}
		}
		for(int i=0;i<=n;i++) {												//PASCAL's Tree
			for(int j=0;j<i+1;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		return(a[n][k]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		System.out.println(coff(n,k));
		
	}
}
