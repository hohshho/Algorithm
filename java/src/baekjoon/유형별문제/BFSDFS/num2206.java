package BFSDFS;

import java.util.*;
import java.io.*;

public class num2206 {
	
	public static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		int[][] map = new int[n][m];
		int[][] visit = new int[n][m];
		int[][] len = new int[n][m];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int ans = -1;
		
		Queue <Node> q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		q.add(new Node(0, 0));
		visit[0][0] = 1;
		len[0][0] = 1;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.x == n - 1 && node.y == m - 1) {
				ans = len[node.x][node.y];
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if(map[nx][ny] == 0 && (visit[nx][ny] == 0 || visit[nx][ny] > visit[node.x][node.y])) {
						visit[nx][ny] = visit[node.x][node.y];
						len[nx][ny] = len[node.x][node.y] + 1; 
						q.add(new Node(nx, ny));
					}
					else if(map[nx][ny] == 1 && visit[node.x][node.y] <= 1){
						visit[nx][ny] = visit[node.x][node.y] + 1;
						len[nx][ny] = len[node.x][node.y] + 1; 
						q.add(new Node(nx, ny));
					}
				}
			}
		}
		System.out.println(ans);
	}
}