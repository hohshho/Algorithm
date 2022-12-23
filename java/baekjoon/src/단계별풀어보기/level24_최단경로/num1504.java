package 단계별풀어보기.level24_최단경로;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class num1504 {
	static int N,E,v1,v2,result;
	static ArrayList<ArrayList<Edge>> Vertex;
	static int[] distance;
	static boolean[] visited;
	static int INF = 200000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NE = br.readLine().split(" ");
		N = stoi(NE[0]);
		E = stoi(NE[1]);
		distance = new int[N+1];
		visited = new boolean[N+1];
		Vertex = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			Vertex.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			String[] abc = br.readLine().split(" ");
			int a = stoi(abc[0]);
			int b = stoi(abc[1]);
			int c = stoi(abc[2]);
			
			Vertex.get(a).add(new Edge(b,c));
			Vertex.get(b).add(new Edge(a,c));
		}
		String[] v1v2 = br.readLine().split(" ");
		v1 = stoi(v1v2[0]);
		v2 = stoi(v1v2[1]);
		
		result = solve();
		System.out.println(result);
	}

	public static int solve() {
		int case1=0, case2=0;
		
		case1 = dijkstra(1,v1) + dijkstra(v1,v2) + dijkstra(v2,N);
		case2 = dijkstra(1,v2) + dijkstra(v2,v1) + dijkstra(v1,N);

		return (case1 >= INF && case2 >= INF) ? -1 : Math.min(case1, case2);
	}
	
	public static int dijkstra(int start, int end) {
		Arrays.fill(distance, INF);
		Arrays.fill(visited, false);
		
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		queue.add(new Edge(start,0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Edge now = queue.remove();
			int nowNode = now.e;
			if(!visited[nowNode]) {
				visited[nowNode] = true;
				
				for(Edge next : Vertex.get(nowNode)) {
					if(!visited[next.e] && distance[next.e] > distance[nowNode] + next.weight) {
						distance[next.e] = distance[nowNode] + next.weight;
						queue.add(new Edge(next.e, distance[next.e]));
					}
				}
			}
		}
		return distance[end];
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
	
	static class Edge implements Comparable<Edge>{
		int e, weight;
		Edge(int e, int weight){
			this.e = e;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o){
			return weight - o.weight;
		}
	}
}

