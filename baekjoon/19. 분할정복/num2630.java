package package19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class num2630 {
	static int n;
	static boolean[][] arr;
	static int whitePaper = 0;
	static int bluePaper = 0;

	static void cutPaper(int x,int y, int paperLen) {
		if(paperLen==1) {
			if(arr[y][x])
				bluePaper++;
			else
				whitePaper++;
			return;
		}
		boolean index = true;
        boolean color = arr[y][x];
		out : for(int i=y;i<y+paperLen;i++) {
			for(int j=x;j<x+paperLen;j++) {
				if(color!=arr[i][j]) {
					index = false;
					break out;
				}
			}
		}
		if(index==false) {
			int nextLen = paperLen/2;
			cutPaper(x,y,nextLen);
			cutPaper(x+nextLen,y,nextLen);
			cutPaper(x,y+nextLen,nextLen);
			cutPaper(x+nextLen,y+nextLen,nextLen);
		}else {
			if(arr[y][x])
				bluePaper++;
			else
				whitePaper++;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        arr = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < line.length; j++) {
                arr[i][j] = Integer.parseInt(line[j]) == 1? true: false;
            }
        }
		
		cutPaper(0,0,n);
		
		System.out.println(whitePaper);
		System.out.println(bluePaper);
	}
}