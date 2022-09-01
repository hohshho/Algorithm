package package19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1780 {
	static int[][] arr;
	static int N;
	static int minusOne=0, zero=0, plusOne=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] inputData = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] = stoi(inputData[j]);
			}
		}
		
		countPaper(0, 0, N);
		
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(plusOne);
	}
	
	public static void countPaper(int x, int y, int N) {
		boolean index = checkPaper(x, y, N);
		if(!checkPaper(x,y,N)) {
			int len = N/3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					countPaper(x+(i*len),y+(j*len),len);
				}
			}
		}else {
			countPlus(x,y);
		}
	}
	
	public static boolean checkPaper(int x, int y, int len) {
		int value = arr[x][y];
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				if(value!=arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void countPlus(int x, int y) {
		int value = arr[x][y];
		if(value == -1) {
			minusOne++;
		}else if(value == 0) {
			zero++;
		}else {
			plusOne++;
		}
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
