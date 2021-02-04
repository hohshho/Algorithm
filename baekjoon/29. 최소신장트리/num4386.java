package package29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num4386 {
	static int N, cnt=0;
	static double result = 0;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static Vertex[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		
		parent = new int[N+1];
		v = new Vertex[N+1];
		for(int i=1; i<=N+1; i++) {
            parent[i] = i;
        }
		
	    for(int i=1; i<=N; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
	    	v[i] = new Vertex(stod(st.nextToken()), stod(st.nextToken()));
	    }
	    
	    for(int i=1; i<=N; i++) {
	    	for(int j=i+1; j<=N; j++) {
	    		pq.add(new Edge(i, j, getDistance(v[i].x, v[j].x, v[i].y, v[j].y)));
	    	}
	    }
	    
	    for(int i=0; i<pq.size(); i++) {
	    	Edge temp = pq.poll();
	    	
	    	int a = temp.s;
	    	int b = temp.e;
	    	if(!union(a, b))
	    		continue;
	    	result+= temp.w;
	    	cnt++;
	    	if(cnt == N-1)
	    		break;
	    }
	    System.out.println(String.format("%.2f", result));
	}
	
	static class Vertex{
		double x, y;
		Vertex(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int s, e;
		double w;
		Edge(int s, int e, double w){
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return o.w >= this.w ? -1: 1;
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
	
	public static double getDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
	
	public static double stod(String string) {
		return Double.parseDouble(string);
	}
	
}

