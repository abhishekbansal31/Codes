import java.util.*;
public class BestDS {
	ArrayList<Integer> al =new ArrayList<Integer>();
	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
	void insert(int num) {
		if(hm.keySet().contains(num)) {
			return;
		}
		al.add(num);
		hm.put(num,al.size()-1);
	}
	void delete(int num) {
		if(!hm.keySet().contains(num)) {
			return;
		}
		int index=hm.get(num);
		int alSize=al.size();
		int element=al.get(alSize-1);
		al.set(index, element);
		hm.put(element, index);
		al.remove(alSize-1);
		hm.remove(num);
	}
	int getRandom() {
		Random r=new Random();
		return al.get(r.nextInt(al.size()));
	}
	int search(int num) {
		if(hm.keySet().contains(num))
			return hm.get(num);
		return -1;
	}
}
