package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num1647 {
	static int N, M, result=0, cnt=0;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
	
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = stoi(st.nextToken()), e = stoi(st.nextToken()), w = stoi(st.nextToken());
			pq.add(new Edge(s,e,w));
		}
		
		while(!pq.isEmpty()) {
			Edge temp = pq.poll();
			
			int a = temp.s;
			int b = temp.e;
			if(!union(a, b))
				continue;
			result += temp.w;
			cnt++;
			if(cnt == N-2)
				break;
		}
		System.out.println(result);
	}
	
	static class Edge implements Comparable<Edge> {
		int s, e, w;
		Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		

		@Override
		public int compareTo(Edge o) {
			return o.w >= this.w ? -1 : 1;
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
		
		if(a==b)
			return false;
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
		return true;
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
