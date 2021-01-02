package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num2178 {
	static int n,m,min=100,count;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		n = Integer.parseInt(NM[0]);
		m = Integer.parseInt(NM[1]);
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String[] arrData = br.readLine().split("");
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(arrData[j]);
			}
		}
		
		bfs(0,0);
		System.out.println(arr[n-1][m-1]);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int location[] = queue.poll();
			visited[x][y] = true;
			
			for(int i=0; i<4;i++) {
				int r = location[0] + dx[i];
				int c = location[1] + dy[i];
				if(r>=0 && c>=0 && r<n && c<m) {
					if(arr[r][c] != 0 && !visited[r][c]) {
						queue.offer(new int[] {r,c});
						visited[r][c] = true;
						arr[r][c] = arr[location[0]][location[1]] + 1;
					}
				}
			}
			
		}
		
		
	}

}
