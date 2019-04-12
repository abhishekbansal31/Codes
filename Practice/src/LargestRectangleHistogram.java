import java.util.*;
public class LargestRectangleHistogram {
	int largestRectangle(int[] arr) {
		int n=arr.length;
		Deque<Integer> stack = new LinkedList<Integer>();
		int i=0,temp=0,area=0,max=0;
		while(i<n) {
			if(stack.isEmpty() || arr[stack.peek()]<arr[i]) {
				stack.push(i);
				i++;
			}
			else {
				temp=stack.pop();
				area=arr[temp]*(stack.isEmpty()?i:i-stack.peek()-1);
				if(max<area) {
					max=area;
				}
			}
		}
		while(!stack.isEmpty()) {
			temp=stack.pop();
			area=arr[temp]*(stack.isEmpty()?i:i-stack.peek()-1);
			if(max<area) {
				max=area;
			}
		}
		return max;
	}
}
