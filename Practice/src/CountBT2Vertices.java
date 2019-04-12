import java.util.*;

public class CountBT2Vertices {
	LinkedList<Integer> []adj;
	int count(int u,int dest,boolean visited[],int count) {
		visited[u]=true;
		if(u==dest) {
			count++;
		}
		else {
			Iterator<Integer> itr =adj[u].iterator();
			while(itr.hasNext()) {
				int v=itr.next();
				if(visited[v]==false) {
					count=count(v,dest,visited,count);
				}
			}
		}
		visited[u]=false;
		return count;
	}
}
