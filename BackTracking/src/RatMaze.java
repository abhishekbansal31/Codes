import java.util.*;
public class RatMaze {
	int size ;
	int[][] maze;
	
	public boolean isSafe(int x, int y) {
		return (x>=0 && x<size && y>=0 && y<size && maze[x][y]==1);
	}
	public void ratMazeSolution() {
		int sol[][] = new int[size][size];
		if(!ratMazeSolutionUtil(0,0, sol)) {
			System.out.println("No solution");
			return ;
		}
		print(sol); 
	}
	
	public boolean ratMazeSolutionUtil(int x, int y, int[][] sol) {
		if(x==size-1 && y==size-1) {
			sol[x][y] = 1;
			return true;
		}
		if(isSafe(x,y)) {
			System.out.println("Safe"+x+" "+y);
			sol[x][y] = 1;
			if(ratMazeSolutionUtil(x+1,y,sol)) {
				return true;
			}
			if(ratMazeSolutionUtil(x,y+1,sol)) {
				return true;
			}
			System.out.println("unSafe"+x+" "+y);
			sol[x][y]=0;
		}
		return false;
	}
	
	public void print(int[][] sol) {
		for(int i=0;i<sol.length;i++) {
			for(int j=0;j<sol[i].length;j++) {
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RatMaze rt = new RatMaze();
		rt.size = sc.nextInt();
		rt.maze = new int[rt.size][rt.size];
		for(int i=0;i<rt.size;i++) {
			for(int j=0;j<rt.size;j++) {
				rt.maze[i][j] = sc.nextInt();
			}
		}
		rt.ratMazeSolution();
		sc.close();
	}
}
