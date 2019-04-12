import java.util.*;
public class TappingRainWater {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int[] arr =new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			int count=0,temp=0;
			int area[]=new int[n];
			Deque<Integer> stack = new LinkedList<Integer>();
			int start=0;
			while(start<n && arr[start]==0) {
				area[start]=0;
				start++;
			}
			stack.push(start);
			for(int i=start+1;i<n;i++) {
				temp=0;
				if(arr[i]==0) {
					area[i]=area[i-1];
					count++;
				}
				else {
					if(arr[i]<=arr[stack.peek()]) {
						temp=count*arr[i];
						//System.out.println("temp = "+temp +"stack = "+stack);
						stack.push(i);
						area[i]=area[i-1]+temp;
					}
					else {
						if(stack.size()==1) {
							temp=count*arr[stack.peek()];
							//System.out.println("temp = "+temp +"stack = "+stack);
							area[i]=area[i-1]+temp;
							stack.pop();
							stack.push(i);
						}
						else {
							temp=count*arr[stack.peek()];
							//System.out.println("temp = "+temp +"stack = "+stack);
							int k=stack.pop();
							area[i]=area[i-1]+temp;
							while(stack.size()>0) {
								int j=stack.pop();
								temp=Math.min((arr[j]-arr[k]),arr[i]-arr[k])*(i-j-1);
								//System.out.println("temp = "+temp +"stack = "+stack);
								k=j;
								area[i]+=temp;
								if(arr[j]>=arr[i]) {
									if(arr[j]>arr[i])
										stack.push(j);
									break;
								}
							}
							stack.push(i);
						}
					}
					count=0;
				}
			}
			System.out.println(area[n-1]);
		}
	}
}
