package package29;

import java.io.*;
import java.util.*;

public class num2887 {
	static int N;
	static Vertex[] vertexs;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
		@Override
		public int compare(Edge o1,Edge o2) {
			return (o1.w-o2.w);
		}
	});			
	static int[] parent; 
	
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine()); 
		vertexs = new Vertex[N]; 
		
		StringTokenizer st; 
		for (int i = 0; i < N ; i++) { 
			st = new StringTokenizer(br.readLine().trim(), " ");
			int X = stoi(st.nextToken()); 
			int Y = stoi(st.nextToken());
			int Z = stoi(st.nextToken()); 
			vertexs[i] = new Vertex(X, Y, Z, i);
		} 
		
		Arrays.sort(vertexs,new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				return Integer.compare(o1.x, o2.x);
			}
		});
		for (int i = 1; i <N ; i++) {
			pq.add(new Edge(vertexs[i-1].id, vertexs[i].id, Math.abs(vertexs[i].x-vertexs[i-1].x)));
		}
			
		Arrays.sort(vertexs,new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				return Integer.compare(o1.y, o2.y);
			}
		});
		for (int i = 1; i <N ; i++) {
			pq.add(new Edge(vertexs[i-1].id, vertexs[i].id, Math.abs(vertexs[i].y-vertexs[i-1].y)));
		} 
		
		Arrays.sort(vertexs,new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				return Integer.compare(o1.z, o2.z);
			}
		});
		for (int i = 1; i <N ; i++) {
			pq.add(new Edge(vertexs[i-1].id, vertexs[i].id, Math.abs(vertexs[i].z-vertexs[i-1].z)));
		} 
		
		
		parent = new int[N+1];
		for (int i = 1; i <= N ; i++)
			parent[i] = i; 
		long result=0;
		
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll();
			if(find_parent(tmp.s)!=find_parent(tmp.e)) {
				result +=tmp.w;
				union(tmp.s,tmp.e);
			}
		}
		System.out.println(result);
	}
	
	static class Vertex {
		int x, y, z, id;
		Vertex(int x, int y, int z, int id) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.id = id;
		}
	}
	
	static class Edge {
		int s, e, w;
		Edge(int s, int e, int w) {
			this.s = s; 
			this.e = e; 
			this.w = w;
		} 
	} 
	
	public static int find_parent(int num) {
		if(parent[num] != num)
			return parent[num] = find_parent(parent[num]);
		return parent[num];
	}
	
	public static boolean union(int a, int b) {
		a = find_parent(a);
		b = find_parent(b);
		
		if(a==b) {
			return false;
		}
		else if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
		return true;
	}
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
