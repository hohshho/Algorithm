package package27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num4803 {
	static int N, M, count, caseIndex = 0;
	static StringBuilder sb;
	static BufferedReader br; 
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while(true) {
			String[] NM = br.readLine().split(" ");
			
			N = stoi(NM[0]);
			M = stoi(NM[1]);
			graph = new ArrayList[N+1];
			visited = new boolean[N+1];
			
			if(N==0 && M==0) {
				break;
			}
			
			resetData();
			
			inputTreeData();
			
			checkTree();
		}
		System.out.println(sb);
	}
	
	public static void inputTreeData() throws IOException {
		for(int i=0; i<M; i++) {
			String[] Edge = br.readLine().split(" ");
			int v1 = stoi(Edge[0]), v2 = stoi(Edge[1]);
			
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
	}
	
	public static void checkTree() {

		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				if(dfs(i, 0))
					count++;
			}
		}
		
		if(count == 1) {
			sb.append("Case "+caseIndex+": There is one tree.\n");
		}else if(count==0){
			sb.append("Case "+caseIndex+": No trees.\n");
		}else {
			sb.append("Case "+caseIndex+": A forest of "+count+" trees.\n");
		}
	}
	
	public static boolean dfs(int num, int prev) {
		visited[num] = true;
		
		for(int node : graph[num]) {
			if (node == prev) continue;
			if (visited[node]) return false;
			if (dfs(node, num) == false) return false;
		}
		return true;
	}
	
	public static void resetData() {
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
			visited[i] = false;
		}
		count = 0;
		caseIndex++;
	}

	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
