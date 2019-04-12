import java.util.*;
public class ChocolateDistribution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			int m=sc.nextInt();
			Arrays.sort(arr);
			int diff=0,min=Integer.MAX_VALUE;
			for(int i=0;i<n-m+1;i++) {
				diff=arr[m+i-1]-arr[i];
				if(diff<min) {
					min=diff;
				}
			}
			System.out.println(min);
		}
	}

}
