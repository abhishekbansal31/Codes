import java.util.*;
public class LargestSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		int temp1=arr[0],temp2=0;
		for(int i=0;i<n;i++) {
			temp2=temp2+arr[i];
			if(temp2<=0) {
				temp2=0;
			}
			if(temp1<temp2) {
				temp1=temp2;
			}
		}
		/*int dp[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			dp[i][i]=arr[i];
		}
		for(int k=2;k<n;k++) {
			for(int i=0;i<n-k+1;i++) {
				int j=i+k-1;
				dp[i][j]=dp[i][j-1]+arr[j];
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		int max=0;
		int ti=0,tj=0;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(max<dp[i][j]) {
					max=dp[i][j];
					ti=i;
					tj=j;
				}
			}
		}
		for(int i=ti;i<=tj;i++) {
			System.out.print(arr[i]+" ");
		}*/
	}
}
