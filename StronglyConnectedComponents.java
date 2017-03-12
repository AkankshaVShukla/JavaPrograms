package graphs;

import java.util.Stack;

public class StronglyConnectedComponents {
	public static void main(String args[]){
		Graph g = new Graph(5);
		g.addVertex("0");
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		g.addEdge("1", "0");
		g.addEdge("0", "2");
		g.addEdge("2", "1");
		g.addEdge("0", "3");
		g.addEdge("3", "4");
		g.printSCC();
	}
}

class Vertex{
	String label;
	boolean visited;
	Vertex(String label){
		this.label = label;
		visited = false;
	}
}

class Graph{
	private Vertex vertexList[];
	private int adjMatrix[][];
	private int vertexCount;
	Stack s = new Stack();
	static boolean reverseGraph = false;
	int color[];
	Graph(int size){
		adjMatrix = new int[size][size];
		vertexCount = 0;
		color = new int[size];
		vertexList = new Vertex[size];
		for(int i=0; i<size; i++){
			for (int j = 0; j < size; j++) {
				adjMatrix[i][j] = 0;
			}
		}
	}
	public void addVertex(String label){
		vertexList[vertexCount++] = new Vertex(label);
	}

	public void addEdge(String start, String end){
		int s = findIndex(start);
		int e = findIndex(end);
		//System.out.println(s + "test" + e);
		if(s != -1 && e != -1) {
			adjMatrix[s][e] = 1;
			//adjMatrix[e][s] = 1;
		}
	}
	private int findIndex(String start) {
		// TODO Auto-generated method stub
		for (int i = 0; i < vertexList.length; i++) {
			if(start.equals(vertexList[i].label)){
				return i;
			}
		}
		return -1;
	}
	public void displayGraph(){		
		for (int i = 0; i < vertexList.length; i++) {
			for (int j = 0; j < vertexList.length; j++) {
				System.out.println(adjMatrix[i][j]);
			}
			System.out.println();
		}
	}

	public void dfs(){
		for (int i=0; i< vertexList.length; i++) {
			color[i] = 0;
		}
		for (int i=0; i< vertexList.length; i++) {
			if(color[i] == 0){
				dfsVisit(adjMatrix, i);
			}
		}
		System.out.println();
	}
	private void dfsVisit(int [][]adjMatrix, int vertexNumber) {
		// TODO Auto-generated method stub
		color[vertexNumber] = 1;

		//System.out.print(vertexList[vertexNumber].label);
		for (int i=0; i< vertexList.length; i++) {
			if(adjMatrix[vertexNumber][i] == 1){
				if(color[i]== 0){
					dfsVisit(adjMatrix, i);
				}

			}
		}
		System.out.print(vertexList[vertexNumber].label);
		//if(reverseGraph == false){
			s.push(vertexNumber);
	//	}
		color[vertexNumber] = 2;
	}
	private void dfsVisitReverse(int [][]adjMatrix, int vertexNumber, int[] visited) {
		// TODO Auto-generated method stub
		visited[vertexNumber] = 1;

		System.out.print(vertexList[vertexNumber].label);
		for (int i=0; i< vertexList.length; i++) {
			if(adjMatrix[vertexNumber][i] == 1){
				if(visited[i]== 0){
					dfsVisitReverse(adjMatrix, i, visited);
				}

			}
		}
		/*//System.out.print(vertexList[vertexNumber].label);
		if(reverseGraph == false){
			s.push(vertexNumber);
		}*/
		visited[vertexNumber] = 1;
	}


	public void printSCC(){
		dfs();
		int[] visited = new int[vertexCount];
		Graph gr = graphTranspose();
		reverseGraph = true;
		for (int i = 0; i < vertexCount; i++) {
			visited[i] = 0;
		}
		while (s.empty() == false)
		{
			int v = (int) s.pop();

			// Print Strongly connected component of the popped vertex
			if (visited[v]== 0)
			{
				gr.dfsVisitReverse(gr.adjMatrix,v, visited);
				System.out.println();
			}
		}
	}
	private Graph graphTranspose() {
		Graph gr = new Graph(vertexCount);
		gr.vertexList = vertexList;
		for (int i = 0; i < vertexCount; i++) {
			for (int j = 0; j < vertexCount; j++) {
				gr.adjMatrix[j][i] = adjMatrix[i][j];
			}
		}
		return gr;
	}
}