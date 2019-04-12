import java.util.Scanner;
public class BST {
	int value;
	static int height,size;
	static BST root;
	BST left,right;
	void insert(int data) {
			BST node=new BST();
			node.value=data;
			node.left=null;
			node.right=null;
			size++;
			if(root==null) {
				root=node;
				return;
			}
			BST temp=root,temp2=root;
			while(temp!=null) {
				temp2=temp;
				if(data<temp.value) {
					temp=temp.left;
				}
				else {
					temp=temp.right;
				}
			}
			if(data<temp2.value) {
				temp2.left=node;
			}
			else {
				temp2.right=node;
			}
		}
	void delete(int n) {
		if(root==null) {
			System.out.println("No such element exist");
		}
		BST temp=root,temp2=root;
		try {
				while(temp.value!=n) {
					temp2=temp;
					if(n<temp.value) {
						temp=temp.left;
					}
					else {
						temp=temp.right;
					}
				}
		
				if(temp.left==null && temp.right==null) {	//No child
					if(temp2.left!=null && temp2.left.value==n) {
						temp2.left=null;
					}
					else if(temp2.right!=null && temp2.right.value==n) {
						temp2.right=null;
					}
				}
															//One Child
				else if(temp.left==null) {					//Right Child
					if(temp2.left!=null && temp2.left.value==n) {
						temp2.left=temp.right;
					}
					else if(temp2.right!=null && temp2.right.value==n) {
						temp2.right=temp.right;
					}
				}
				else if(temp.right==null) {					//Left Child
					if(temp2.left!=null && temp2.left.value==n) {
						temp2.left=temp.left;
					}
					else if(temp2.right!=null && temp2.right.value==n) {
						temp2.right=temp.left;
					}
				}
				else {
					BST succ,succ2=temp;
					succ=temp.right;
					while(succ.left!=null) {
						succ2=succ;
						succ=succ.left;
					}
					temp.value=succ.value;
					if(succ2.left==succ) {
						succ2.left=null;
					}
					else {
						temp.right=null;
					}
				}
		}
		catch(NullPointerException npe) {				// If element is not in the tree.
			System.out.println("No such element");
		}
	}
	void inOrder(BST node) {
		if(node==null) {
			return;
		}
		inOrder(node.left);
		System.out.printf(node.value+" ");
		inOrder(node.right);
	}
	void preOrder(BST node) {
		if(node==null) {
			return;
		}
		System.out.printf(node.value+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	void postOrder(BST node) {
		if(node==null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.printf(node.value+" ");		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BST bst=new BST();
		int k;
		String s;
		do {
			System.out.println("1.Insert"+"\t"+"2.Delete"+"\t"+"3.Display");
			k=sc.nextInt();
			switch(k) {
				case 1:
					int n=sc.nextInt();
					bst.insert(n);
				break;
				case 2:
					System.out.println("enter to delete");
					int y=sc.nextInt();
					bst.delete(y);
				break;
				case 3:
					System.out.println("1. InOrder"+"\t"+"2.PreOrder"+"\t"+"3.PostOrder");
					int ch=sc.nextInt();
					switch(ch) {
					case 1:bst.inOrder(root);
					break;
					case 2:bst.preOrder(root);
					break;
					case 3:bst.postOrder(root);
					break;
					}
					System.out.println();
				break;
			}
			System.out.println("Want to continue?");
			s=sc.next();
		}while(s.equalsIgnoreCase("y"));
		sc.close();
	}
}