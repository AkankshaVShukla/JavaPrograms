import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TripleStep {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = 1;//in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = 4;//in.nextInt();
            System.out.println(countWays(n));
        }
    }
    static int countWays(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        return (countWays(n-1)+ countWays(n-2)+countWays(n-3));
    }
}
