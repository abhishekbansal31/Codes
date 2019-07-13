import java.util.*;
public class KnightTour {
		
	public boolean isSafe(int row, int col, int[][] chess) {
		if(row>=0 && row<8 && col>=0 && col<8 && chess[row][col]==-1) {
			return true;
		}
		return false;
	}
	
	public void knightSolution() {
		int chess[][] = new int[8][8];
		int rowArr[] = {2,1,-1,-2,-2,-1,1,2};
		int colArr[] = {1,2,2,1,-1,-2,-2,-1};
		for(int i=0;i<8;i++) {
			Arrays.fill(chess[i], -1);
		}
		chess[0][0]=0;
		if(!knightSolutionUtil(0,0,1,rowArr,colArr,chess)) {
			System.out.println("No Solution");
			return;
		}
		printChess(chess);
	}
	
	public boolean knightSolutionUtil(int row, int col,int step,int[] rowArr, int[] colArr, int[][]chess) {
		
		if(step==64) {
			return true;
		}
		System.out.println(row +" " + col+" " + step);
		
		for(int i = 0 ; i < 8 ; i++) {
			int nextX = row + rowArr[i];
			int nextY = col + colArr[i];
			
			if(isSafe(nextX,nextY,chess)) {
				chess[nextX][nextY] = step ;
				if(knightSolutionUtil(nextX, nextY, (step+1),rowArr,colArr,chess)) {
					return true;
				}
				else {
					chess[nextX][nextY] = -1;
				}
			}
		}	
		
		return false;
		
	}
	public void printChess(int[][] chess) {
		for(int i = 0; i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(chess[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		
		KnightTour k = new KnightTour();
		
		k.knightSolution();
		
	}
}
