import java.util.*;
public class ClosestPallindrome {
	boolean all9(String s) {
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=9)
				return false;
		}
		return true;
	}
	String preFH(String fh,int carry) {
		StringBuffer sb =new StringBuffer(fh);
		if(carry==-1) {
			int i=fh.length()-1;
			while(i>=0 && sb.charAt(i)=='0') {
				sb.replace(i, i+1, "9");
				i--;
			}
			if(i>=0) {
				sb.replace(i, i+1, String.valueOf(sb.charAt(i)-'0'-1));
			}
		}
		else {
			int i=fh.length()-1;
			while(i>=0 && carry!=0) {
				int k=sb.charAt(i)-'0'+carry;
				carry=k/10;
				k=k%10;
				sb.replace(i, i+1, String.valueOf(k));
				i--;
			}
		}
		fh=String.valueOf(sb);
		return fh;
	}
	String closest(String s) {
		if (s.length()==1){
			return s;
		}
		if(all9(s)) {
			StringBuffer sb = new StringBuffer(1+s.replace('9', '0'));
			return String.valueOf(sb.replace(sb.length()-2, sb.length(), "1"));
		}
		String fh=s.substring(0, s.length()/2),sh="";
		StringBuffer sb=new StringBuffer(fh);
		sh=String.valueOf(sb.reverse());
		char mid=' ';
		String s1="",s2="",s3="",temp1="",temp2="";
		if(s.length()%2==1) {
			mid=s.charAt(s.length()/2+1);
			s1=fh+mid+sh;
			if(mid=='0') {
				temp1=preFH(fh,-1);
				temp2=String.valueOf(new StringBuffer(temp1).reverse());
				s2=temp1+"9"+temp2;
			}
			else
				s2=fh+String.valueOf(mid-'0'-1)+sh;
			if(mid=='9') {
				temp1=preFH(fh,1);
				temp2=String.valueOf(new StringBuffer(temp1).reverse());
				s3=temp1+"0"+temp2;
			}
			else
				s3=fh+String.valueOf(mid-'0'+1)+sh;
		}
		else {
			s1=fh+sh;
			if(fh.charAt(fh.length()-1)=='0') {
				temp1=preFH(fh,-1);
			}
			else {
				StringBuffer sb1 = new StringBuffer(fh);
				String str=String.valueOf(fh.charAt(fh.length()-1)-'0'-1);
				temp1=String.valueOf(sb1.replace(fh.length()-1, fh.length(), str));
			}
			temp2=String.valueOf(new StringBuffer(temp1).reverse());
			s2=temp1+temp2;
			if(fh.charAt(fh.length()-1)=='9') {
				temp1=preFH(fh,1);
			}
			else {
				StringBuffer sb1 = new StringBuffer(fh);
				String str=String.valueOf(fh.charAt(fh.length()-1)-'0'+1);
				temp1=String.valueOf(sb1.replace(fh.length()-1, fh.length(), str));
			}
			temp2=String.valueOf(new StringBuffer(temp1).reverse());
			s3=temp1+temp2;
		}
		long n=Long.valueOf(s);
		long n1=Long.valueOf(s1);
		long n2=Long.valueOf(s2);
		long n3=Long.valueOf(s3);

	    long d1=Math.abs(n-n1),d2=Math.abs(n-n2),d3=Math.abs(n-n3);
	    if(d1==0 || d1<d2 && d1<d3) {
	    	s=s1;
	    }
	    else if(d2<d1 && d2<d3){
	        s=s2;
	    }
	    else{
	        s=s3;
	    }
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			long n=sc.nextLong();
			String s=String.valueOf(n);
			ClosestPallindrome c = new ClosestPallindrome();
			System.out.println(c.closest(s));
		}
	}
}
