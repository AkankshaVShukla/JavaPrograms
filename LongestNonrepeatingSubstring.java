
public class LongestNonrepeatingSubstring {
	public static void main(String args[]){
		longestNonRepeatingSubstr("geeksforgeeks");
	}

	private static void longestNonRepeatingSubstr(String string) {
		// TODO Auto-generated method stub
		int maxLength[] = new int[string.length()];
		int start = 0;
		boolean repeatable = false;
		for(int i = 0; i<string.length(); i++){
			maxLength[i] = 0;
		}
		for (int i = 1; i<string.length(); i++){
			for(int j = i-1; j>= start; j--){
				if(string.charAt(j)== string.charAt(i)){
					repeatable = true;
					break;
				}
				
			}
			if(repeatable){
				maxLength[i] = 0;
				start = i;
			}else{
				maxLength[i] = maxLength[i-1] + 1;					
			}
			repeatable = false;
			
		}
		for(int i=0;i<maxLength.length;i++){
			System.out.println(maxLength[i]);
		}
		int max = 0;
		for(int i=0;i<maxLength.length;i++){
			if(max < maxLength[i]){
				max = maxLength[i]; 
			}
		}
		
		System.out.println("MAx length is " + (max +1));
	}
}
