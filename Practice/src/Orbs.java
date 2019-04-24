import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Orbs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        for(int k = 0; k < s; k++){
            int n = sc.nextInt();
            int e = sc.nextInt();
            int[] b = new int[e];
            for(int b_i=0; b_i < e; b_i++){
                b[b_i] = sc.nextInt();
            }
            Arrays.sort(b);
            int arr[]=new int[e],p=1,sum=0;
            for(int i=0;i<n;i++) {
            	sum=0;
            	for(int j=0;j<e;j++) {
            		arr[j]=(arr[j]+1)%(b[j]+1);
            		//while(b[j-1]==b[j])
            	}
            	for(int j=0;j<e;j++) {
            		if(arr[j]!=0) {
            			sum++;
            		}
            	}
            	p=(p*sum)%1000000007;
            	
            }
            System.out.println(p);
            // your code goes here
        }
    }
}