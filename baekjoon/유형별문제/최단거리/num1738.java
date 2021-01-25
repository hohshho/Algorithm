package MinPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num1738 {
	static int N, M, INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Edge>> Vertex;
	static int[] preVertex;
	static boolean minusCycle = false;
	static long[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		
		N = stoi(NM[0]);
		M = stoi(NM[1]);
		
		Vertex = new ArrayList<ArrayList<Edge>>();
		dist = new long[N];
		preVertex = new int[N];
		for(int i=0; i<N; i++) {
			Vertex.add(new ArrayList<Edge>());
			dist[i] = INF;
		}
		
		for(int i=0; i<M; i++) {
			String[] uvw = br.readLine().split(" ");
			int u = stoi(uvw[0])-1;
			int v = stoi(uvw[1])-1;
			int w = stoi(uvw[2]);
			
			Vertex.get(u).add(new Edge(v, w));
		}
		
		bellmanFord();
		
		if(minusCycle || dist[N-1]!=INF)
			sb.append("-1");
		else{
			for(int point : preVertex) {
				if(point!=0)
					sb.append(point+1 + " ");
			}
		}
		System.out.println(sb);
		
	}
	
	public static void bellmanFord() {
		dist[0] = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(Edge edge : Vertex.get(j)) {
					int next = edge.e, weight = edge.w;
					if(dist[j]!=INF && dist[next] > dist[j] + weight) {
						dist[next] = dist[j] + weight;
						preVertex[next] = j;
						if(i == N-1)
							minusCycle = true;
					}
				}
			}
		}
		for(long value : dist) {
			System.out.println(value);
		}
	}
	
	static class Edge{
		int e, w;
		Edge(int e, int w){
			this.e = e;
			this.w = w;
		}
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
