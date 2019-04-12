import java.util.*;
public class MinHeap implements Heap{
	int heap[],heapsize;
	public int parent(int index) {
		return index/2;
	}
	public int left(int index) {
		return 2*index;
	}
	public int right(int index) {
		/*if(index==0)
			return 2;*/
		return 2*index+1;
	}
	public void createHeap(int arr[]) {
		heapsize=arr.length;
		heap=new int[arr.length+1];
		for(int i=1;i<=arr.length;i++) {
			heap[i]=arr[i-1];
		}
		for(int i=heapsize/2;i>0;i--) {
			minHeapify(i);
		}
	}
	void minHeapify(int index) {
		if(index==0)
			return ;
		int left = left(index);
		int right = right(index);
		int smallest = index;
		if(left<=heapsize && (heap[left]<heap[smallest])) {
			smallest=left;
		}
		if(right<=heapsize && (heap[right]<heap[smallest])) {
			smallest=right;
		}
		if(smallest!=index) {
			int temp=heap[smallest];
			heap[smallest]=heap[index];
			heap[index]=temp;
			minHeapify(smallest);
		}
	}
	public void insert(int data) {
		heapsize++;
		if(heapsize>heap.length) {
			System.out.print("Out of space");
			return;
		}
		heap[heapsize]=data;
		int k=heapsize,temp=0;
		while(k>0 && heap[parent(k)]>heap[k]) {
			temp=heap[k];
			heap[k]=heap[parent(k)];
			heap[parent(k)]=temp;
			k=parent(k);
		}
	}
	public int extract() {
		return delete(1);
	}
	public int delete(int index) {
		int temp=heap[index];
		heap[index]=heap[heapsize];
		heapsize--;
		minHeapify(index);
		return temp;
	}
	void printHeap() {
		for(int i=1;i<=heapsize;i++) {
			System.out.print(heap[i]+" ");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		MinHeap mh =new MinHeap();
		mh.createHeap(arr);
		mh.printHeap();
		mh.extract();
		mh.printHeap();
		mh.extract();
		mh.printHeap();
	}
}