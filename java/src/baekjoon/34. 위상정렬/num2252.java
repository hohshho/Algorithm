package package34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class num2252 {
	static int N, M;
	static int[] indegree,result;
	static ArrayList<Edge>[] edge;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		N = stoi(NM[0]);
		M = stoi(NM[1]);
		indegree = new int[N+1];
		result = new int[N+1];
		edge = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			edge[i] = new ArrayList<Edge>();
		}
		
		for(int i=1; i<=M; i++) {
			String[] edgeData = br.readLine().split(" ");
			int s = stoi(edgeData[0]);
			int e = stoi(edgeData[1]);
			
			edge[s].add(new Edge(s, e));
			indegree[e]++;
		}
		
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) q.add(i);
		}
		
		for(int i=1; i<=N; i++) {
			if(q.isEmpty()) {
				return;
			}
			int temp = q.poll();
			result[i] = temp;
			for(Edge e : edge[temp]) {
				indegree[e.e]--;
				if(indegree[e.e] == 0)
					q.add(e.e);
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(result[i] + " ");
		}
		
	}
	
	static class Edge{
		int s, e;
		Edge(int s, int e){
			this.s = s;
			this.e = e;
		}
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
