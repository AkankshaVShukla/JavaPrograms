// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class MaximumValidTime {
	public static void main(String args[]){
		System.out.print(solution(1, 8, 3, 2));
	}
    public static String solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
    	List<Integer> input = new ArrayList<Integer>();
         input.add(A);
         input.add(B);
         input.add(C);
         input.add(D);
         StringBuffer sb = new StringBuffer();
         List<Integer> result = new ArrayList<Integer>();
        Collections.sort(input, Collections.reverseOrder());
        if (getMaxValidTime(0, result, input)) {
            for(int i=0; i<result.size();i++){
            	sb.append(result.get(i));
            	if(i==1){
            		sb.append(":");
            	}
            }
            return sb.toString();
        } else {
            return null;
        }        
    }
    
    static boolean getMaxValidTime(int n, List<Integer> output, List<Integer> input) {
        if(n==4)return true;
    	for (int i=0; i<input.size(); i++) {
            Integer val = input.get(i);
            if (isValid(val, n, output)) {
            	output.add(input.get(i));
            	input.remove(i);
            	break;
            }
      }
    	getMaxValidTime(n+1, output, input);
       if(output.size()==4)return true;
       else return false;
    }
     static boolean isValid(Integer value, int n,  List<Integer> result){
        if (result.isEmpty()) {
            return checkH1(result, value);
        } else if (result.size()==1) {
            return checkH2(result, value);
        } else if (result.size()==2) {
            return checkM1(result, value);
        } else if (result.size()==3) {
            return checkM2(result, value);
        }
        return false;
    }
    static boolean checkH1(List<Integer> result, Integer candidate){
        return candidate>=0 && candidate<=2;
    }

    static boolean checkH2(List<Integer> result, Integer candidate){
        Integer d1 = result.get(0);
        Integer d2 = candidate;
        if (d1 == 2 && d2 > 3) {
            return false;
        } else if (d2 < 0 || d2 > 9) {
            return false;
        }
        return true;
    }

    static boolean checkM1(List<Integer> result, Integer candidate){
        Integer d3 = candidate;
        if (d3 < 0 || d3 > 5) {
            return false;
        }
        return true;
    }

    static boolean checkM2(List<Integer> result, Integer candidate){
        Integer d4 = candidate;
        if (d4 < 0 || d4 > 9) {
            return false;
        }
        return true;
    }
 
}