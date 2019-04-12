import java.util.*;
public class RevLLGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			NodeLL head=null,tail=null;
			for(int i=0;i<n;i++) {
				if(head==null) {
					head=new NodeLL(sc.nextInt());
					tail=head;
				}else {
					tail.next=new NodeLL(sc.nextInt());
					tail=tail.next;
				}
			}
			int k=sc.nextInt();
			NodeLL prev=null,current=head,next=null,temp=head;
			
			for(int i=0;i<k && current!=null;i++) {
				
				next=current.next;
				current.next=prev;
				prev=current;
				current=next;
			}
			temp.next=current;
			head=prev;
			while(current!=null) {
				temp=current;
				for(int j=0;j<k-1 && temp!=null;j++) {
					temp=temp.next;
				}
				prev=temp;
				if(prev!=null) {
					current=prev.next;
					for(int i=0;i<k && current!=null;i++) {
						next=current.next;
						current.next=prev;
						prev=current;
						current=next;
					}
					if(temp.next!=null) {
						temp.next.next=current;
						temp.next=prev;
					}
				}else
					current=null;
			}
			head.printLL();
		}
	}

}
