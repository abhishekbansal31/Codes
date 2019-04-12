import java.util.*;
public class SubArrayofEqualSum {
	static void func(int[] arr,int sum) {
		int n=arr.length;
		int sum2=arr[0],start=0;
		for(int i=1;i<=n;i++) {
			while(sum2>sum && start<i-1){
    		    sum2-=arr[start];
    			start++;
			}
			if(sum2==sum) {
				System.out.println((start+1)+" "+(i));
				return;
			}
			if(i<n) {
				sum2=sum2+arr[i];
			}
		}
		System.out.println(-1);
	}
	public static void main (String[] args) {
	    Scanner sc =new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0){
	        int n=sc.nextInt();
	        int sum=sc.nextInt();
	        int arr[]=new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=sc.nextInt();
	        }
	        func(arr,sum);
	    }
	    sc.close();
	}
}