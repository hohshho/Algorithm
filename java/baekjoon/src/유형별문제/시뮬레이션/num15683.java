package 유형별문제.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num15683 {
	static int[] dx = new int[]{1,-1,0,0};
	static int[] dy = new int[]{0,0,-1,1};
	static int n,m;
	static int[][] map;
	static int field = 0;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String[] inputData = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				int value = Integer.parseInt(inputData[j]);
				map[i][j] = value;
				field = value == 0 ? field++ : field;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		checkMinField(0,0);
		System.out.println(result);
		
	}
	public static void checkMinField(int x, int y) {
		if(!validNValue(x))
			return;
		if(!validMValue(y))
			return;
		for(int i=x;i<n;i++) {
			for(int j=y;j<m;j++) {
				if(map[i][j] == 1) {
					for(int k=1;k<5;k++) {
						changeMap(i,j,k,1);
						if(j==m-1)
							checkMinField(i++,j);
						else
							checkMinField(i,j++);
						changeMap(i,j,k,2);
					}
				}else if(map[i][j] == 2) {
					int kIndex = 0;
					for(int k=1;k<3;k++) {
						changeMap(i,j,kIndex*k+1,1);
						changeMap(i,j,kIndex*k+2,1);
						checkMinField(i,j++);
						changeMap(i,j,kIndex*k+1,2);
						changeMap(i,j,kIndex*k+2,2);
						kIndex++;
					}
				}else if(map[i][j] == 3) {
					// 1,4 북 동/ 1,3 동 남 / 2,3 남서 / 2,4서북
					for(int k=1;k<3;k++) {
						for(int l=3;l<5;l++) {
							changeMap(i,j,k,1);
							changeMap(i,j,l,1);
							checkMinField(i,j++);
							changeMap(i,j,k,2);
							changeMap(i,j,l,2);
						}
					}
				}else if(map[i][j] == 4) {
					for(int k=0;k<4;k++) {
						changeMap(i,j,k,1);
					}
					for(int k=0;k<4;k++) {
						changeMap(i,j,k,2);
						checkMinField(i,j++);
						changeMap(i,j,k,1);
					}
				}else if(map[i][j] == 5) {
					changeMap(i,j,1,1);
					changeMap(i,j,2,1);
					changeMap(i,j,3,1);
					changeMap(i,j,4,1);
				}
				if(x == n-1 && y == m-1) {
					int calcValue = countMapZero();
					result =  calcValue < result ? calcValue : result;
					return;
				}
			}
		}
	}
	// index : 1 - 동 / index : 2 - 서/ index : 3 - 남/ index : 4 - 북
	public static void changeMap(int x, int y, int index, int paint) {
		if(paint == 1) {
			while(true) {
				x += dx[index];
				y += dy[index];
				if(validNValue(x) && validMValue(y)) {
					if(map[x][y] == 0)
						map[x][y] = 7;
					else if(map[x][y] == 6)
						break;
					else
						continue;
				}
				else {
					break;
				}
			}
		}else {
			while(true) {
				x += dx[index];
				y += dy[index];
				if(validNValue(x) && validMValue(y)) {
					if(map[x][y] == 7)
						map[x][y] = 0;
					else if(map[x][y] == 6)
						break;
					else
						continue;
				}
				else {
					break;
				}
			}
		}
	}
	
	public static boolean validNValue(int value) {
		return value >= 0 && value<n ? true : false;
	}
	
	public static boolean validMValue(int value) {
		return value >=0 && value<m ? true : false;
	}
	
	public static int countMapZero() {
		int returnValue = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				returnValue = map[i][j] == 0 ? returnValue++ : returnValue;
			}
		}
		return returnValue;
	}
}
