import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
public class RainWater {
	int size;
	int[] arr;
	
	RainWater(String size, String args){
		this.size = Integer.valueOf(size);
		this.arr = new int[this.size];
		for(int i=0;i<this.size;i++) {
			arr = Arrays.stream(args.split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	}
	
	protected int getWater() {
		if(size<3) {
			return 0;
		}
		Deque<Integer> stack = new LinkedList<Integer>();
		int water = 0;
		for(int i=0;i<size;i++) {
			if(arr[i]!=0) {
				if(stack.isEmpty()) {
					stack.push(i);
				}
				else {
					water += Math.min(arr[i],arr[stack.peek()])*(i-stack.peek()-1);
					if(arr[i]<arr[stack.peek()]) {
						stack.push(arr[i]);
					}
					else {

						int temp = stack.pop();
						if(arr[i]>arr[stack.peek()]) {
							
							while(!stack.isEmpty() || arr[i]>arr[temp]) {
								water += Math.min(arr[i]-arr[temp], arr[stack.peek()]-arr[temp])*(i-stack.peek()-1);
								temp = stack.pop();
							}
						}
					}
				}
			}
			
		}
		return water;
	}
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		RainWater r = new RainWater(br.readLine(),br.readLine());
		System.out.println(r.getWater());
	}
}
