import java.util.*;
public class Sorting {
	static int[] bubbleSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					arr[j]+=arr[j+1];
					arr[j+1]=arr[j]-arr[j+1];
					arr[j]-=arr[j+1];
				}
			}
		}
		return arr;
	}
	static int[] selectionSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			int min=arr[i],k=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<min) {
					min=arr[j];
					k=j;
				}
			}
			arr[k]=arr[i];
			arr[i]=min;
		}
		return arr;
	}
	static int[] insertionSort(int[] arr) {
		int n=arr.length;
		int j=0;
		for(int i=1;i<n;i++) {
			j=i-1;
			int temp=arr[i];
			while(j>=0 && arr[j]>temp) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
		return arr;
	}
	static void merge(int[] arr,int p,int q) {
		int mid=(p+q)/2;
		int[] l=new int[mid-p+1];
		for(int i=0;i<mid-p+1;i++) {
			l[i]=arr[p+i];
		}
		int[] r=new int[q-mid];
		for(int i=0;i<q-mid;i++) {
			r[i]=arr[mid+i+1];
		}
		int x=0,y=0,i=p;
		while(x<l.length && y<r.length) {
			if(l[x]<=r[y]) {
				arr[i]=l[x];
				x++;
			}
			else{
				arr[i]=r[y];
				y++;
			}
			i++;	
		}
		while(x<l.length) {
			arr[i]=l[x];
			x++;
			i++;
		}
		while(y<r.length) {
			arr[i]=r[y];
			y++;
			i++;
		}
	}
	static void mergeSort(int[] arr,int p,int q) {
		if(p<q) {
			int mid=(p+q)/2;
			mergeSort(arr,p,mid);
			mergeSort(arr,mid+1,q);
			merge(arr,p,q);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String c;
		do {
			System.out.println("1. Bubble Sort\n2.Selection Sort\n3.Insertion Sort\n4.Merge Sort");
			int ch=sc.nextInt();
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			switch(ch) {
				case 1:arr=bubbleSort(arr);
				break;
				case 2:arr=selectionSort(arr);
				break;
				case 3:arr=insertionSort(arr);
				break;
				case 4:mergeSort(arr,0,n-1);
				break;
			}
			for(int i=0;i<n;i++)
				System.out.print(arr[i]+" ");
			System.out.println("\nWant to continue?");
			c=sc.next();
		}while(c.equalsIgnoreCase("y"));
		sc.close();
	}
}
