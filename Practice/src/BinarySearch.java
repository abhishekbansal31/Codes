import java.util.*;
public class BinarySearch {
	static int search(int[] arr,int num) {
		int big=0,end=arr.length-1,mid=end/2;
		while(big<=end) {
			mid=(big+end)/2;
			if(num==arr[mid]) {
				return mid;
			}
			else if(num<arr[mid]) {
				end=mid-1;
			}
			else
				big=mid+1;
		}
			return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		while(t-->0) {
		int num=sc.nextInt();
		System.out.println(search(arr,num));
	}}
}
