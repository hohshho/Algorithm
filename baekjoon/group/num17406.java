package group;

import java.util.Scanner;

public class num17406 {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] data = new int[N][M];
		int[][] rotateData = new int[K][3];
		
		int answer;
		int reindex = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0;j<M;j++) {
				data[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<K;i++) {
			for(int j=0;j<3;j++) {
				rotateData[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<K;i++) {
			int x = rotateData[i][2]*2 +1;
			data = arrayRotate(data,x,rotateData[i],reindex);
		}
		
		answer = result(data);
		System.out.println(answer);
	}
	public static int[][] arrayRotate(int[][] data, int x, int[] rotateData,int reindex) {
		if(x<2) {
			return data;
		}else {
			data = arrayRotate(data,x-2,rotateData,reindex+1);
		}
		// 깊은 복사
		int[][] newData = new int[data.length][data[0].length];
		for(int i=0;i<data.length;i++) {
			System.arraycopy(data[i],0,newData[i],0,data[i].length);
		}

		
		int x1 = rotateData[0] - rotateData[2] -1 + reindex;
		int y1 = rotateData[1] - rotateData[2] -1 + reindex;
		int x2 = rotateData[0] + rotateData[2] -1 - reindex;
		int y2 = rotateData[1] + rotateData[2] -1 - reindex;
		// x 첫째줄
		for(int i=0;i<x-1;i++) {
			// x 첫째줄
			newData[x1][y1+i+1] = data[x1][y1+i];
//			 y 오른쪽 열
			newData[x1+i+1][y2] = data[x1+i][y2];
			
			newData[x2][y2-i-1] = data[x2][y2-i];
			
			newData[x2-i-1][y1] = data[x2-i][y1];
		}
		
		
		return newData;
		
	}
	
	public static int result(int[][] data) {
		int answer=2500;
		int value = 0;
		for(int i =0; i<data.length;i++) {
			for(int j=0; j<data.length+1;j++) {
				value+=data[i][j];
			}
			if(value<answer) {
				answer = value;
			}
			value = 0;
		}
		
		return answer;
	}
	
}
