package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num2623 {
	static int N, M;
	static int[] indegree;
	static Queue<Integer> q = new LinkedList<Integer>();
	static ArrayList<Edge>[] edge;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		
		indegree = new int[N+1];
		result = new int[N+1];
		edge = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			edge[i] = new ArrayList<Edge>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int testCase = stoi(st.nextToken());
			if(testCase==0) continue;
			
			int prev = stoi(st.nextToken());
			for(int j=1; j<testCase; j++) {
				int now = stoi(st.nextToken());
				indegree[now]++;
				edge[prev].add(new Edge(prev, now));
				prev = now;
			}
		}
		
		for(int i=1; i<=N; i++)
			if(indegree[i]==0) q.add(i);
		
		for(int i=0; i<N; i++) {
			if(q.isEmpty()) {
				System.out.println("0");
				return;
			}
			int now = q.poll();
			result[i] = now;
			for(Edge e : edge[now]) {
				indegree[e.e]--;
				if(indegree[e.e]==0)
					q.add(e.e);
			}
		}
		for(int num : result) {
			System.out.println(num);
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
