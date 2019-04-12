import java.util.*;
class Node1{
	int data;
	Node1 left;
	Node1 right;
}
public class StockSpan {
	int arr[];
	StockSpan(int n){
		arr=new int[n];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			StockSpan s=new StockSpan(n);
			for(int i=0;i<n;i++) {
				s.arr[i]=sc.nextInt();
			}
			int b[]=new int[n];
			Deque<Integer> st[] = new ArrayDeque[2];
			st[0]=new ArrayDeque<Integer>();
			st[1]=new ArrayDeque<Integer>();
			int sum=1;
			for(int i=0;i<n;i++) {
				sum=1;
				if(st[0].isEmpty()) {
					sum=i+1;
				}
				else {
					if(s.arr[i]<(int)st[0].peek()) {
						sum=1;
					}
					else {
						while(!st[0].isEmpty() && st[0].peek()<s.arr[i]) {
							sum=sum+st[1].peek();
							st[0].pop();
							st[1].pop();
						}
					}
					
				}
				b[i]=sum;
				st[0].push(s.arr[i]);
				st[1].push(sum);
			//	System.out.println(st[0].peek()+" "+st[1].peek());
			}
	/*		for(int i=0;i<n;i++) {
				int j=i-1,count=1;
				while(j>=0) {
					if(s.arr[j]<s.arr[i])
						count++;
					else
						break;
					j--;
				}
				b[i]=count;
			}*/
			for(int i=0;i<n;i++) {
				System.out.print(b[i]+" ");
			}
			System.out.println();
		}
	}
}
