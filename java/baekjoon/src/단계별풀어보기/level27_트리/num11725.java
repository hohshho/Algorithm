package 단계별풀어보기.level27_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class num11725 {
	static int N;
	static ArrayList<ArrayList<Integer>> tree;
	static StringBuilder sb;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tree = new ArrayList<ArrayList<Integer>>();
		sb = new StringBuilder();
		
		int N = stoi(br.readLine());
		result = new int[N+1];
		visited = new boolean[N+1];
		for(int i=0; i<=N; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N-1; i++) {
			String[] edge = br.readLine().split(" ");
			int node1 = stoi(edge[0]);
			int node2 = stoi(edge[1]);

			tree.get(node1).add(node2);
			tree.get(node2).add(node1);
		}
		
//		dfs(1);
		bfs();
		
		for(int i=2; i<=N; i++) {
			System.out.println(result[i]);
		}
	}
	
    private static void dfs(int num){
        if(visited[num]){
            return;
        }
        visited[num] =true;
        for (int node: tree.get(num)) {
            if(!visited[node]){
                result[node] = num;
                dfs(num);
            }

        }

    }
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int value : tree.get(1)) {
			result[value] = 1;
			queue.add(value);
		}
		
		while(!queue.isEmpty()) {
			int node = queue.remove();
			
			for(int value : tree.get(node)) {
				if(result[value] == 0) {
					result[value] = node;
					queue.add(value);
				}
			}
		}
		
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
