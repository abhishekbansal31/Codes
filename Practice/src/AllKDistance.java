
public class AllKDistance {
	int count=0;
//**********************************************************************
	void count(Node node,int k) {
		if(k<0) {
			return;
		}
		if(node==null)
			return;
		if(k==0) {
			count++;
			System.out.print(node.data+" ");
		}
		else {
			count(node.left,k-1);
			count(node.right,k-1);
		}
	}

	int flow(Node root,Node node,int k) {
		if(root==null) {
			return -1;
		}
		if(root==node) {
			count(node,k);
			return 1;
		}
		int left=flow(root.left,node,k);
		if(left!=-1) {
			if(left==k) {
				count++;
				System.out.print(root.data+" ");
			}
			else if(left<k){
				flow(root.right,node,k-left-1);
			}
			return left+1;
		}
		int right=flow(root.right,node,k);
		if(right!=-1) {
			if(right==k) {
				count++;
				System.out.print(root.data+" ");
			}
			else if(right<k) {
				flow(root.left,node,k-right-1);
			}
			return right+1;
		}
		return -1;
	}


	//**********************************************************************





void count2(Node node,int k) {
	if(node==null || k<0) {
		return;
	}
	if(k==0) {
		count++;
	}
	else {
		count2(node.left,k-1);
		count2(node.right,k-1);
	}
}

int flow2(Node root,Node node,int k) {
	if(root==null) {
		return -1;
	}
	if(root==node) {
		count2(node,k);
		return 1;
	}
	int left=flow2(root.left,node,k);
	if(left!=-1) {
		if(left==k) {
			count++;
		}
		else if(left<k) {
			flow2(node.right,node,k-left-1);
		}
		return left+1;
	}
	int right=flow2(node.right,node,k);
	if(right!=-1) {
		if(right==k) {
			count++;
		}
		else if(right<k) {
			flow2(node.left,node,k-right-1);
		}
		return right+1;
	}
	return -1;
}



//**********************************************************************
}








































