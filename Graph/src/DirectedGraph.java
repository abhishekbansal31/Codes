

import java.util.*;

public class DirectedGraph extends Graph {
	
	/*
	 *  Construct a layout for a Directed graph
	 */
	DirectedGraph(int size, int start){
		this.size = size;
		this.start = start;
		graph = new LinkedList[size];
		for(int temp=0 ; temp < this.size ; temp++) {
			this.graph[temp] = new LinkedList<Integer>();
		}		
	}
	
	
	/* 
	 * Construct actual graph(non-Javadoc)
	 * @see Graph.Graph#addedge(int, int)
	 */
	void addedge(int vertex1, int vertex2) throws VertexOutOfBoundException{
		
		if(vertex1>=0 && vertex1<this.size && vertex2>=0 && vertex2<this.size ) {
			this.graph[vertex1].add(vertex2);
		}
		else {
			throw new VertexOutOfBoundException("Invalid input: 0<= vertex1,vertex2 < Number of vertices in graph");
		}
		
	}
	
	/* Breadth First Search
	 * (non-Javadoc)
	 * @see Graph.Graph#bfs()
	 */
	
	void bfsUtil(Queue<Integer> queue, boolean[] visited, int vertex) {
		visited[vertex] = true;
		queue.add(vertex);
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
	void bfs() {
		boolean visited[] = new boolean[size];
		Arrays.fill(visited, false);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		this.bfsUtil(queue, visited, this.start);
		for(int vertex=0; vertex<this.size; vertex++) {
			if(!visited[vertex]) {
				this.bfsUtil(queue, visited, vertex);
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
		Iterator<Integer> itr = graph[vertex].iterator();
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
		this.dfsUtil(visited, this.start);
		for(int vertex = 0; vertex<this.size ; vertex++) {
			if(!visited[vertex]) {
				this.dfsUtil(visited , vertex);
			}
		}
	}
	
	
	/*	Topological Sort
	 *		- For Directed Acyclic Graph (DAG) only
	 *
	 *		- Used for Job Scheduling
	 *
	 *		- Pre-requisite problems
	 *
	 *	(non-Javadoc)
	 *	@see Graph.Graph#topologicalSort()
	 */
	void topologicalSortUtil(boolean[] visited, int vertex, Stack<Integer> stack) {
		visited[vertex] = true;
		Iterator<Integer> itr = this.graph[vertex].iterator();
		while(itr.hasNext()) {
			int temp = itr.next();
			if( !visited[temp] ) {
				this.topologicalSortUtil(visited, temp, stack);
			}
		}
		
		stack.push(vertex);
	}
	Stack<Integer> topologicalSort(){
		boolean[] visited = new boolean[size];
		Arrays.fill(visited, false);
		Stack<Integer> stack = new Stack<Integer>(); 
		for(int vertex=0 ; vertex<size ; vertex++) {
			if( !visited[vertex] ) {
				this.topologicalSortUtil(visited, vertex, stack);
			}
		}
		
		return(stack);
	}
	
	
	
	/* 
	 * Mother Vertex in graph(non-Javadoc)
	 * 		The vertex from where we can reach all other vertex of the graph.
	 * 		
	 * 		A disconnected graph can not have a Mother Vertex, because the unconnected vertex can't be reached by any vertex
	 * 
	 * 		In undirected graph, all vertex are Mother vertex
	 * 
	 * 		In Directed graph, if graph has cycle then multiple mother vertex are possible
	 * 
	 *		Connected Graph may also not have Mother Vertex due to having any unreachable vertex
	 * 
	 * @see Graph.Graph#motherVertex()
	 */
	int motherVertex() {
		int mother = this.topologicalSort().peek();
		boolean visited[] = new boolean[this.size];
		Arrays.fill(visited, false);
		System.out.print("DFS from expected mother vertex: ");
		this.dfsUtil(visited , mother);
		
		for(int temp=0 ; temp<this.size; temp++) {
			if( !visited[temp] ) {				//  if any vertex is not reached from mother vertex then there is no mother vertex
				return -1;
			}
		}
		
		return(mother);
	}
	
	
	/*
	 * 	STRONGLY CONNECTED COMPONENT ( SCC )
	 * 		A graph is said to be a SCC if all vertex of that graph can be reached by any of the vertex in that graph.
	 * 
	 * 		A graph may have multiple SCC which could be identified using following algorithms
	 * 
	 * 																	1)	Kosaraju's Algorithm
	 * 																	2)	Tarjan's Algorithm
	 */
	
	/* 
	 * Kosaraju Algorithm to find Strongly Connected Components in a graph
	 * (non-Javadoc)
	 * @see Graph.Graph#kosaraju()
	 */
	Graph reverse() {
		Graph reverseGraph = new DirectedGraph(size , this.start);
		for(int vertex=0 ; vertex<this.size ; vertex++) {
			Iterator<Integer> itr = this.graph[vertex].iterator();
			while(itr.hasNext()) {
				reverseGraph.graph[itr.next()].add(vertex);
			}
		}
		return reverseGraph;
	}
	void kosaraju() {
		Stack<Integer> stack = this.topologicalSort();
		
		Graph reverseGraph = this.reverse();
		
		boolean[] visited = new boolean[this.size];
		Arrays.fill(visited, false);
		int count = 0;
		while(!stack.isEmpty()) {
			int top = stack.pop();
			if(!visited[top]) {
				count++;
				System.out.print("Vertices in " + count + " SCC : ");
				reverseGraph.dfsUtil(visited, top);
				System.out.println();
			}
		}
		System.out.println("Numbers of SCC in this graph : "+ count);
	}
	
	
	/* 
	 * Tarjan's Algorithm to find Stronly Connected Components in a graph
	 * (non-Javadoc)
	 * @see Graph.Graph#tarjan()
	 */
	int time = 0 , count=0;
	void tarjanUtil(int vertex, int[] discoverTime, int[]minDiscoverTime, boolean[] inStack, Stack<Integer> stack){
		time++;
		
		discoverTime[vertex] = time;
		minDiscoverTime[vertex] = time;
		
		stack.push(vertex);
		inStack[vertex] = true;
		
		Iterator<Integer> itr = this.graph[vertex].iterator();
		
		while(itr.hasNext()) {
			int children = itr.next();
			
			if(discoverTime[children] == -1) {
				tarjanUtil(children, discoverTime, minDiscoverTime, inStack, stack);
			}
			
			/* if children node is already visited and actually one of the ancestors of vertex,
					then the edge could be a back node to the head and se it can be a SCC hence update the value*/
			minDiscoverTime[vertex] = Math.min(minDiscoverTime[vertex] , minDiscoverTime[children] );
		}
		int top;
		if( discoverTime[vertex] == minDiscoverTime[vertex]) {
			while(stack.peek() != vertex) {
				top = stack.pop();
				inStack[top] = false;
				
				System.out.print(top+" ");
			}
			top = stack.pop();
			inStack[top] = false;
			
			System.out.println(top);
			count++;
		}
	}
	void tarjan() {
		int[] discoverTime = new int[this.size];
		int[] minDiscoverTime = new int[this.size];		/*	minimum discovery time of a scc 
		 													,the vertex is head of SCC if
		 												 	discoveryTime[vertex] = mindiscoverTime[vertex]	*/
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] inStack = new boolean[this.size];
		
		Arrays.fill(discoverTime, -1);
		Arrays.fill(minDiscoverTime, -1);
		Arrays.fill(inStack, false);
		
		for(int vertex=0 ; vertex<this.size ; vertex++) {
			if(discoverTime[vertex] == -1) {
				tarjanUtil(vertex, discoverTime, minDiscoverTime, inStack, stack);
			}
		}
		System.out.println("Numbers of SCC in this graph : " + count);
	}
	
	
	/* 
	 * Main method
	 */
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
	// 	Enter n=Number of vertices in required graph
		System.out.println("Enter number of vertices in graph(Size of graph)");
		int size = sc.nextInt();

		System.out.println("Enter the starting vertex");
		int start = sc.nextInt();
		
	//	Create Undirectional Graph
		DirectedGraph g = new DirectedGraph(size, start);

		
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
				g.addedge(vertex1 , vertex2);
			}catch(VertexOutOfBoundException vertexException) {
				System.out.println("Previous line input is discarded, Enter again");
				edges++;	
			}
		}while(edges-- > 1);
		
		
		System.out.println("Enter your choice: \n   1.BFS\n   2.DFS\n   3.Topological Sort(For DAG only)\n"
				+ "   4.Mother Vertex\n   5.Reverse Graph\n   6.Strongly Connected Components using Kosaraju's Algorithm\n"
				+ "   7.Strongly Connected Components using Tarjan's's Algorithm\\n");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				g.bfs();
				break;
			
			case 2:
				g.dfs();
				break;
				
			case 3:
				Stack<Integer> stack = g.topologicalSort();
				while(!stack.isEmpty()) {
					System.out.print(stack.pop()+" ");
				}
				break;
				
			case 4:
				int mother = g.motherVertex();
				if(mother==-1) {
					System.out.println("\nGraph does not have any mother node");
				}
				else {
					System.out.println("\n"+mother);
				}
				break;
				
			case 5:
				Graph reverseGraph=g.reverse();
				reverseGraph.bfs();
				
				break;
				
			case 6:
				g.kosaraju();
				break;
				
			case 7:
				g.tarjan();
				break;
			
			default:
				System.out.println("Wrong Choice");
			
		}

		sc.close();
	}
}


/*	Test cases
10
0
12
0 1
0 5
1 7
3 2
3 4
3 7
3 8
4 8
6 0
6 1
6 2
9 4
4

7
0
8
0 1
1 2
1 3
3 4
0 5
5 6
6 3
0 4
1

5
0
5
0 2
0 3
1 0
2 1
3 4

8
0
10
0 1
1 2
2 0
2 3
3 4
4 5
5 6
5 2
6 7
7 4
*/
