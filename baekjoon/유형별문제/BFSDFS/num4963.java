package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num4963 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String[] inputWH = br.readLine().split(" ");
			int W = stoi(inputWH[0]);
			int H = stoi(inputWH[1]);
			
			if(W == 0 && H == 0)
				break;
			int[][] map = new int[H][W];
			
			for(int i=0; i<H; i++) {
				String[] mapData = br.readLine().split(" ");
				for(int j=0; j<W; j++) {
					map[i][j] = stoi(mapData[j]);
				}
			}
			sb.append(checkLand(map,H,W) + "\n");	
		}
		System.out.println(sb);
	}
	
	public static int checkLand(int[][] map, int H, int W) {
		int landCount = 0;
		int[] dx = new int[] {0,1,1,1,0,-1,-1,-1};
		int[] dy = new int[] {1,1,0,-1,-1,-1,0,1};
		int[][] visited = new int[H][W];
		Queue<int[]> queue = new LinkedList<>();
		
		// TODO : 모든 노드 방문 로직 짜야함
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) {
					queue.offer(new int[] {i,j});
					visited[i][j] = 1;
					landCount++;
					while(!queue.isEmpty()) {
						int[] nextData = queue.remove();
						int X = nextData[0];
						int Y = nextData[1];
						for(int k=0;k<8;k++) {
							int nextX = X+ dx[k];
							int nextY = Y+ dy[k];
							if(isPossible(nextX, nextY, H, W) && visited[nextX][nextY] == 0 && map[nextX][nextY] == 1) {
								queue.offer(new int[] {nextX, nextY});
								visited[nextX][nextY] = 1;
							}
						}
					}
				}
			}
		}
		
		return landCount;
	}
	
	public static boolean isPossible(int x, int y, int H, int W) {
		return x>=0 && x<H && y>=0 && y<W ? true : false;
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
