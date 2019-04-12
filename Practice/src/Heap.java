
public interface Heap {
	abstract int parent(int x);
	abstract int left(int x);
	abstract int right(int x);
	abstract void createHeap(int[] arr);
//	abstract void insert(int x,int y);
	abstract int extract();
	abstract int delete(int key);
}
