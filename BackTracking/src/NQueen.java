import java.util.Arrays;

public class NQueen {
	int size;
	int[][] board;
	
	public boolean isSafe(int x, int y, int[][] safe) {
		if(x>=0 && x<8 && y>=0 && y<8 && safe[x][y]==0) {
			return true;
		}
		return false;
	}
	
	public void fillSafe(int x,int y,int[][] safe) {
		//all vertical
		for(int i=0 ; i<8 ; i++) {
			if(i!=x)
			safe[i][y]++ ; 
		}
		//all horiziontal
		for(int i=0 ; i<8 ; i++) {
			if(i!=y)
			safe[x][i]++ ; 
		}
		//all diagonals
		 
		for(int i=x-1,j=y-1 ; i>=0 && j>=0 ; i--,j-- ) {		// till upper left corner
			safe[i][j]++;
		}
		for(int i=x+1,j=y+1 ; i<8 && j<8 ; i++,j++ ) {			// till lower right corner
			safe[i][j]++;
		}
		for(int i=x+1,j=y-1 ; i<8 && j>=0 ; i++,j-- ) {			// till lower left corner
			safe[i][j]++;
		}
		for(int i=x-1,j=y+1 ; i>=0 && j<8 ; i--,j++ ) {			// till upper right corner
			safe[i][j]++;
		}
		//print(safe);
	}
	
	public void undoSafe(int x,int y,int[][] safe) {
		//all vertical
				for(int i=0 ; i<8 ; i++) {
					if(i!=x)
					safe[i][y]-- ; 
				}
				//all horiziontal
				for(int i=0 ; i<8 ; i++) {
					if(i!=y)
					safe[x][i]-- ; 
				}
				//all diagonals
				 
				for(int i=x-1,j=y-1 ; i>=0 && j>=0 ; i--,j-- ) {		// till upper left corner
					safe[i][j]--;
				}
				for(int i=x+1,j=y+1 ; i<8 && j<8 ; i++,j++ ) {			// till lower right corner
					safe[i][j]--;
				}
				for(int i=x+1,j=y-1 ; i<8 && j>=0 ; i++,j-- ) {			// till lower left corner
					safe[i][j]--;
				}
				for(int i=x-1,j=y+1 ; i>=0 && j<8 ; i--,j++ ) {			// till upper right corner
					safe[i][j]--;
				}
				//print(safe);
	}
	
	public void print(int[][] arr) {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public int[][] nQueen(){
		int[][] result = new int[8][8];
		int count =0;
			boolean isOk = false;
			for(int j=0;j<8;j++) {
				result = new int[8][8];
				int[][] safe = new int[8][8];
				for(int i=0;i<8;i++) {
					Arrays.fill(safe[i], 0);
				}
				isOk = nQueenUtil(0,j,safe,result,1);
				if(isOk) {
					count++;
					print(result);
					//break;
				}
			}
			System.out.println(count);
		return result;
	}
	
	public boolean nQueenUtil(int row, int column, int[][] safe, int[][] result, int count) {
		boolean childSafe = false;
		int i ;
		for(i=column ; i<8 ; i++) {
			if( isSafe(row,i,safe) ) {
				result[row][i] = count;
				safe[row][i]++;
				fillSafe(row,i,safe);
				childSafe = nQueenUtil(row+1, 0, safe, result, count+1);
				if(childSafe==false) {
					result[row][i] = 0;
					safe[row][i]--;
					undoSafe(row, i, safe);
				}
				else {
					break;
				}
			}
		}

		if( row!=8 && i==8 && childSafe==false ) {
			return false;
		}
		return true;
	}
	
	public static void main(String args[]) {
		NQueen nqueen = new NQueen();
		int[][] result = nqueen.nQueen();
		/*for(int i=0 ; i<8 ; i++) {
			for(int j=0 ; j<8 ; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}*/
		
	}
}
