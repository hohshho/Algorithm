package 유형별문제.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num1516 {
	static int N, M;
	static int[] indegree, result, weight;
	static Queue<Integer> q = new LinkedList<Integer>();
	static ArrayList<Edge>[] edge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		
		indegree = new int[N+1];
		result = new int[N+1];
		edge = new ArrayList[N+1];
		weight = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			edge[i] = new ArrayList<Edge>();
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = stoi(st.nextToken());
			while(true) {
				int prev = stoi(st.nextToken());
				if(prev == -1) break;
				indegree[i]++;
				edge[prev].add(new Edge(prev, i));
			}
			if(indegree[i] == 0){
	            result[i] = weight[i];
	            q.add(i);
	        }
		}
		
		for(int i=1; i<=N; i++) {
			if(q.isEmpty()) {
				return;
			}
			int now = q.poll();
			
			for(Edge next : edge[now]) {
				result[next.e] = Math.max(result[next.e], result[now]+weight[next.e]);
				indegree[next.e]--;
				if(indegree[next.e]==0)
					q.add(next.e);
			}
		}
		
		for(int i=1; i<=N; i++)
			System.out.println(result[i]);
		
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
