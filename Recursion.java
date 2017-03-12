
public class Recursion {

	public static void main(String args[]){
		Q(3);
	}
	public static int Q(int i){
		if(i==1)return 33;
		else return Q(i-1) +Q(i-1) +Q(i-1) + Q(i-1);
	}
}
