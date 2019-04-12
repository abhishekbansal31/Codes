import java.util.Scanner;
class QNode{
	int data;
	QNode next;
	QNode prev;
}
public class Q {
	QNode front,rear;
	void insert(int key) {
		QNode temp=new QNode();
		temp.data=key;
		temp.next=front;
		if(front!=null) {
			front.prev=temp;
		}
		if(rear==null) {
			rear=temp;
		}
		front=temp;
	}
	QNode peek() {
		if(!isEmpty()) {
		return front;
		}
		return null;
	}
	boolean isEmpty() {
		if(front==null && rear==null) {
			return true;
		}
		return false;
	}
	QNode remove() {
		QNode temp=rear;
		if(temp.prev==null) {
			front=null;
			rear=null;
			return temp;
		}
		temp.prev.next=null;
		rear=temp.prev;
		return temp;
	}
	void printQueue() {
		if(front==null) {
			System.out.println("Queue is Empty");
		}else {
			for(QNode temp=front;temp!=null;temp=temp.next) {
				System.out.print(temp.data+" ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Q q=new Q();
		String s;
		do {
			System.out.println("1.Insert\n2.Peek\n3.Remove\n4.Print");
			int n=sc.nextInt();
			switch(n) {
			case 1:q.insert(sc.nextInt());
			break;
			case 2:if(!q.isEmpty()) {
				System.out.println(q.peek().data);
			}
			else {
				System.out.println("Queue is empty");
			}
			break;
			case 3:System.out.println(q.remove().data);
			break;
			case 4:q.printQueue();
			}
			System.out.println("Want to continue?");
			s=sc.next();
		}while(s.equalsIgnoreCase("y"));			
	sc.close();
	}
}
