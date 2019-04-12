//			https://www.geeksforgeeks.org/find-all-triplets-in-a-sorted-array-that-forms-geometric-progression/


public class TripletsAP {


		void triplets1(int[] arr){
			int max=arr[0];
			for(int i=1;i<arr.length;i++){
				if(max<arr[i]){
					max=arr[i];
				}
			}
			int a[]=new int[max+1];
			
			for(int i=0;i<arr.length;i++){
				a[arr[i]]=1;
			}
			for(int i=0;i<arr.length-2;i++){
				for(int j=i+1;j<arr.length-1;j++){
					if(arr[j]%arr[i]==0){
						int r=a[j]/a[i];
						int c = a[j]*r;
						if(c<=max && a[c]==1){
						System.out.println(a[i]+" "+a[j]+" "+c);
						}
					}
				}
			}
		}

		void triplets2(int[] a){
			int n=a.length;
			for(int i=0;i<n-2;i++){
				for(int j=i+1;j<n-1;j++){
					if(a[j]%a[i]==0){
						int r=a[j]/a[i];
						int c=r*a[j];
						for(int k=j+1;k<n;k++){
							if(a[k]==c){
								System.out.println(a[i]+" "+a[j]+" "+c);
							}
						}
					}
				}
			}
		}

		void triplets3(int arr[]){
			int n=arr.length;
			for(int j=1;j<n-1;j++){
				int i=j-1;
				int k=j+1;
				while(i>=0 && k<=n-1){
				
					while(i>=0 && k<n && arr[j]%arr[i]==0 && arr[k]%arr[j]==0 && arr[j]/arr[i]==arr[k]/arr[j]){
						System.out.println(arr[i]+" "+ arr[j]+" "+arr[k]);
						i--;
						k++;
					}
					if(i>=0 && k<n && arr[j]%arr[i]==0 && arr[k]%arr[j]==0){
						if(arr[j]/arr[i]<arr[k]/arr[j])
							i--;
						else
							k++;
					}
					else if(arr[j]%arr[i]==0)
						k++;
					else
						i--;
				}
			}
		}
}
