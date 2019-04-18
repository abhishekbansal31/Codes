//    Implementation of AVL Tree


import java.util.*;

class NodeAVL{
	int data,height;
	NodeAVL left,right;
	NodeAVL(int data){
		this.data=data;
		this.height=1;
	}
}

public class AVLTree {
	NodeAVL root;
	int height(NodeAVL node) {
		if(node==null) {
			return 0;
		}
		return node.height;
	}
	
	
	int balance(NodeAVL node) {
		return height(node.left)-height(node.right);
	}
	
	
	NodeAVL leftRotation(NodeAVL node) {
		NodeAVL right=node.right;
		node.right=right.left;
		right.left=node;
		/*NodeAVL left=node.left;
		node.left=left.right;
		left.right=node;*/
		node.height=1+Math.max(height(node.left), height(node.right));
		right.height=1+Math.max(height(right.right), height(right.left));
		return right;
	}
  /*NodeAVL leftRight(NodeAVL node) {
		NodeAVL left=node.left;
		NodeAVL right=left.right;
		node.left=right;
		left.right=right.left;
		right.left=left;
		return leftLeft(node);
	}
	NodeAVL rightLeft(NodeAVL node) {
		NodeAVL right=node.right;
		NodeAVL left=right.left;
		node.right=left;
		right.left=left.right;
		left.right=right;
		return rightRight(node);
	}*/
	
	
	NodeAVL rightRotation(NodeAVL node) {
		NodeAVL left=node.left;
		node.left=left.right;
		left.right=node;
		/*NodeAVL right=node.right;
		node.right=right.left;
		right.left=node;*/
		node.height=Math.max(height(node.left),height(node.right));
		left.height=Math.max(height(left.left),height(left.right));
		return left;
	}
	
	
	NodeAVL insert(NodeAVL node,int data) {
		if(node==null) {
			return new NodeAVL(data);
		}
		if(data<node.left.data) {
			node.left=insert(node.left,data);
		}
		else if(data>=node.right.data) {
			node.right=insert(node.right,data);
		}
		node.height=1+Math.max(height(node.left), height(node.right));
		int balance=balance(node);
		if(balance>1 && data<node.left.data) {
			//LL - Left Left
			node=rightRotation(node);
		}
		if(balance>1 && data>node.left.data) {
			//LR - Left Right
			node.left=leftRotation(node.left);			//converted to LL
			node=rightRotation(node);
		}
		if(balance<-1 && data<node.right.data) {
			//RL - Right Left
			node.right=rightRotation(node.right);		//converted to RR
			node=leftRotation(node);
		}
		if(balance<-1 && data>node.right.data) {
			//RR - Right Right
			node=leftRotation(node);
		}
		return node;
	}
	
	
	NodeAVL delete(NodeAVL node,int data) {
		if(node==null) {
			return null;
		}
		if(node.data<data) {
			node.left=delete(node.left,data); 
		}
		else if (node.data>data) {
			node.right=delete(node.right,data);
		}
		else {
			if(node.left==null) {
				return node.right;
			}
			else if(node.right==null) {
				return node.left;
			}
			else {
				NodeAVL temp=node.right;
				while(temp.left!=null) {
					temp=temp.left;
				}
				node.data=temp.data;
				 node.right=delete(node.right,temp.data);
			}
			
		}
		node.height=1+Math.max(height(node.left), height(node.right));
		int balance = balance(node);
		if(balance>1 && balance(node.left)>=0) {
			return rightRotation(node);
		}
		if(balance>1 && balance(node.left)<0) {
			node.left=leftRotation(node.left);
			return rightRotation(node);
		}
	
		if(balance<-1 &&balance(node.right)>0) {
			node.right=rightRotation(node.right);
			return leftRotation(node);
		}
		if(balance<-1 &&balance(node.right)<=0) {
			return leftRotation(node);
		}
		return node;
	}
	
	
	void display(NodeAVL node) {
		if(node==null) {
			return;
		}
		display(node.left);
		System.out.println(node.data);
		display(node.right);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		AVLTree avl=new AVLTree();
		System.out.println("1.Insert\n2.Delete\n3.Display");
		int n=sc.nextInt();
		switch(n) {
		case 1: avl.root=avl.insert(avl.root,sc.nextInt());
		break;
		case 2: avl.root=avl.delete(avl.root,sc.nextInt());
		break;
		case 3: avl.display(avl.root);
		break;
		}
	}
	
}