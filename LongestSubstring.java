
public class LongestSubstring {
	public static void longestNonRepeatingSubstr(String s)
	{
		int start = 0, end = 0, maxLen = 0;
		int[] index = new int[256];
		int[] exists = new int[256];
		while(end < s.length()){
			if(exists[(int) s.charAt(end)] == 0){
				exists[(int) s.charAt(end)]++;
				index[(int) s.charAt(end)] = end;
				maxLen = Math.max(maxLen, end - start + 1);
				end++;}
			else{
				while(end > start){
					exists[(int) s.charAt(start)] = 0;
					start++;
				}
				start = index[(int) s.charAt(end)] + 1;
				index[(int) s.charAt(end)] = end;
				end = start;
			}
		}
		System.out.println("The longest sub string with non repeating characters = "+maxLen);
}
	public static void main(String args[]){
		longestNonRepeatingSubstr("geeksforgeeksytplmnbqwzxcxcytr");
	}
}
