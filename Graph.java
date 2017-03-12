package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int vertices;
	private LinkedList<Integer> adj[];
	private List<Integer> vertexList = new ArrayList<Integer>();
	Graph(int vertices){
		this.vertices = vertices;
		this.adj = new LinkedList[vertices];
		for(int i=0; i<vertices; i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v1, int v2){
		if(!vertexList.contains(v1)){
			vertexList.add(v1);
		}
		if(!vertexList.contains(v2)){
			vertexList.add(v2);
		}
		adj[v1].add(v2);
	}
	
	public List<Integer> getVertices(){
		return vertexList;
	}
	
	public LinkedList<Integer> getAdjacentVertices(int v){
		return adj[v];
	}
}
