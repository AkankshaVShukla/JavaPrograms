import java.util.HashSet;
import java.util.List;


public class PermutationsOfString {
	public static void main(String args[]){
		HashSet<String> set = new HashSet<String>();
		permute("abcc", "", set);
		for(String s: set){
			System.out.println(s);
		}
	}
	
	private static void permute(String word, String perm, HashSet<String> set){
		if(word.length()==0){
			
			set.add(word+perm);
		}
		for(int i=0;i <word.length();i++){
			permute(word.substring(0, i) + word.substring(i+1, word.length()), perm+word.charAt(i), set);
		}
		
	}
}
