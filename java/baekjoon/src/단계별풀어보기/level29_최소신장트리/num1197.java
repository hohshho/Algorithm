package 단계별풀어보기.level29_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num1197 {
	static int V, E, result=0, cnt=0;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] VE = br.readLine().split(" ");
		V = stoi(VE[0]);
		E = stoi(VE[1]);
		
		parent = new int[V+1];
		
		for(int i=0; i<V+1; i++) {
            parent[i] = i;
        }
		
	    for(int i=0; i<E; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	pq.add(new Edge(stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken())));
	    }
		
	    for(int i=0; i<E; i++) {
	    	Edge temp = pq.poll();
	    	
	    	int a = temp.s;
	    	int b = temp.e;
	    	if(!union(a, b))
	    		continue;
	    	result+= temp.w;
	    	cnt++;
	    	if(cnt == V-1)
	    		break;
	    }
	    System.out.println(result);
	}
	
	static class Edge implements Comparable<Edge>{
		int s, e, w;
		Edge(int s, int e, int w){
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
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
	
}
