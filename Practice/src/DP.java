import java.util.*;
public class DP {
	static int n;
	static int[] arr;
	static int state(int m) {
		if(m<0)
			return arr[0];
		if(m==0)
			return 1;
		if(arr[m]!=0) {
			System.out.println(m+"="+arr[m]);
			return arr[m];
		}
		arr[m]=state(m-1)+state(m-3)+state(m-5);
		return arr[m];
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		arr=new int[n+1];
		arr[0]=0;
		System.out.println(state(n));
	}

}
