import java.util.*;
public class LongestIncreasingSubarray {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int len=1;
		int i=1,k=0;
		int max=0;
		while(i<n) {
			if(arr[i]>arr[i-1]) {
				len++;
			}
			else {
				if(max<len) {
					max=len;
					k=i-1;
				}
				len=1;
			}
			i++;
		}

		if(max<len) {
			max=len;
			k=i-1;
		}
		System.out.println(max);
		for(int p=0;p<max;p++) {
			System.out.print(arr[k-max+1+p]+" ");
		}
	}
}
