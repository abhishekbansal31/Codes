import java.util.*;
import java.lang.*;
import java.io.*;


class Arr {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
			 String DELIMITER = " ";
		int i=sc.nextInt();		//testcase
		int j=sc.nextInt();		//size of array
		String arr[][]=new String[j][j];		// j*j matrix	in string 
		String a[]=new String[j];				// j size array	in string
		int brr[][]=new int[j][j];				//j*j matrix in integer format
		int b[]=new int[j];						// j size matrix in integer format
		int k,l;
		long r=0;
		int sum=0;
		sc.nextLine();
		String m=sc.nextLine();
		String m1=sc.nextLine();
		System.out.println(m);
		System.out.println(m1);
		StringTokenizer st = new StringTokenizer(m,DELIMITER);
		StringTokenizer st1 = new StringTokenizer(m1,DELIMITER);
		k=0;
		l=0;
		while(st.hasMoreTokens()){
				for(k=0;k<j;k++){
					for(l=0;l<j;l++)
					{
						arr[k][l]=st.nextToken();
			         }
			      }
				/*								Correct way, upper method will also work	
			arr[k][l]=st.nextToken();
			l++;
			if(l==j) {
				k++;
				l=0;
			}*/
			
		}
		k=0;
		l=0;
		while(st1.hasMoreTokens())
		{
						for(l=0;l<j;l++)            
						{    
							a[l]=st1.nextToken();
						}  
				/*              Correct way, upper method will also work
			a[l]=st1.nextToken();
			l++;
			if(l==j) {
				k++;
				l=0;
			}*/
		}
		/*for(int q=0;q<j;q++) {
			for(int p=0;p<j;p++) {
				System.out.print(arr[q][p]);
			}
			System.out.println();
		}*/
		for (k=0;k<j;k++)
		{
			for(l=0;l<j;l++)
			{
				if(arr[k][l]==null) {
					brr[k][l]=0;
					continue;
				}
				brr[k][l]=Integer.parseInt(arr[k][l]);		// Integer.valueOf(arr[k][l]);	can also be used here
				System.out.println(brr[k][l]);
				if(k==l)
				{
					sum=sum+brr[k][l];
				}
			}
		}
		for(l=0;l<j;l++)
		{
			if(a[l]==null) {
				b[l]=0;
				continue;
			}
			b[l]=Integer.parseInt(a[l]);		// Integer.valueOf(a[l]);		can also be used here
			System.out.println(b[l]);
		}
		r=b[0];
		for(l=1;l<j;l++)
		{
		    if(r<b[l])
		    {
		        r=b[l];
		    }
		}
		System.out .print(+sum +" " +r);
}
}

//java.lang.numberformatexception