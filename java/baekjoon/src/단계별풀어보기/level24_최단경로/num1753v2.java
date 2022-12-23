package 단계별풀어보기.level24_최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class num1753v2 {
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputVE = br.readLine().split(" ");
		int V = stoi(inputVE[0]);
		int E = stoi(inputVE[1]);
		int K = stoi(br.readLine());
		
		boolean[] visited = new boolean[V+1];
		int[] distance = new int[V+1];
		Arrays.fill(distance, INF);
		LinkedList<E> node[] = new LinkedList[V+1];
		
		for(int i=1; i<=V; i++) {
			node[i] = new LinkedList<>();
		}
		
		for(int i=0; i<E; i++) {
			String[] inputData = br.readLine().split(" ");
			int u = stoi(inputData[0]);
			int v = stoi(inputData[1]);
			int w = stoi(inputData[2]);
			
			node[u].add(new E(v,w));
		}
		
		dijkstra(node, visited, distance, K);
		
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++)
            sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
        System.out.print(sb.toString());
	}
	
	public static void dijkstra(LinkedList<E>[] node, boolean[] visited, int[] distance, int K) {
		PriorityQueue<E> q = new PriorityQueue<>();
		q.offer(new E(K, 0));
		distance[K] = 0;
		
		while(!q.isEmpty()) {
			E now = q.poll();
			if(!visited[now.e]){
				for(E next : node[now.e]) {
					if(distance[next.e] > distance[now.e] + next.weight) {
						distance[next.e] = distance[now.e] + next.weight;
						q.add(new E(next.e, distance[next.e]));
					}
				}
				visited[now.e] = true;
			}
		}
		
	}

	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}

class E implements Comparable<E>{
    int e, weight;

    public E(int e, int weight) {
    	this.e = e;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(E o) {
    	return weight - o.weight;
    }
    
}