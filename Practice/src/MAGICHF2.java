import java.util.*;
import java.io.*;
public class MAGICHF2 {
	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int t=Integer.parseInt(st.nextToken());
		while(t-->0) {
			st=new StringTokenizer(br.readLine()," ");
			long n=Long.parseLong(st.nextToken());
			long k=Long.parseLong(st.nextToken());
			double p=1.0;
			if(k==0 || n<3)
				p=1.0/n;
			else if(k>n/4 && n>=8) {
				p=1.0;
			}
			else{

                n = n%4==0 ? n/2 : n/2+1;
                k--;
				while(k>0 && n>=2) {
					//p*=0.5;
					k--;
					if(n%2==0)
						n=n/2;
					else
						n=n/2+1;
				}
				p=(1.0/n);
			}
			System.out.println(p);
		}
	}
}