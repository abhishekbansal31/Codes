import java.util.*;
import java.io.*;
public class CHHAPPY {
		static int func(int arr[]) {
			int n=arr.length;
			HashMap<Integer,LinkedList<Integer>> hm = new HashMap<Integer,LinkedList<Integer>>();
			for(int i=0;i<n;i++) {
				LinkedList<Integer> temp;
				if(hm.isEmpty() || !hm.containsKey(arr[i])) {
					temp=new LinkedList<Integer>();
					temp.addFirst(i);
				}
				else {
					temp=hm.get(arr[i]);
					temp.addFirst(i);
				}
				hm.put(arr[i], temp);
			}
			/*Set s = hm.entrySet();
			Iterator itr = s.iterator();
			while(itr.hasNext()) {
				Map.Entry<Integer, Integer> e = (Map.Entry)itr.next();
				System.out.println(e.getKey()+" "+e.getValue());
			}*/
			int count=0,k=arr[0];
			for(int i=0;i<n;i++) {
				if(arr[i]==k) {
					count++;
				}
			}
			if(count==n) {
				return 0;
			}
			for(int i=0;i<n;i++) {
				LinkedList<Integer> temp=hm.get(arr[i]);
				Iterator<Integer> itr2 = temp.iterator();
				while(itr2.hasNext()) {
					int temp2=itr2.next();
					if(temp2!=i && hm.containsKey(i+1) && hm.containsKey(temp2+1)) {
						return 1;
					}
				}
				temp.removeLast();
				hm.put(arr[i], temp);
				/*Set s1 = hm.entrySet();
				Iterator itr1 = s1.iterator();
				while(itr1.hasNext()) {
					Map.Entry<Integer, Integer> e1 = (Map.Entry)itr1.next();
					System.out.println(e1.getKey()+" "+e1.getValue());
				}*/
			}
			
			return 0;
		}
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
			//Scanner sc =new Scanner(System.in);
			//int t=sc.nextInt();
			String s=reader.readLine();
			int t=Integer.valueOf(s);
			while(t-->0) {
				//int n=sc.nextInt();
				s=reader.readLine();
				int n=Integer.valueOf(s);
				StringTokenizer st=new StringTokenizer(reader.readLine()," ");
				int []arr=new int[n];
				for(int i=0;i<n;i++) {
					//arr[i]=sc.nextInt();
					arr[i]=Integer.valueOf(st.nextToken());
				}
				if(func(arr)==1){
					System.out.println("Truly Happy");
				}
				else {

					System.out.println("Poor Chef");
				}
			}
			//sc.close();
		}
	}