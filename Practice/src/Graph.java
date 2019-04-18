import java.util.*;
public class Graph {
	int V;
	LinkedList<Integer> adj[];
	Graph(int v){
		V=v;
		adj=new LinkedList[V];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList<Integer>();
	}
	void addEdge(int x,int y) {
		adj[x].add(y);
	}
	
	
	// Breadth First Search (Level order traverse)
	
	
	void BFS(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[]=new boolean[V];
		q.add(s);
		visited[s]=true;
		while(!q.isEmpty()) {
			int temp=q.peek();
			System.out.print(temp+" ");
			Iterator<Integer> itr = adj[temp].iterator();
			while(itr.hasNext()) {
				int temp2=itr.next();
				if(visited[temp2]==false) {
					q.add(temp2);
					visited[temp2]=true;
				}
			}
			q.remove();
		}
	}
	
	
	// Depth First Search (Depth order traverse)
	
	
	void DFS(int s) {
		boolean visited[]=new boolean[V];
		DFS2(s,visited);
	}
	
	void DFS2(int s,boolean visited[]) {
		visited[s]=true;
		System.out.print(s+" ");
		Iterator<Integer> itr = adj[s].iterator();
		while(itr.hasNext()) {
			int temp=itr.next();
			if(visited[temp]==false)
				DFS2(temp,visited);
		}
	}
	
	void DFSIterative() {
		boolean visited[]=new boolean[V];
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(0);
		while(!stack.isEmpty()) {
			int temp=stack.pop();
			if(visited[temp]==false) {
				System.out.println(temp+" ");
				visited[temp]=true;
			}
			Iterator<Integer> itr = adj[temp].iterator();
			while(itr.hasNext()) {
				int temp2=itr.next();
				if(visited[temp2]==false) {
					stack.push(temp2);
				}
			}
		}
	}
	
	
	//	Topological Sort ( mainly used for Job Scheduling)
	
	void topologicalUtil(int vertex,Deque<Integer> stack,boolean[] visited) {
		visited[vertex]=true;
		Iterator<Integer> itr = adj[vertex].iterator();
		while(itr.hasNext()) {
			int temp=itr.next();
			if(visited[temp]==false) {
				topologicalUtil(temp,stack,visited);
			}
		}
		stack.add(vertex);
	}

	void topologicalOrder() {
		Deque<Integer> stack = new LinkedList<Integer>();
		boolean visited[] = new boolean[V];
		for(int i=0;i<V;i++) {
			if(visited[i]==false) {
				topologicalUtil(i,stack,visited);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	
	//    using kolaraju's algo   Stronly Connected Component 
	
	
	Graph reverse() {
		Graph g=new Graph(V);
		for(int i=0;i<V;i++) {
			Iterator<Integer> itr = adj[i].iterator();
			while(itr.hasNext()) {
				g.adj[itr.next()].add(i);
			}
		}
		return g;
	}
	void SCC() {
		Deque<Integer> stack =new LinkedList<Integer>();
		boolean visited[] = new boolean[V];
		/*	to check if a graph is strongly connected or not
		 * 
		 * topologicalUtil(0,stack,visited);
		 * 
		 */
		for(int i=0;i<V;i++) {
			topologicalUtil(i,stack,visited);			// for Strongly Connected Components.
		}
		Graph gh = reverse();//A cycle will remain cycle even after reverse, 
							//but non cycle will reverse and wont make SCC by connecting,
							//but they individually will be SCC.
		for(int i=0;i<V;i++) {
			visited[i]=false;
		}
		while(!stack.isEmpty()) {
			int temp=stack.pop();
			if(visited[temp]==false) {
				gh.DFS2(temp,visited);
				System.out.println();
			}
		}
	}

	
	
	// 	using tarjan's algo
	
	
	int time=0;
	void SCCUtil(int i,boolean[] inStack,int desc[],int low[],Deque<Integer> stack){
		desc[i]=low[i]=++time;
		stack.push(i);
		inStack[i]=true;
		Iterator<Integer> itr=adj[i].iterator();
		while(itr.hasNext()) {
			int v=itr.next();
			if(desc[v]==-1) {
				SCCUtil(v,inStack,desc,low,stack);
				low[i]=Math.min(low[i], low[v]);
			}
			else if(inStack[v]==true) {
				low[i]=Math.min(low[i],desc[v]);
			}
		}
		int temp=0;
		if(low[i]==desc[i]) {
			while(stack.isEmpty() && stack.peek()!=i) {
				temp=stack.pop();
				inStack[temp]=false;
				System.out.print(temp+" ");
			}
			temp=stack.pop();
			inStack[temp]=false;
			System.out.println(temp);
		}
	}
	void tarjan() {
		int desc[]=new int[V];
		int low[]=new int[V];
		boolean inStack[]=new boolean[V];
		Deque<Integer> stack =new LinkedList<Integer>();
		for(int i=0;i<V;i++) {
			desc[i]=-1;
			low[i]=-1;
			inStack[i]=false;
		}
		for(int i=0;i<V;i++) {
			if(desc[i]==-1) {
				SCCUtil(i,inStack,desc,low,stack);
			}
		}
	}
	
	
	// Mother Vertex of a DAG
	
	
	int motherVertex() {
		boolean visited[]=new boolean[V];
		int v=0;
		for(int i=0;i<V;i++) {
			if(visited[i]==false) {
				DFS2(i,visited);
				v=i;		// Store last index after which all nodes are visited
			}
		}
		for(int i=0;i<V;i++) {
			visited[i]=false;
		}
		DFS2(v,visited);
		for(int i=0;i<V;i++) {
			if(visited[i]==false) {
				return -1;
			}
		}
		return v;
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();             //9
		Graph g=new Graph(v);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(0, 6);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(5, 7);
		g.addEdge(5, 0);
		g.addEdge(6, 8);
		if(sc.nextInt()==1) {
			g.BFS(0);
		}
		else{
			g.DFS(0);
		}
		sc.close();
	}
}
