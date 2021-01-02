package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1926 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int max = 0,n,m,count=0;
	static int[][] arr;
	static int index =0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		n = Integer.parseInt(NM[0]);
		m = Integer.parseInt(NM[1]);
		arr = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String[] arrData = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(arrData[j]);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j] == 1) {
					count++;
					index++;
					bfs(i,j);
					index = 0;
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
	}
	public static void bfs(int x, int y) {
		arr[x][y] = 0;
		max = max > index ? max : index;
		for(int i=0;i<4;i++) {
			if(x+dx[i]>=0 && x+dx[i] < n && y+dy[i]>=0 && y+dy[i] < m) {
				if(arr[x+dx[i]][y+dy[i]] ==1 ) {
					index++;
					bfs(x+dx[i], y+dy[i]);
				}
			}
		}
	}
}
