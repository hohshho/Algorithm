package package23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 1. 행렬 / 2. 리스트
// 1. stack / 2. 재귀

public class num1260 {
	
	static boolean[] visit;
	static int[][] map;
	static int N,M,V;
	
	// DFS stack 이용 풀이
	/*
	 * 1. 초기 값 스택에 저장
	 * 2. stack에 값이 없을때 까지 while문 반복
	 * 3. flag사용 -> stack에 값 넣지 않으면 pop
	 * 4. stack에 값 넣으면 flag = true
	 * 5. push할 때마다 출력한다.
	 */
//	public static void dfs(int i) {
//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(i);
//		visit[i] = true;
//		System.out.print(i+ " ");
//		boolean flag;
//		
//		while(!stack.isEmpty()) {
//			int index = stack.peek();
//			flag = false;
//			
//			for(int j=1;j<=N;j++) {
//				if(map[index][j]==1 && !visit[j]) {
//					stack.push(j);
//					System.out.print(j+ " ");
//					visit[j] = true;
//					flag = true;
//					break;
//				}
//			}
//			if(!flag) {
//				stack.pop();
//			}
//		}
//		
//	}
	
	/*
	 * DFS 재귀 풀이
	 * 1. 초기값 방문 표시
	 * 2. 초기값 맵 돌면서 방문 안한 값 재귀 호출
	 */
	
	public static void dfs(int i) {
		visit[i] = true;
		System.out.print(i + " ");
		
		for(int j=1;j<=N;j++) {
			if(map[i][j] == 1 && !visit[j]) {
				dfs(j);
			}
		}
	}
	
	//BFS 큐 이용 문제풀이
	
	public static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(i);
		visit[i] = true;
		
		while(!queue.isEmpty()) {
			int index = queue.poll();
			System.out.print(index + " ");
			for(int j=1;j<=N;j++) {
				if(map[index][j] == 1 && !visit[j]) {
					queue.offer(j);
					visit[j] = true;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NMV = br.readLine().split(" ");
		N = Integer.parseInt(NMV[0]);
		M = Integer.parseInt(NMV[1]);
		V = Integer.parseInt(NMV[2]);
		
		// 초기값 초기화
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(map[i],0);
		}
		Arrays.fill(visit,false);
		
		// 간선 생성
		for(int i=0;i<M;i++) {
			String[] data = br.readLine().split(" ");
			int x = Integer.parseInt(data[0]);
			int y = Integer.parseInt(data[1]);
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		dfs(V);
		System.out.println();
		Arrays.fill(visit,false);
		bfs(V);
		
	}
}
