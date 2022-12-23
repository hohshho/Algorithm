package 단계별풀어보기.level10_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 
 */

public class num2447 {
	public static char[][] arr;
	public static void makeStar(int x, int y, int num) {
//		System.out.println(x+" " + y + " " + num);
		if(num ==1) {
			arr[x][y] = '*';
			return;
		}
		
		int value = num/3;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==1 && j==1) ;
				else {
					makeStar(x+(value*i),y+(value*j),value);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		// 초기화
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				arr[i][j] = ' ';
//			}
//		}
		for(int i=0;i<arr.length;i++) {
			Arrays.fill(arr[i],' ');
		}
		makeStar(0,0,N);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		
	}
	
}
