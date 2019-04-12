import java.util.*;
class Node{
	int data;
	Node left,right,nextLeft;
}
public class NextLeft {
	void nL(Node temp) {
		temp.nextLeft=null;
		temp.left.nextLeft=null;
		recnL(temp,temp.right,1);
	}
	Node recnL(Node temp1,Node temp2 ,int x) {
		if(temp1==null) {
			return null;
		}
		if(temp2==null) {
			if(x==0) {
				Node temp3=temp1.nextLeft;
				return recnL(temp3,temp3.right,1);
				//temp2=temp1.left;
			}
			else {
				if(temp1.nextLeft!=null){
					temp1=temp1.nextLeft;
					temp2=temp1.right;
				}
			}
		}
		else if(temp2==temp1.right) {
			if(temp1.left!=null)
				temp2.nextLeft=recnL(temp1,temp1.left,0);
			else {
				Node temp3=temp1.nextLeft;
				temp2.nextLeft=recnL(temp3,temp3.right,1);
			}
		}
		else if(temp2==temp1.left) {
			Node temp3=temp1.nextLeft;
			if(temp3==null)
				temp2.nextLeft=null;
			else
				temp2.nextLeft=recnL(temp3,temp3.right,1);
		}
		return temp2;
	}
}
