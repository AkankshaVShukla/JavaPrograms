public class MatrixDP {
	private static int m[][];
	private static int s[][];
	private static int countMultiplications = 0;
	private static int countRecursions = 0;
	
	public static void main(String args[]){
		int p[] = {5, 2, 4, 7, 3, 9, 7, 8, 6, 3, 7, 5, 5};
		//int p[] = {20, 10, 30, 40, 20};
		//int p[]={30,35,15,5,10,20,25};
		long timeStart = System.nanoTime();
		matrixChainOrder(p);
		long timeEnd = System.nanoTime();
		System.out.print("Optimal parenthesization: ");
		printParenthesization(s, 0, p.length-2);
		System.out.println();
		System.out.println("Number of Optimal multiplications: " + m[0][p.length-2]);
		System.out.println("Running time: " +(timeEnd - timeStart));
		System.out.println("Number of Recursive calls: " + countRecursions);
		System.out.println("Number of Scalar Multiplications: " + countMultiplications);
	}
	
	public static void matrixChainOrder(int p[]){
		int n = p.length - 1;
		m = new int[p.length-1][p.length-1];
		s = new int[p.length-1][p.length-1];		
		for(int i = 0; i < n; i++){
			m[i][i] = 0;
		}
		int j=0,q=0;
		for(int l=2; l<=n; l++){
			for(int i=0; i < n-l+1; i++){
				j = i + l - 1;
				m[i][j]= Integer.MAX_VALUE;
				for(int k=i; k<=j-1; k++){
					q = m[i][k] + m[k+1][j] + p[i]*p[k+1]*p[j+1];
					countMultiplications = countMultiplications + 2;
					if(q<m[i][j]){
						m[i][j] = q;
						s[i][j] = k;
					}
				} 
			}
		}
		/*System.out.println("matrix is " + m);
		for(int i = 0; i<m.length ; i++){
			for (int k =0; k< m[i].length; k++){
				System.out.print(m[i][k] + "     ");
			}
			System.out.println();
		}*/
		/*System.out.println("________________________________________");
		for(int x = 0; x<m.length; x++){
			for(int y=0; y<m[x].length; y++){
				System.out.print("\t"+s[x][y]);
			}
			System.out.println();
		}*/
	}

	public static void printParenthesization(int s[][], int i, int j){
		if(i == j){
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
Running time: 12373
Number of Recursive calls: 0
Number of Scalar Multiplications: 20

Example 2:
p[]={5, 2, 4, 7, 3, 9, 7, 8, 6, 3, 7, 5, 5};
Optimal parenthesization: (A1((((((((((A2A3)A4)A5)A6)A7)A8)A9)A10)A11)A12))
Number of Optimal multiplications: 734
Running time: 13626897
Number of Recursive calls: 0
Number of Scalar Multiplications: 572

Example 3:
p[]={30,35,15,5,10,20,25};
Optimal parenthesization: ((A1(A2A3))((A4A5)A6))
Number of Optimal multiplications: 15125
Running time: 15787
Number of Recursive calls: 0
Number of Scalar Multiplications: 70

*/