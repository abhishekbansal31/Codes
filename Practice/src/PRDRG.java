import java.util.*;
public class PRDRG {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int xcor=1,ycor=(int)Math.pow(2, n);
			if(n>2){
				int x[]=new int[n];
				x[0]=1;
				x[1]=1;
				for(int i=2;i<n;i++) {
					x[i]=2*x[i-2]+x[i-1];
				}
				xcor=x[n-1];
			}
			System.out.print(xcor+" "+ycor+" ");
		}
	}

}
