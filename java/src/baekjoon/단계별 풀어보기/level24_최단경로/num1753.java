package package24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class num1753 {
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputVE = br.readLine().split(" ");
		int V = stoi(inputVE[0]);
		int E = stoi(inputVE[1]);
		int K = stoi(br.readLine())-1;
		
		List<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) 
        	graph[i] = new ArrayList<>();
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; i++) {
			distance[i] = INF; 
		}
		
		for(int i=0; i<E; i++) {
			String[] uvw = br.readLine().split(" ");
			int u = stoi(uvw[0])-1;
			int v = stoi(uvw[1])-1;
			int w = stoi(uvw[2]);
			graph[u].add(new Edge(v,w));
		}
		dijkstra(graph, visited, distance, V, E, K);
		
		for(int value : distance) {
			if(INF == value)
				System.out.println("INF");
			else
				System.out.println(value);
		}
	}
	
	public static void dijkstra(List<Edge>[] graph, boolean[] visited, int[] distance, int V, int E, int K) {
		distance[K] = 0;
		for(int i=0; i<V; i++) {
			int minIndex = getSmallestNodeNotVisited(visited, distance, V);
            for (Edge next : graph[minIndex]) {
                if(!visited[next.v] && distance[next.v] > distance[minIndex] + next.weight) {
                	distance[next.v] = distance[minIndex] + next.weight;
                }
            }

			visited[minIndex] = true;

		}
		
	}
	
	public static int getSmallestNodeNotVisited(boolean[] visited, int[] distance, int V) {
		int min = INF;
		int minIndex = 0;
		for(int i=0; i<V; i++) {
			if(visited[i] == false && distance[i]<min) {
				min = distance[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}

class Edge {
    int v, weight;

    public Edge(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
    
}
