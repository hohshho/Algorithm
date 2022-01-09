package MinPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class num1738 {
	static int N, M, INF = 987654321, INF2=-987654321;
	static ArrayList<ArrayList<Edge>> Vertex;
	static int[] preVertex;
	static long[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		N = stoi(NM[0]);
		M = stoi(NM[1]);
		
		dist = new long[N];
		Vertex = new ArrayList<ArrayList<Edge>>();
		preVertex = new int[N];
		for(int i=0; i<N; i++) {
			Vertex.add(new ArrayList<Edge>());
			dist[i] = INF;
			preVertex[i] = -1;
		}
		
		for(int i=0; i<M; i++) {
			String[] uvw = br.readLine().split(" ");
			int u = stoi(uvw[0])-1;
			int v = stoi(uvw[1])-1;
			int w = stoi(uvw[2]);
			Vertex.get(u).add(new Edge(v, -w));
		}
		
		bellmanFord();
		
		printPath();
	}
	
	public static void bellmanFord() {
		dist[0] = 0;
		preVertex[0] = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(Edge edge : Vertex.get(j)) {
					int next = edge.e, weight = edge.w;
					if(dist[j]!=INF && dist[next] > dist[j] + weight) {
						dist[next] = (dist[j] + weight);
						preVertex[next] = j;
						if(i == N-1) {
							dist[next] = INF2;
						}
					}
				}
			}
		}
	}
	
	public static void printPath() {
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		if(dist[N-1] == INF || dist[N-1] == INF2)
			sb.append("-1");
		else{
			for (int i = N-1 ; i != 0; i = preVertex[i]) {
				if(dist[i] == INF2) {
					System.out.println(-1);
					return;
				}else{
					stack.push(i);
				}
				
			}
			stack.push(0);
	        for (int i = stack.size(); i > 0; --i)
	        {
	            sb.append(stack.pop()+1+" ");
	        }
		}
		System.out.println(sb);
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
