public class NumberPalin {
    public boolean isPalindrome(int x) {
        String str = (new Integer(x)).toString();
        char[] a = str.toCharArray();
        int j = a.length-1;
        for(int i =0;i<a.length;i++){
            if(a[i] != a[j]){
                return false;
            } 
            j--;
        }
        return true;
        
    }
}