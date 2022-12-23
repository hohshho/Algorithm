package 유형별문제.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num12100 {
	static int N;
	// 1. 상 - 1, 하 - 2, 좌 - 3, 우 - 4
	static int[] dx = new int[] {0, 0, -1, 1};
	static int[] dy = new int[]	{1, -1, 0, 0};
	static int[][] board;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		
	}
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
