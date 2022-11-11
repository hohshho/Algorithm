package level24_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num9370 {
	static int T, n, m, t, s, g, h, INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Edge>> Vertex;
	static int[] dist;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static boolean availableValue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = stoi(br.readLine());
		
		for(int k = 0; k < T; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Vertex = new ArrayList<ArrayList<Edge>>();
			
			n = stoi(st.nextToken());
			m = stoi(st.nextToken());
			t = stoi(st.nextToken());
		
			dist = new int[n+1];
			visited = new boolean[n+1];
		
			for(int i=0; i<=n; i++) {
				Vertex.add(new ArrayList<Edge>());
				dist[i] = INF;
			}
		
			st = new StringTokenizer(br.readLine());
		
			s = stoi(st.nextToken());
			g = stoi(st.nextToken());
			h = stoi(st.nextToken());
		
			for(int i=1; i<=m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = stoi(st.nextToken());
				int b = stoi(st.nextToken());
				int w = stoi(st.nextToken());
				
				Vertex.get(a).add(new Edge(b, w));
				Vertex.get(b).add(new Edge(a, w));
			}
			int[] dest = new int[t];
			for(int j = 0; j <t; j++) {
				dest[j] = stoi(br.readLine());
			}
			
			PriorityQueue<Integer> result = new PriorityQueue<>();
			for (int point : dest) {
				long res1 = dikstra(s, g) + dikstra(g ,h) + dikstra(h, point);
				long res2 = dikstra(s, h) + dikstra(h, g) + dikstra(g, point);
				long res = dikstra(s, point);
			
				if(Math.min(res1, res2) == res) {
					result.offer(point);
				}
			}
			while(!result.isEmpty()) {
				sb.append(result.poll() + " " );
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int dikstra(int start, int end) {
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		q.add(new Edge(start, 0));
		Arrays.fill(visited, false);
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Edge now = q.remove();
			if(!visited[now.e]) {
				visited[now.e] = true;
				for(Edge next : Vertex.get(now.e)) {
					if(!visited[next.e] && dist[next.e] >= dist[now.e] + next.weight) {
						dist[next.e] = dist[now.e] + next.weight;
						q.add(new Edge(next.e, dist[next.e]));
					}
				}
			}
		}
		return dist[end];
		
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
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
		
	}
}
