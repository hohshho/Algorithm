package 단계별풀어보기.level26_동적계획법과최단거리역추적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class num11779 {
	static int N, M, count=2,INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Edge>> Vertex;
	static int[] dist, pre;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		Vertex = new ArrayList<ArrayList<Edge>>();
		dist = new int[N];
		pre = new int[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			Vertex.add(new ArrayList<Edge>());
			dist[i] = INF;
		}
		
		for(int i=0; i<M; i++) {
			String[] uvw = br.readLine().split(" ");
			int u = stoi(uvw[0])-1;
			int v = stoi(uvw[1])-1;
			int w = stoi(uvw[2]);
			Vertex.get(u).add(new Edge(v,w));
		}
		String[] point = br.readLine().split(" ");
		int start = stoi(point[0])-1;
		int end = stoi(point[1])-1;
		dijkstra(start, end);
		
		long answer =dist[end];

		Stack<Integer> st = new Stack<Integer>();
		st.add(end);
		
		while (pre[end] != start) {
			st.add(pre[end]);
			end = pre[end];
			count++;
		}
		
		st.add(start);
		
		System.out.println(answer);
		System.out.println(count);
		while (!st.isEmpty()) {
			System.out.print(st.pop()+1 + " ");
		}
		
	}
	
	public static void dijkstra(int start, int end) {
		dist[start] = 0;
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		q.add(new Edge(start, 0));
		
		while(!q.isEmpty()) {
			Edge now = q.remove();
			if(!visited[now.e]) {
				visited[now.e] = true;
				for(Edge next : Vertex.get(now.e)) {
					if(!visited[next.e] && dist[next.e] >= dist[now.e] + next.w) {
						dist[next.e] = dist[now.e] + next.w;
						q.add(new Edge(next.e, dist[next.e]));
						pre[next.e] = now.e;
					}
				}
			}
		}
		
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
	
	static class Edge implements Comparable<Edge>{
		int e, w;
		Edge(int e, int w){
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o){
			return w - o.w;
		}
	}
}
