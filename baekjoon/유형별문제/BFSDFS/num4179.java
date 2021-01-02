package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num4179 {
	static int r,c;
	static int[][] person; // 지훈이가 이동한 시간 정보
	static int[][] fire; // 불이 이동한 시간 정보
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	static boolean resultIndex = false; // 탈출할 성공 여부
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rc = br.readLine().split(" ");
		int r = Integer.parseInt(rc[0]);
		int c = Integer.parseInt(rc[1]);
		person = new int[r][c];
		fire = new int[r][c];
		Queue<int[]> qPerson = new LinkedList<>(); 
		Queue<int[]> qFire = new LinkedList<>();
		
		for(int i=0; i<r; i++) {
			String[] data = br.readLine().split("");
			for(int j=0; j<c; j++) {
				if(data[j].equals("#")) {
					person[i][j] = -1;
					fire[i][j] = -1;
				}else if(data[j].equals("J")) {
					qPerson.offer(new int[] {i,j});
					person[i][j] = 1;
				}else if(data[j].equals("F")) {
					qFire.offer(new int[] {i,j});
					fire[i][j] = 1;
				}else {
					person[i][j] = 0;
					fire[i][j] = 0;
				}
			}
		}
		
		// 불부터
		while(!qFire.isEmpty()) {
			int[] point = qFire.poll();
			for(int i=0;i<4;i++) {
				int x = point[0] + dx[i];
				int y = point[1] + dy[i];
				if(x>=0 && y>=0 && x<r && y<c && fire[x][y] == 0) {
					fire[x][y] = fire[point[0]][point[1]] + 1;
					qFire.offer(new int[]{x,y});
				}
			}
		}
		
		// 지훈은 시간 넣을 때 불이랑 체크해줘야 함
		outer : while(!qPerson.isEmpty()) {
			int[] point = qPerson.poll();
			for(int i=0;i<4;i++) {
				int x = point[0] + dx[i];
				int y = point[1] + dy[i];
				if(x>=r || y>=c || x<0 || y<0) {
					resultIndex = true;
					System.out.println(person[point[0]][point[1]]);
					break outer;
				}
				if(x>=0 && y>=0 && x<r && y<c && person[x][y] == 0) {
					person[x][y] = person[point[0]][point[1]] + 1;
					if(person[x][y] < fire[x][y] || fire[x][y] == 0)
						qPerson.offer(new int[]{x,y});
				}

			}
		}
		if(!resultIndex)
			System.out.println("IMPOSSIBLE");
		
	}
}
