
 // Geek for geeks question

import java.util.Scanner;
public class ClosestPallindrome2 {
	boolean all9(String sb) {
		for(int i=0;i<sb.length();i++) {
			if(sb.charAt(i)!='9')
				return false;
		}
		return true;
	}
	String change(String s,int carry) {
		StringBuffer sb = new StringBuffer(s);
		int i=s.length()-1;
		if(carry==-1) {
			while(i>=0 && s.charAt(i)=='0') {
				sb.replace(i, i+1,"9");
				i--;
			}
			if(i>=0) {
				sb.replace(i, i+1, String.valueOf(s.charAt(i)-'0'-1));
			}
		}
		else {
			while(i>=0 && carry!=0) {
				int k=s.charAt(i)-'0'+carry;
				carry=k/10;
				k=k%10;
				sb.replace(i,i+1,String.valueOf(k));
				i--;
			}
		}
		s=String.valueOf(sb);
		return s;
	}
	String closest(String s) {
		int n=s.length();
		if(n==1) {
			return s;
		}
		if(all9(s)) {
			StringBuffer sb = new StringBuffer(s);
			sb=sb.replace(0, n, "0");
			sb=sb.replace(0, 1, "1");
			sb=sb.append("1");
			s=String.valueOf(sb);
			return s;
		}
		String fh=s.substring(0,n/2);
		String sh=new StringBuffer(fh).reverse().toString();
		String s1="";
		char mid=' ';
		String temp1="";
		String temp2="";
		String s2="";
		String s3="";
		if(n%2==1) {
			mid=s.charAt(n/2);
			s1=fh+mid+sh;
			if(s.equals(s1)) {
				return s;
			}
			if(mid=='0') {
				temp1=change(fh,-1);
				temp2=String.valueOf(new StringBuffer(temp1).reverse());
				s2=temp1+"9"+temp2;
			}
			else {
				s2=fh+String.valueOf(s.charAt(mid)-'0'-1)+sh;
			}
			if(mid=='9') {
				temp1=change(fh,1);
				temp2=String.valueOf(new StringBuffer(temp1).reverse());
				s3=temp1+"0"+temp2;
			}
			else {
				s3=fh+String.valueOf(s.charAt(mid)-'0'+1)+sh;
			}
		}
		else {
			s1=fh+sh;
			if(s.equals(s1)) {
				return s;
			}
			if(s.charAt(n/2-1)=='0') {
				temp1=change(s,-1);
			}
			else {
				StringBuffer temp = new StringBuffer(fh);
				String stemp = String.valueOf(temp.charAt(temp.length()-1)-'0'-1);
				temp1=String.valueOf(temp.replace(temp.length()-1,temp.length(), stemp));
			}
			temp2=String.valueOf(new StringBuffer(temp1).reverse());
			s2=temp1+temp2;
			if(s.charAt(n/2-1)=='9') {
				temp1=change(s,1);
			}
			else {
				StringBuffer temp=new StringBuffer(fh);
				String stemp=String.valueOf(temp.charAt(temp.length()-1)-'0'+1);
				temp1=String.valueOf(temp.replace(temp.length()-1, temp.length(), stemp));
			}
			temp2=String.valueOf(new StringBuffer(temp1).reverse());
			s3=temp1+temp2;
		}
		Long original=Long.valueOf(s);
		Long similar=Long.valueOf(s1);
		Long previous=Long.valueOf(s2);
		Long next=Long.valueOf(s3);
		long d1=Math.abs(original-similar);
		long d2=Math.abs(original-previous);
		long d3=Math.abs(original-next);
		if(d2<=d1 && d3<=d1) {
			s=s2;
		}
		else if(d1<d2 && d1<=d3) {
			s=s1;
		}
		else {
			s=s3;
		}
		return s;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ClosestPallindrome c= new ClosestPallindrome();
		System.out.println(c.closest(sc.next()));
		sc.close();
	}
}
