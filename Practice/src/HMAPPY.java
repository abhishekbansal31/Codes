import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class HMAPPY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int q=sc.nextInt();
		int k=sc.nextInt();
		LinkedList<Integer> ll=new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			ll.add(sc.nextInt());
		}
		String s = sc.next();
		int count=0,max=0,begin=0,end=0,begin2=0,end2=0,max2=0,beginmax=0;
		Iterator<Integer> itr= ll.iterator();
		for(int i=0;i<n;i++) {
			if(itr.next()==0) {
				count=0;
			}
			else {
				count++;
			}
			if(count>max) {
				max=count;
				end=i;
			}
		}
		begin=end-max+1;
		itr=ll.iterator();
		count=0;
		for(int i=0;i<n;i++) {
			if(i<begin || i >end) {
				if(itr.next()==0) {
					count=0;
				}
				else {
					count++;
				}
				if(count<max && count>max2) {
					end2=i;
					max2=count;
				}
			}
			else {
				itr.next();
				count=0;
			}
		}
		itr=ll.iterator();
		while(itr.hasNext() && itr.next()==1) {
			beginmax++;
		}
		for(int i=0;i<q;i++) {
			char ch=s.charAt(i);
			if(ch=='!') {
				int temp=ll.removeLast();
				ll.addFirst(temp);
				if(temp==1) {
					if(beginmax<n) {
						beginmax++;
						if(begin!=n-1) {
							begin++;
						}
						if(end!=n-1) {
							end++;
						}
						else {
							max--;
						}
						if(begin2!=n-1) {
							begin2++;
						}
						if(end2!=n-1) {
							end2++;
						}
						else {
							max2--;
						}
						if(beginmax>=max) {
							if(begin>beginmax && max>max2) {
								begin2=begin;
								end2=end;
								max2=max;
							}
							begin=0;
							end=beginmax-1;
							max=beginmax;
						}
						else if(beginmax>=max2 && end!=n-1){
							begin2=0;
							end2=beginmax-1;
							max2=beginmax;
						}
						if(max2>max) {
							int temp1=begin;
							begin=begin2;
							begin2=temp1;
							temp1=end;
							end=end2;
							end2=temp1;
							temp1=max;
							max=max2;
							max2=temp1;
						}
					}
				}
				else {
					beginmax=0;
					if(begin!=n-1) {
						begin++;
					}
					if(end!=n-1) {
						end++;
					}
					if(begin2!=n-1) {
						begin2++;
					}
					if(end2!=n-1) {
						end2++;
					}
				}
			}
			else {
				if(max<k) {
					System.out.print(max+" ");
				}
				else {
					System.out.print(k+" ");
				}
			}
			//System.out.println("  begin= "+begin+"  end= "+end+"  max="+max+"  beginmax="+beginmax+" secondbegin="+begin2+"  secondend"+end2+"   secondmax="+max2+ll);
			
		}
	}
	
}

/*
24 50 10
1 1 1 0 0 1 1 1 1 1 0 1 1 1 1 1 1 1 0 1 1 1 1 1
?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!

50 201 25
1 1 1 1 0 0 0 1 0 1 0 0 1 1 1 1 1 1 1 1 0 0 1 1 1 1 0 1 0 0 0 1 1 1 1 1 1 1 1 0 0 0 1 1 1 1 1 1 1 1
?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?!?
*/