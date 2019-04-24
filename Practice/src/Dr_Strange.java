/*import java.util.*;
class Graph{
	int n,m;
	HashSet<Integer> hs[];
	Graph(int n,int m){
		this.n=n+1;
		this.m=m;
		hs=new HashSet[n+1];
		for(int i=0;i<=n;i++) {
			hs[i]=new HashSet<Integer>();
		}
	}
}
1
16 16
1 2
2 3
2 4
2 6
3 5
4 5
4 7
5 7
5 9
6 7
7 8
9 10
9 11
10 11
10 12
12 13*/
/*public class Dr_Strange {
    int count(Graph g) {
		int count=0;
		int arr[][]=new int[g.n][2];
		arr[0][1]=-1;
		for(int i=1;i<g.n;i++) {
			arr[i][0]=i;
			arr[i][1]=g.hs[i].size();
		}
		for(int i=0;i<g.n;i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
		int max=0;
		for(int i=1;i<g.n;i++) {
			if(arr[max][1]<arr[i][1])
				max=i;
		}
		while(arr[max][1]>0) {
			arr[max][1]=0;
			System.out.println("Max="+max);
			Iterator<Integer> itr=g.hs[max].iterator();
			while(itr.hasNext()) {
				int x=itr.next();
				arr[x][1]--;
				g.hs[x].remove(max);
				System.out.print(x+" ");
			}
			System.out.println();
			g.hs[max].clear();
			count++;
			max=0;
			for(int i=1;i<g.n;i++) {
				if(arr[max][1]<arr[i][1])
					max=i;
			}
			for(int i=0;i<g.n;i++) {
				System.out.println(arr[i][0]+" "+arr[i][1]);
			}
			System.out.println("Max="+max);
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			Graph g=new Graph(n,m);
			for(int i=0;i<m;i++) {
				int temp1=sc.nextInt();
				int temp2=sc.nextInt();
				g.hs[temp1].add(temp2);
				g.hs[temp2].add(temp1);
			}
			Dr_Strange d=new Dr_Strange();
			System.out.println(d.count(g));
		}
		sc.close();
	}
}*/
/*

import java.util.*;
import java.lang.*;
import java.io.*;

class Graph{
	int n,m;
	Queue<Integer> neighbour[];
	Graph(int n,int m){
		this.n=n+1;
		this.m=m;
		neighbour=new LinkedList[n+1];
		for(int i=0;i<n+1;i++) {
			neighbour[i]=new LinkedList();
		}
	}
}
class GFG {
	Graph g;
	boolean[] BFS(int j) {
		boolean visited[]=new boolean[g.n];
		Queue<Integer> q=new LinkedList<Integer>();
		Queue<Integer> q2[]=g.neighbour.clone();
		visited[j]=true;
		if(!q2[j].isEmpty()){
		    q.add(q2[j].peek());
		}
		while(!q.isEmpty()) {
			int temp=q.peek();
			q.remove();
			visited[temp]=true;
			Iterator<Integer> itr=q2[temp].iterator();
			while(itr.hasNext()) {
				int temp2=itr.next();
				if(visited[temp2]==false) {
					q.add(temp2);
				}
			}
		}
		return visited;
	}
	int count(Scanner sc,int n,int m) {
		int counter=0;
		//Scanner sc=new Scanner(System.in);
		g=new Graph(n,m);
		for(int i=0;i<m;i++) {
			int temp1=sc.nextInt();
			int temp2=sc.nextInt();
			g.neighbour[temp1].add(temp2);
			g.neighbour[temp2].add(temp1);
		}
		boolean visited[];
		for(int j=1;j<=n;j++) {			//=new boolean[n];
			visited=BFS(j);
			for(int i=1;i<=n;i++) {
				if(visited[i]==false) {
				//	System.out.println(j);
					counter++;
					break;
				}
			}
		}
		//sc.close();
		return counter;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			GFG d = new GFG();
			System.out.println(d.count(sc,n,m));
		}
		sc.close();
	}
}
*/
 
import java.util.*;

class Dr_Strange{
	int n,m;
	int time=0;
	LinkedList<Integer> adj[];
	Dr_Strange(int n,int m){
		this.n=n;
		this.m=m;
		adj=new LinkedList[n];
		for(int i=0;i<n;i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}
	void add(int x,int y) {
		adj[x].add(y);
		adj[y].add(x);
	}
	void apUtil(int u,int[] parent,boolean[] visited,int[] vt,int[] low,boolean ap[]) {
		int children=0;
		visited[u]=true;
		time++;
		vt[u]=time;
		low[u]=time;
		Iterator<Integer> itr=adj[u].iterator();
		while(itr.hasNext()) {
			
			int v=itr.next();
			//System.out.println((u+1)+" "+(v+1));
			if(!visited[v]) {
				children++;
				parent[v]=u;
				apUtil(v,parent,visited,vt,low,ap);
				low[u]=Math.min(low[u], low[v]);
				if((parent[u]==-1 && children>1) || (parent[u]!=-1 && low[v]>=vt[u])) {
					ap[u]=true;
				}
			}
			else if(v!=parent[u]) {
				low[u]=Math.min(low[u], vt[v]);
			}
		}
	}
	int count() {
		int count=0;
		boolean visited[] =new boolean[n];
		int parent[]=new int[n];
		int vt[]=new int[n];
		int low[]=new int[n];
		boolean ap[]=new boolean[n];
		for(int i=0;i<n;i++) {
			parent[i]=-1;
			visited[i]=false;
			ap[i]=false;
		}
		for(int i=0;i<n;i++) {
			apUtil(i,parent,visited,vt,low,ap);
		}
		for(int i=0;i<n;i++) {
			if(ap[i]==true) {
				count++;
			}
		}
		return count;
	}
	
	
									void apUtil2(int u,int[] parent,int low[],int vt[],boolean ap[],boolean visited[]) {
										visited[u]=true;
										int children=0;
										time++;
										vt[u]=time;
										low[u]=time;
										while(!adj[u].isEmpty()) {
											int v=adj[u].removeFirst();
											if(!visited[v]) {
												children++;
												parent[v]=u;
												apUtil2(v,parent,low,vt,ap,visited);
												low[u]=Math.min(low[u], low[v]);
												if((parent[u]==-1 && children>1) || (parent[u]!=-1 && low[v]>=vt[u])) {
													ap[u]=true;
												}
								
											}
											else if(v!=parent[u]) {
												low[u]=Math.min(low[u],vt[v]);
											}
										}
									}
									
									
									
									int count2() {
										int count=0;
										boolean[] visited=new boolean[adj.length];
										boolean ap[]=new boolean[adj.length];
										int parent[]=new int[adj.length];
										int low[]=new int[adj.length];
										int vt[]=new int[adj.length];
										for(int i=0;i<adj.length;i++) {
											vt[i]=-1;
											parent[i]=-1;
											visited[i]=false;
											ap[i]=false;
											low[i]=-1;
										}
										for(int i=0;i<n;i++) {
											if(!visited[i])
												apUtil2(i,parent,low,vt,ap,visited);
										}
										return count;
									}
									
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			Dr_Strange d=new Dr_Strange(n,m);
			for(int i=0;i<m;i++) {
				int temp1=sc.nextInt();
				int temp2=sc.nextInt();
				d.add(temp1-1,temp2-1);
			}
			System.out.println(d.count());
		}
		sc.close();
	}
}
