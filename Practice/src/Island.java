import java.util.*;
public class Island {
	static int count=0;
	static void func(int arr[][]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				count=count+recFunc(arr,i,j);
			}
		}
	}
	static int recFunc(int arr[][],int i,int j) {
		if(i<0 || j<0 || i>=arr.length || j>=arr.length) {
			return 0;
		}
		else if(arr[i][j]==0 || arr[i][j]==-1) {
			return 0;
		}
		arr[i][j]=-1;
		recFunc(arr,i,j+1);
		recFunc(arr,i,j-1);
		recFunc(arr,i-1,j);
		recFunc(arr,i+1,j);
		recFunc(arr,i-1,j-1);
		recFunc(arr,i+1,j+1);
		recFunc(arr,i+1,j-1);
		recFunc(arr,i-1,j+1);
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int row=sc.nextInt();
		int column=sc.nextInt();
		int [][]arr=new int[row][column];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		func(arr);
		System.out.print(count);
	}

}
