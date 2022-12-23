package 단계별풀어보기.level19_분할정복;

import java.io.*;

public class num1992 {
	static StringBuilder sb;
	static int n;
	static boolean[][] videoArr;
	// i에 y값 저장, j에 x값 저장
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		videoArr = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String[] inputData = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				videoArr[i][j] = Integer.parseInt(inputData[j]) == 1 ? true : false;
			}
		}
		
		calcVideo(0,0,n,0);
		System.out.println(sb.toString());
	}

	public static void calcVideo(int x, int y, int length,int rotate) {
		// length 1일때 종료조건 추가해야 함
		if(length==1) {
			if(rotate==1) {
				sb.append("(");
			}
			sb.append(videoArr[y][x] == true ? 1 : 0);
			if(rotate == 4) {
				sb.append(")");
			}
			return;
		}
		if(rotate==1) {
			sb.append("(");
		}
		boolean same = true;
		boolean index = videoArr[y][x];
		
		out : for(int i=y;i<y+length;i++) {
			for(int j=x;j<x+length;j++) {
				if(index!=videoArr[i][j]) {
					same = false;
					break out;
				}
			}
		}
		if(same==false) {
			int nextLen = length/2;
			// 4개 방향
			calcVideo(x,y,nextLen,1);
			calcVideo(x+nextLen,y,nextLen,2);
			calcVideo(x,y+nextLen,nextLen,3);
			calcVideo(x+nextLen,y+nextLen,nextLen,4);
		}else {
			sb.append(videoArr[y][x] == true ? 1 : 0);
		}
		if(rotate == 4) {
			sb.append(")");
		}
		
	}
//	public static void appendSign(int rotate) {
//		if(rotate == 1) sb.append("(");
//		else sb.append(")");
//	}
}
