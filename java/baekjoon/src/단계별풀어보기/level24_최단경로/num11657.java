package 단계별풀어보기.level24_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class num11657 {
	static int N, M;
	static ArrayList<ArrayList<Edge>> Vertex;
	static long[] dist;
	static int INF = Integer.MAX_VALUE;
	static boolean minusCycle=false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] inputNM = br.readLine().split(" ");
		N = stoi(inputNM[0]);
		M = stoi(inputNM[1]);
		
		dist = new long[N];
		Vertex = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<N; i++) {
			Vertex.add(new ArrayList<Edge>());
		}
		Arrays.fill(dist, INF);
		
		for(int i=0; i<M; i++) {
			String[] ABC = br.readLine().split(" ");
			int A = stoi(ABC[0])-1;
			int B = stoi(ABC[1])-1;
			int C = stoi(ABC[2]);
			
			Vertex.get(A).add(new Edge(B,C));
		}
		bellman();
		
		if(minusCycle)
			sb.append("-1\n");
		else {
			for(int i=1; i<N; i++) {
				sb.append(dist[i] != INF ? dist[i] : -1);
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}
	public static void bellman() {
		dist[0] = 0;
		
	    for(int i=0; i<N; i++){ // (N-1) + 1번의 루프. 마지막은 음의 싸이클 존재 여부 확인용
	        for(int j=0; j<N; j++){
	            // N-1번의 루프에 걸쳐 각 정점이 i+1개 정점을 거쳐오는 최단경로 갱신
	            for(Edge edge: Vertex.get(j)){
	                int next = edge.e, w = edge.w;
	                if(dist[j] != INF && dist[next] > dist[j] + w){
	                    dist[next] = dist[j] + w;
	                    // N번째 루프에 값이 갱신되면 음의 싸이클이 존재한다.
	                    if(i == N-1) minusCycle = true;
	                }
	            }
	        }
	    }
	}
	
	static class Edge {
		int e, w;
		Edge(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
