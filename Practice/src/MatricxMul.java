import java.util.*;
class MatricxMul{
	static int mul(int[] arr) {
		int n=arr.length;
		int a[][]=new int[n][n];
		
		for(int k=1;k<n;k++) {
			for(int i=1;i<n-k+1;i++) {
				int j=i+k-1;
				if(i==j)
					a[i][j]=0;
				else
					a[i][j]=Math.min(a[i][j-1]+arr[i-1]*arr[j-1]*arr[j], a[i+1][j]+arr[i-1]*arr[i]*arr[j]);
					//a[i][j]=arr[j]*arr[j-1]*arr[j-2]+Math.min(a[i][j-1], a[i+1][j]);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		return a[1][n-1];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n+1];
		for(int i=0;i<=n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(mul(arr));
		
	}
}