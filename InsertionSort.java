package sorting;

public class InsertionSort {

	public static void main(String args[]){
		int a[] = {6,5,2,3,8,1};
		for(int i=1; i<a.length;i++){
			int x = a[i];
			int j= i-1;
			while(j>=0 && x<a[j]){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = x;
		}
		//display
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}	 
}
