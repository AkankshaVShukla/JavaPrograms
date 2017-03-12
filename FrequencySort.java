
public class FrequencySort {

	public static void sort(String str){
		int[] frequencyArray = new int[256];
		int maxFreq =0;
		for(char c: str.toCharArray()){
			frequencyArray[c]++;
			maxFreq = Math.max(maxFreq, frequencyArray[c]);
		}
		
		String[] buckets = new String[maxFreq+1];
		String s ="";
		for(int i= 0;i<256;i++){
			if(frequencyArray[i] != 0){
				String k = buckets[frequencyArray[i]];
				if(k == null) k ="";
				buckets[frequencyArray[i]] = k + "" +(char)i;
			}
		}
		for(int i =maxFreq; i>0;i--){
			if(buckets[i]!= null)
				for(int j=0;j<i;j++)
				System.out.print(buckets[i]);
		}		
	}
	
	public static void main(String args[]){
		sort("abbbeeeejkmmmmmmm");
		
	}
}
