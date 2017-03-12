import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Median {

    public static float printMedian(int[] a){
        Arrays.sort(a);
        int x = a.length/2;
        int y = (a.length - 1)/2;
        
        System.out.print(x + "* " + y);
        if(a.length % 2 == 0)
            return ((a[y]) + a[x])/2;
         else
            return a[x];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            System.out.println(printMedian(a));
        }
        
    }
}
