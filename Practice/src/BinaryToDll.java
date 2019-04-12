import java.util.*;
class NodeTree{
	int data;
	NodeTree left;
	NodeTree right;
	NodeTree(int data){
		this.data=data;
	}
}
public class BinaryToDll {
	static NodeTree head,n[]=new NodeTree[50];
	NodeTree Dll(NodeTree root) {
		if(root==null)
			return null;
		Dll(root.right);
		root.right=head;
		if(head!=null)
			head.left=root;
		head=root;
		Dll(root.left);
		return root;
		/*
		if(n[root.data]!=null)
			return n[root.data];
		else {
			NodeTree temp=Dll(root.left);
			if(temp!=null)
				temp.right=root;
			root.left=temp;
			temp=Dll(root.right);
			if(temp!=null)
				temp.left=root;
			root.right=temp;
		}
		return n[root.data]=root;
		*/
	}
	class NodeDLL{
		int data;
		NodeDLL prev,next;
		NodeDLL(int data){
			this.data=data;
		}
	}
	NodeDLL left=null,head2=null;
	NodeDLL btDll(Node node){
		if(node==null){
			return null;
		}
		btDll(node.left);
		NodeDLL current=new NodeDLL(node.data);
		current.prev=left;
		if(left==null){
			head2=current;
		}
		else{
			left.next=current;
		}
		left=current;
		btDll(node.right);
		return current;
		
	}
	
			//     DLL to BST
	NodeDLL head3;
	NodeTree DLLtoBTUtil(int n){
		if(n<=0)
			return null;
		NodeTree left=DLLtoBTUtil(n/2);
		NodeTree node=new NodeTree(head3.data);
		node.left=left;
		head3=head3.next;
		node.right=DLLtoBTUtil(n-n/2-1);
		return node;
	}
	
	
	public static void main(String args[]) {
		
	}
}
