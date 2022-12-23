package 유형별문제.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11660 {
	static int N, M, x1, x2, y1, y2;
	static int[][] map, pSum;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		N = stoi(NM[0]);
		M = stoi(NM[1]);
		map = new int[N+1][N+1];
		pSum = new int[N+2][N+2];
		
		for(int i=0; i<N; i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = stoi(row[j]);
				pSum[i+1][j+1] = pSum[i+1][j] + pSum[i][j+1] - pSum[i][j] + map[i][j];
			}
		}
		
		for(int i=1; i<=M; i++) {
			String[] point = br.readLine().split(" ");
			x1 = stoi(point[0]);
			y1 = stoi(point[1]);
			x2 = stoi(point[2]);
			y2 = stoi(point[3]);
			
			sb.append(pSum[x2][y2] - pSum[x1-1][y2] - pSum[x2][y1-1] + pSum[x1-1][y1-1] + "\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
