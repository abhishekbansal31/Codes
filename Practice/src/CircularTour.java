import java.util.*;
public class CircularTour {

}
class GfG
{
    int tour(int petrol[], int distance[])
    {
	int rest=0,current=0,n=petrol.length;
	Queue<Integer> q = new LinkedList<Integer>();
	    while(q.size()!=n){
	        if((rest+petrol[current])<distance[current]){
	            if(q.peek()==(current+1)%n){
	                return -1;
	            }
	            int temp=q.peek();
	            q.remove();
	            rest=rest+distance[temp]-petrol[temp];
	            if(rest==0){
	                current++;
	                current=current%n;
	            }
	        }
	        else{
	            q.add(current);
	            rest=rest+petrol[current]-distance[current];
	            current++;
	            current=current%n;
	        }
	    }
	    return q.peek();
    }
}