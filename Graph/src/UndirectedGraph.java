

import java.util.*;

public class UndirectedGraph extends Graph {
	
	/*
	 *  Construct a layout for an undirected graph
	 */
	UndirectedGraph(int size){
		this.size = size;
		this.start = 0;
		this.graph = new LinkedList[this.size];
		for(int temp=0 ; temp < this.size ; temp++) {
			this.graph[temp] = new LinkedList<Integer>();
		}		
	}
	
	
	/* 
	 * Construct actual graph(non-Javadoc)
	 * @see Graph.Graph#addedge(int, int)
	 */
	void addedge(int vertex1, int vertex2) throws VertexOutOfBoundException{

		if(vertex1>=0 && vertex1<this.size && vertex2>=0 && vertex2<this.size ){
			this.graph[vertex1].add(vertex2);
			this.graph[vertex2].add(vertex1);
		}
		else {
			throw new VertexOutOfBoundException("Invalid input: 0<= vertex1,vertex2 < Number of vertices in graph");
		}
		
	}
	
	/* Breadth First Search
	 * (non-Javadoc)
	 * @see Graph.Graph#bfs()
	 */
	void bfs() {
		boolean visited[] = new boolean[this.size];
		Arrays.fill(visited, false);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(this.start);
		
		visited[this.start] = true;
		
		while( !queue.isEmpty() ) {
			int front = queue.remove();
			System.out.print(front + " ");
			Iterator<Integer> itr = this.graph[front].iterator();
			while(itr.hasNext()) {
				int neighbour = itr.next();
				if( !visited[neighbour] ) {
					visited[neighbour] = true;
					queue.add(neighbour);		// All unvisited neighbours of the vertex will be lined up in a queue
				}
			}
		}
	}
	
	
	/* Depth First Search
	 * (non-Javadoc)
	 * @see Graph.Graph#dfs()
	 */
	void dfsUtil(boolean visited[],int vertex) {
		System.out.print(vertex+" ");
		visited[vertex] = true;
		Iterator<Integer> itr = this.graph[vertex].iterator();
		while(itr.hasNext()) {
			int temp = itr.next();
			if(!visited[temp]) {
				this.dfsUtil(visited,temp);
			}
		}
	}
	void dfs() {
		boolean visited[] = new boolean[this.size];
		Arrays.fill(visited, false);
		for(int vertex=0; vertex<this.size ; vertex++) {
			if(!visited[vertex]) {
				this.dfsUtil(visited , vertex);
			}
		}
	}
	

	/* 
	 * Main method
	 */
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
	// 	Enter n=Number of vertices in required graph
		System.out.println("Enter number of vertices in graph(Size of graph)");
		int size = sc.nextInt();

	//	Create Undirectional Graph
		Graph graph = new UndirectedGraph(size);

	//	Enter Number of Edges
		System.out.println("Enter number of Edges and from next line enter vertices seperated by space");
		int edges = sc.nextInt();
		
	//	Connect vertex1 and vertex2 method
		do {
			System.out.println("Enter vertex1 and vertex2");
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			
	//	Invalid vertex Exception Handling
			try {
				graph.addedge(vertex1 , vertex2);
			}catch(VertexOutOfBoundException vertexException) {
				System.out.println("Previous line input is discarded, Enter again");
				edges++;	
			}
		}while(edges-- > 1);
		
		
		System.out.println("Enter your choice: \n   1.BFS\n   2.DFS\n");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				graph.bfs();
				break;
			
			case 2:
				graph.dfs();
				break;
			
			default:
				System.out.println("Wrong Choice");
			
		}
		
		sc.close();
	}
}