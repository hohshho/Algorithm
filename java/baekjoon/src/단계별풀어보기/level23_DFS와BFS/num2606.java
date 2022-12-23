package 단계별풀어보기.level23_DFS와BFS;

import java.util.*;

public class num2606 {
	static int node[][]; // 그래프 배열
	static int check[]; // 방문 배열
	static void bfs(int start) { 
		Queue<Integer> queue = new LinkedList<>();
		
		check[start] =1;
		queue.offer(start);
		int cnt = 0; // 감염 된 컴퓨터의 수
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			for(int i=1;i<node.length;i++) {
				if(node[x][i]==1 && check[i]!=1) {
					queue.offer(i);
					check[i] = 1;
					cnt++;
				}
			}
		}
		System.out.println(cnt); 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int n= sc.nextInt(); // 컴퓨터의 수
		int m = sc.nextInt(); // 네트워크 상에 연결되어 있는 컴퓨터 쌍의 수 즉, 간선의 수
		
		node=new int[n+1][n+1];
		check = new int[n+1];
		for(int i=0;i<m;i++) { // 그래프 구성
			int a=sc.nextInt();
			int b = sc.nextInt();
			node[a][b]=1;
			node[b][a]=1;
			
		}
		
		bfs(1);
		
		
	}
	
}
