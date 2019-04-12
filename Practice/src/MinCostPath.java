import java.util.*;
public class MinCostPath {

	static int min[][],max=Integer.MAX_VALUE;
	static int minCost(int[][] arr, int m,int n) {
		if(m<0 || n<0)
			return max;
		if(m==0 && n==0) {
			return min[m][n]=arr[m][n];
		}
		if(min[m][n]!=max) {
			return min[m][n];
		}
		else {
			return min[m][n]=arr[m][n]+Math.min(minCost(arr,m-1,n), Math.min(minCost(arr,m,n-1), minCost(arr,m-1,n-1)));
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int p=sc.nextInt();
		int arr[][]=new int[t][p];
		for(int i=0;i<t;i++) {
			for(int j=0;j<p;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int m=sc.nextInt();
		int n=sc.nextInt();
		min=new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				min[i][j]=max;
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println(minCost(arr,m-1,n-1));
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(min[i][j]+" ");
			}
			System.out.println();
		}
	}
}
