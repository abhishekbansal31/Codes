import java.util.*;
import java.io.*;
public class StockProfitLoss {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.valueOf(br.readLine());
		while(t-->0) {
			int n=Integer.valueOf(br.readLine());
			int arr[]=new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<n;i++) {
				arr[i]=Integer.valueOf(st.nextToken());
			}
			int i=0,j=1,count=0;
			while(j<n) {
				if(arr[j]>=arr[j-1]) {
					j++;
				}
				else {
					if(i!=j-1) {
						System.out.print("("+i+" "+(j-1)+") ");
						count++;
					}
					i=j;
					j++;
				}
			}
			if(i!=n-1) {
				System.out.print("("+i+" "+(n-1)+") ");
				count++;
			}
			if(count==0) {
				System.out.print("No Profit");
			}
			System.out.println();
		}
	}
}