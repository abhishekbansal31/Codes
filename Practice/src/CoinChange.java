import java.util.*;

public class CoinChange {
	/*
	 * 
	 * static long lcm(int[] s) {
      long lcm_of_array_elements = 1; 
	        int divisor = 2; 
	          
	        while (true) { 
	            int counter = 0; 
	            boolean divisible = false; 
	              
	            for (int i = 0; i < s.length; i++) { 
	  
	                // lcm_of_array_elements (n1, n2, ... 0) = 0. 
	                // For negative number we convert into 
	                // positive and calculate lcm_of_array_elements. 
	  
	                if (s[i] == 0) { 
	                    return 0; 
	                } 
	                else if (s[i] < 0) { 
	                    s[i] = s[i] * (-1); 
	                } 
	                if (s[i] == 1) { 
	                    counter++; 
	                } 
	  
	                // Divide s by devisor if complete 
	                // division i.e. without remainder then replace 
	                // number with quotient; used for find next factor 
	                if (s[i] % divisor == 0) { 
	                    divisible = true; 
	                    s[i] = s[i] / divisor; 
	                } 
	            } 
	  
	            // If divisor able to completely divide any number 
	            // from array multiply with lcm_of_array_elements 
	            // and store into lcm_of_array_elements and continue 
	            // to same divisor for next factor finding. 
	            // else increment divisor 
	            if (divisible) { 
	                lcm_of_array_elements = lcm_of_array_elements * divisor; 
	            } 
	            else { 
	                divisor++; 
	            } 
	  
	            // Check if all s is 1 indicate  
	            // we found all factors and terminate while loop. 
	            if (counter == s.length) { 
	                return lcm_of_array_elements; 
	            } 
	        } 
	    } */
	static int a[];
	static int change(int s[],int n) {
		if(n<0)
			return 0;
		else if(n==0) {
			return 1;
		}
		else if(a[n]!=0) {
			return a[n];
		}
		else {
			for(int i=0;i<s.length;i++) {
				a[n]=a[n]+change(s,n-s[i]);
			}
			return a[n];
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int s[]=new int[m];
		for(int i=0;i<m;i++) {
			s[i]=sc.nextInt();
		}
		//long l=lcm(s);
		a=new int[n+1];
		change(s,n);
		for(int i=0;i<=n;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println(a[n]);
	}
}
