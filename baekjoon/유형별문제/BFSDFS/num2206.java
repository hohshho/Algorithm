package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num2206 {
	static int n,m;
	static int[][] arr;
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	static int count = 0;
	static boolean[][] visited;
	static int throwIndex = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		arr = new int[n][m];
		visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			String[] arrData = br.readLine().split("");
			for(int j=0;j<m;j++) {
				q.offer(new int[] {i,j});
				arr[i][j] = Integer.parseInt(arrData[j]);
			}
		}
		bfs(q);
		if(count == 0)
			System.out.println(-1);
		else
			System.out.println(arr[n-1][m-1]);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
	}
	public static void bfs(Queue<int[]> q) {
		while(!q.isEmpty()) {
			int[] qData = q.poll();
			visited[qData[0]][qData[1]] = true;
			for(int i=0;i<4;i++) {
				int moveX = qData[0]+ dx[i];
				int moveY = qData[1]+ dy[i];
				int move2X = moveX + dx[i];
				int move2Y = moveY + dy[i];
				if(moveX>=0 && moveY>=0 && moveX<n && moveY<m && visited[moveX][moveY]==false && arr[moveX][moveY] == 0) {
					if(arr[moveX][moveY] != 1) {
						visited[moveX][moveY] = true;
						count++;
						arr[moveX][moveY] = count;
					}else if(move2X>=0 && move2Y>=0 && move2X<n && move2Y<m && arr[moveX][moveY] == 1 && arr[move2X][move2Y] == 0 && throwIndex == 0) {
						throwIndex = 1;
						visited[moveX][moveY] = true;
						count++;
						arr[moveX][moveY] = count;	
					}
				}
			}
		}
	}

}
