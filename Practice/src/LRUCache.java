import java.util.*;
public class LRUCache {
	Queue<Integer> q;
	HashMap<Integer,Integer> hm;
	int capacity;
	public LRUCache(int capacity){
		this.capacity=capacity;
		q=new LinkedList<Integer>();
		hm=new HashMap<Integer,Integer>();
	}
	public void set(int key,int value) {
	    if(hm.containsKey(key)){
	        q.remove(key);
	    }
	    else if(q.size()==capacity){
	        int temp=q.remove();
	        hm.remove(temp);
	    }
		q.add(key);
		hm.put(key, value);
	}
	public int get(int key) {
		if(!hm.containsKey(key)) {
			return -1;
		}
		q.remove(key);
		q.add(key);
		return hm.get(key);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int q=sc.nextInt();
			LRUCache lru = new LRUCache(n);
			while(q-->0) {
				String s=sc.next();
				if(s.equals("SET")) {
					int key=sc.nextInt();
					int value=sc.nextInt();
					lru.set(key, value);
					System.out.println(lru.hm.keySet());
				}
				else {
					int key=sc.nextInt();
					lru.get(key);
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
