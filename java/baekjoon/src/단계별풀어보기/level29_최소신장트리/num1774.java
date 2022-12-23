package 단계별풀어보기.level29_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class num1774 {
	static int N, M, cnt = 0;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static int[] parent;
	static Node[] arr;
	static double minLen = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		N = stoi(NM[0]);
		M = stoi(NM[1]);
		Node[] arr = new Node[N+1];
		parent = new int[N+1];
		
		for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
		
		for(int i=1; i<=N; i++) {
			String[] XY = br.readLine().split(" ");
			arr[i] = new Node(stoi(XY[0]), stoi(XY[1]));
		}
		
		for(int i=0; i<M; i++) {
			String[] se = br.readLine().split(" ");
			int s = stoi(se[0]);
			int e = stoi(se[1]);
			union(s, e);
		}
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				pq.add(new Edge(i, j, getDistance(arr[i].x, arr[j].x, arr[i].y, arr[j].y)));
			}
		}
		
	    for(int i=0; i<pq.size(); i++) {
	    	Edge temp = pq.poll();
	    	
	    	int a = temp.s;
	    	int b = temp.e;
	    	if(!union(a, b))
	    		continue;
	    	minLen+= temp.w;
	    }
	    System.out.println(String.format("%.2f", minLen));
		
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
	
	public static double getDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
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
	
	static class Node{
		double x, y;
		Node(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
}
