import java.util.Scanner;
public class MaxHeap implements Heap{
	int heap[],heapsize;
	public int parent(int index) {
		return index/2;
	}
	public int left(int index) {
		return 2*index;
	}
	public int right(int index) {
		return 2*index+1;
	}
	public void insert(int data) {
		heapsize++;
		if(heapsize>heap.length) {
			System.out.print("Out of space");
			return;
		}
		heap[heapsize]=data;
		int k=heapsize,temp=0;
		while(k>0 && heap[parent(k)]<heap[k]) {
			temp=heap[k];
			heap[k]=heap[parent(k)];
			heap[parent(k)]=temp;
			k=parent(k);
		}
	}
	public int extract() {
		return delete(1);
	}
	public void createHeap(int arr[]) {
		heapsize=arr.length+1;
		heap=new int[heapsize+1];
		for(int i=0;i<arr.length;i++)
			heap[i+1]=arr[i];
		for(int i=heapsize/2;i>0;i++)
			maxHeapify(i);
	}
	public void printHeap() {
		for(int i=1;i<=heapsize;i++) {
			System.out.print(heap[i]+" ");
		}
	}
	public void maxHeapify(int index) {
		if(index==0)
			return;
		int l=left(index);
		int r=right(index);
		int largest=index;
		if(l<=heapsize && heap[l]>heap[largest]) {
			largest=l;
		}
		if(r<=heapsize && heap[r]>heap[largest]) {
			largest=r;
		}
		if(largest!=index) {
			int temp=heap[largest];
			heap[largest]=heap[index];
			heap[index]=temp;
			maxHeapify(largest);
		}
	}
	public int delete(int index) {
		int temp=heap[index];
		heap[index]=heap[heapsize];
		heapsize--;
		maxHeapify(index);
		return temp;
	}
	public boolean decreaseKey(int index,int data) {
		if(heap[index]<data)
			return false;
		heap[index]=data;
		maxHeapify(index);
		return true;
	}
	public int[] heapSort(int []arr) {
		createHeap(arr);
		for(int i=1;i<=heapsize;i++) {
			arr[i-1]=extract();
		}
		return arr;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}