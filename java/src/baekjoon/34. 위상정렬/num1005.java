package package34;

import java.io.*;
import java.util.*;

public class num1005 {
	static int T, N, K;
    static int[] result, indegree, weight;
	static ArrayList<Edge>[] edge;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = stoi(br.readLine());
		
		while(T-- >0) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			K = stoi(st.nextToken());
			
			result = new int[N+1];
			indegree = new int[N+1];
			weight = new int[N+1];
			edge = new ArrayList[N+1];
			
			for(int i=1; i<=N; i++) {
				edge[i] = new ArrayList<Edge>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				weight[i] = stoi(st.nextToken());
			}
			
			for(int i=1; i<=K; i++) {
				st = new StringTokenizer(br.readLine());
				int s = stoi(st.nextToken());
				int e = stoi(st.nextToken());
				
				edge[s].add(new Edge(s,e));
				indegree[e]++;
			}
	        for(int i=1; i<=N; i++) {
	            result[i] = weight[i];
	 
	            if(indegree[i] == 0)
	                q.offer(i);
	        }
	        
			for(int i=1; i<=N; i++) {
				if(q.isEmpty()) {
					break;
				}
				int now = q.poll();
				for(Edge next : edge[now]) {
					// 요기 중요함 둘 중 큰거 들어감
					result[next.e] = Math.max(result[next.e], result[now]+weight[next.e]);
					indegree[next.e]--;
					if(indegree[next.e]==0)
						q.add(next.e);
				}
			}
			int num = stoi(br.readLine());
			sb.append(result[num]+"\n");
		}
		System.out.println(sb);
		
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