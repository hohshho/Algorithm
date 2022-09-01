package package27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num1967 {
	static int N, result = 0, start;
	static ArrayList<ArrayList<Edge>> Vertex;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		Vertex = new ArrayList<ArrayList<Edge>>();
		
		for(int i=0; i<=N; i++) {
			Vertex.add(new ArrayList<Edge>());
		}
		
		for(int i=1; i<N; i++) {
			String[] inputData = br.readLine().split(" ");
			int node1 = stoi(inputData[0]);
			int node2 = stoi(inputData[1]);
			int w = stoi(inputData[2]);
			
			Vertex.get(node1).add(new Edge(node2, w));
			Vertex.get(node2).add(new Edge(node1, w));
		}
		
		visited = new boolean[N+1];
		visited[1] = true;
		dfs(0, 1);
		
		visited = new boolean[N+1];
		visited[start] = true;
		dfs(0, start);
		
		System.out.println(result);
	}
	
	public static int dfs(int len, int now) {
		if (result < len) {
			result = len;
			start = now;
		}
		System.out.println(now);

        for (Edge node: Vertex.get(now)) {
            if(!visited[node.e]){
            	visited[node.e] = true;
            	dfs(len + node.w, node.e);
            }
        }
        return result;
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
	
	static class Edge{
		int e, w;
		Edge(int e,int w){
			this.e = e;
			this.w = w;
		}
	}
}
