import java.util.*;
public class LongestRepeatedSubsequence {
	static int[][] lrs(String s) {
		int n=s.length();
		int arr[][]=new int[n+1][n+1];
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(s.charAt(i-1)==s.charAt(j-1) && i!=j) {
					arr[i][j]=arr[i-1][j-1]+1;
				}
				else {
					arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		return arr;
	}
	static String printSeq(String s,int[][] arr) {
		int n=s.length();
		StringBuffer sb = new StringBuffer();
		for(int i=n,j=n;i>0&&j>0;  ) {
			if(arr[i][j]==arr[i-1][j-1]+1) {
				sb.append(s.charAt(i-1));
				i--;
				j--;
			}
			else if(arr[i][j]==arr[i-1][j]) {
				i--;
			}
			else {
				j--;
			}
		}
		return sb.toString();
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s=sc.next();
		/*
		 * int[] count=new int[26];
		for(int i=0;i<s.length();i++) {
			count[s.charAt(i)-97]++;
		}
		int max=count[0];
		for(int i=1;i<26;i++) {
			if(count[i]>max) {
				max=count[i];
			}
		}
		for(int i=0;i<26;i++) {
			if(count[i]==max) {
				System.out.print((char)(i+97));
			}
		}*/
		int arr[][]=lrs(s);
		int n=s.length();
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		String s2=printSeq(s,arr);
		StringBuffer sb = new StringBuffer();
		for(int i=s2.length()-1;i>=0;i--) {
			sb.append(s2.charAt(i));
		}
		System.out.println(sb);
	}
}
