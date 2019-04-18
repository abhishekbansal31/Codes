

import java.util.*;

abstract public class Graph {

	int start ;
	int size;	
	LinkedList<Integer> graph[];
	/*
	 * Common functions for directed and undirected graphs
	 */
	abstract void addedge(int vertex1, int vertex2) throws VertexOutOfBoundException;
	
	abstract void bfs();

	abstract void dfs();
	abstract void dfsUtil(boolean[] visited, int vertex);

}