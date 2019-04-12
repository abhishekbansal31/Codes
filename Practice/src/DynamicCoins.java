import java.util.Scanner;

public class DynamicCoins {
	static int n,arr[];
	static int coins(int m) {
		if(m<12)
			return m;
		if(arr[m]!=0) {
			return arr[m];
		}
		/*if(m>(m/2+m/3+m/4)) {
			arr[m]=m;
			return m;
		}*/
		
		arr[m]=Math.max(m,coins(m/2)+coins(m/3)+coins(m/4));
		return arr[m];
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		arr=new int[n+1];
		System.out.println(coins(n));
		sc.close();
	}

}
