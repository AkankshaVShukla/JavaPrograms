public class MatrixRecursive {
	static int s[][];
	static int countMultiplications=0;
	static int countRecursions=0;
	
	public static void main(String[] args) {
		//int p[] = {20, 10, 30, 40, 20};
		int p[]={5, 2, 4, 7, 3, 9, 7, 8, 6, 3, 7, 5, 5};
		//int p[]={30,35,15,5,10,20,25};
		s= new int[p.length-1][p.length-1];
		long timeStart = System.nanoTime();
		int m = recursiveMatrixChain(p, 0, p.length-2);
		long timeEnd = System.nanoTime();
		System.out.print("Optimal parenthesization: ");
		printParenthesization(s, 0, p.length-2);
		System.out.println();
		System.out.println("Number of Optimal multiplications: " + m);
		System.out.println("Running time: " +(timeEnd - timeStart));
		System.out.println("Number of Recursive calls: " + countRecursions);
		System.out.println("Number of Scalar Multiplications: " + countMultiplications);
	}
	
	public static int recursiveMatrixChain(int p[],int i, int j){
		if(i==j){
			return 0;
		}
		int m=Integer.MAX_VALUE;
		int q=0;
		for(int k=i; k<=j-1; k++){
			q = recursiveMatrixChain(p, i, k) + recursiveMatrixChain(p, k+1, j)+p[i]*p[k+1]*p[j+1];
			countMultiplications = countMultiplications + 2;
			countRecursions = countRecursions + 2;
			if(q<m){
				m=q;
				s[i][j]=k;
			}
		}
		return m;
	}
	
	public static void printParenthesization(int s[][], int i,int j){
		if(i==j){
			System.out.print("A"+(i+1));
		}else{
			System.out.print("(");
			printParenthesization(s, i, s[i][j]);
			printParenthesization(s, s[i][j] + 1, j);
			System.out.print(")");
		}
	}
}

/*Output

Example 1:
p[] = {20, 10, 30, 40, 20}
Optimal parenthesization: (A1((A2A3)A4))
Number of Optimal multiplications: 24000
Running time: 16640
Number of Recursive calls: 26
Number of Scalar Multiplications: 26

Example 2:
p[]={5, 2, 4, 7, 3, 9, 7, 8, 6, 3, 7, 5, 5};
Optimal parenthesization: (A1((((((((((A2A3)A4)A5)A6)A7)A8)A9)A10)A11)A12))
Number of Optimal multiplications: 734
Running time: 3746565
Number of Recursive calls: 177146
Number of Scalar Multiplications: 177146

Example 3:
p[]={30,35,15,5,10,20,25};
Optimal parenthesization: ((A1(A2A3))((A4A5)A6))
Number of Optimal multiplications: 15125
Running time: 37120
Number of Recursive calls: 242
Number of Scalar Multiplications: 242
*/