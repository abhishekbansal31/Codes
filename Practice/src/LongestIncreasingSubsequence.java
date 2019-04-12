import java.util.*;
public class LongestIncreasingSubsequence {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=1;
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && a[i]<a[j]+1) {
					a[i]=Math.max(a[j]+1, a[i]);
				}
				
			}
		}
		System.out.print(a[n-1]);
		
		sc.close();
	}
}
