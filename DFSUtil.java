package graphs;

public class DFSUtil {
	static boolean[] visited;
	static Graph g;
	static int[] parent; 

	public static void dfs(){
		visited = new boolean[g.getVertices().size()];
		parent = new int[g.getVertices().size()];
		for(int v : g.getVertices()){
			visited[v] = false;
		}
		for(int v : g.getVertices()){
			if(visited[v] == false){
				dfsVisit(v);
			}
		}
	}

	private static void dfsVisit(int v){
		for(int u :g.getAdjacentVertices(v)){
			if(visited[u] == false){
				parent[u] = v;
				dfsVisit(u);
			}
		}
		System.out.println(v);
		visited[v]= true;
	}
	public static void main(String args[]){
		g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		dfs();
	}
}
