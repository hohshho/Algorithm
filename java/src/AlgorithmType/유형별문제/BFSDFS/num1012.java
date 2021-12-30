package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1012 {
	static int problemCount, m, n, k,count;
	static int[][] arr;
	static int[] result;
	static boolean[][] visited;
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		problemCount = Integer.parseInt(br.readLine());
		result = new int[problemCount];
		
		for(int i=0; i<problemCount; i++) {
			String[] mnk = br.readLine().split(" ");
			m = Integer.parseInt(mnk[0]);
			n = Integer.parseInt(mnk[1]);
			k = Integer.parseInt(mnk[2]);
			arr = new int[m][n];
			visited = new boolean[m][n];
			for(int j=0; j<k; j++) {
				String[] arrData = br.readLine().split(" ");
				arr[Integer.parseInt(arrData[0])][Integer.parseInt(arrData[1])] = 1;
			}
			for(int j=0;j<m;j++) {
				for(int l=0;l<n;l++) {
					if(visited[j][l] != true && arr[j][l] == 1) {
						dfs(j,l);
						count++;
					}
				}
			}
			result[i] = count;
			count=0;
		}
		for(int i=0;i<problemCount;i++) {
			System.out.println(result[i]);
		}
	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0;i<4;i++) {
			int r = dx[i] + x;
			int c = dy[i] + y;
			if(r>=0 && c>=0 && r<m && c<n && arr[r][c] == 1 && visited[r][c]!=true) {
				dfs(r,c);
			}
		}
	}
	
}
