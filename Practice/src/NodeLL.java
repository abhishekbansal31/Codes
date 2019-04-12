import java.util.Scanner;
public class NodeLL {
	int data;
	NodeLL next;
	public NodeLL(int data) {
		this.data=data;
		this.next=null;
	}
	void printLL(){
		NodeLL temp=this;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
}
