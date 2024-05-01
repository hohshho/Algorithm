import java.util.*;
import java.io.*;

// 4월 9일 1시간 10분  2시간 30분
// 19:40분 ~ 20:53 21:43분 ~ 12:03
public class samsung2023_2_2_1_ver2 {
	static int[][] map;
//	static int[] ldx = {0, 1, 1, 1, 0, -1, -1, -1};
//	static int[] ldy = {-1, -1, 0, 0, 1, 1, 1, 0, -1};
	// 상, 우, 하, 좌
	static int[] sdx = {0, 1, 0, -1};
	static int[] sdy = {-1, 0, 1, 0};
	// 게임판 크기, 게임 턴, 산타 수, 루돌프 힘, 산타 힘 
	static int N, M, P, C, D;
	
	static int santaDeadCnt = 0;
	static Point lu;
	static Santa[] santas;
	static int[] scores;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		P = stoi(st.nextToken());
		C = stoi(st.nextToken());
		D = stoi(st.nextToken());
		
		map = new int[N][N];
		santas = new Santa[P + 1];
		scores = new int[P + 1];
		
		st = new StringTokenizer(br.readLine());
		// y축, x축 순서로 입력
		lu = new Point(stoi(st.nextToken()) - 1, stoi(st.nextToken()) - 1);
		
		for(int i=0; i<P; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = stoi(st.nextToken());
			int y = stoi(st.nextToken()) - 1;
			int x = stoi(st.nextToken()) - 1;
			
			santas[n] = new Santa(x, y);
			map[y][x] = n;
		}
		
		int turn = 1;
		while(true) {
			if(turn > M || santaDeadCnt == P) break;
			// 1. 루돌프 움직임
			// 1.1) 가장 가까운 산타 탐색
			int minSantaIdx = 0;
			for(int i=1; i<=P; i++) {
				// 벗어난 산타 pass
				if(santas[i].finish) continue;
				
				if(minSantaIdx == 0) {
					minSantaIdx = i;
					continue;
				}
				
				// 기존 산타의 거리보다 작으면 
				if(getDistance(santas[minSantaIdx].point.x, lu.x, santas[minSantaIdx].point.y, lu.y) > getDistance(santas[i].point.x, lu.x, santas[i].point.y, lu.y)) {
					minSantaIdx = i;
					continue;
				}
				
				if(getDistance(santas[minSantaIdx].point.x, lu.x, santas[minSantaIdx].point.y, lu.y) == getDistance(santas[i].point.x, lu.x, santas[i].point.y, lu.y)) {
					// 거리 같으면 y좌표 위치에 따라
					if(santas[i].point.y > santas[minSantaIdx].point.y) {
						minSantaIdx = i;
						continue;
					}
					
					// 그래도 같으면 x좌표 위치에 따라
					if(santas[i].point.y == santas[minSantaIdx].point.y && santas[i].point.x > santas[minSantaIdx].point.x) {
						minSantaIdx = i;
					}	
				}
			}
			
			// 1.2) 방향 탐색
			int tempDx = (santas[minSantaIdx].point.x - lu.x);
			int tempDy = (santas[minSantaIdx].point.y - lu.y);
			int luDx = tempDx > 0 ? 1 : tempDx == 0 ? 0 : -1;
			int luDy = tempDy > 0 ? 1 : tempDy == 0 ? 0 : -1;
			
			lu.x += luDx;
			lu.y += luDy;
			
			// 1.2 산타 충돌 -> 상호 작용
			if(map[lu.y][lu.x] != 0) {
				scores[map[lu.y][lu.x]] += C;
				santas[map[lu.y][lu.x]].stun = turn + 1;
				// 맵에서 없애기
				
				bump(map[lu.y][lu.x], lu.x, lu.y, luDx, luDy, C);
				map[lu.y][lu.x] = 0;
			}
			
			// 2. 산타 움직임
			for(int i=1; i<=P; i++) {
				// 벗어난 산타 pass
				if(santas[i].finish) continue;
				
				// 기절 된 산타 pass
				if(santas[i].stun >= turn) continue;
				
				// 방향 탐색
				int nx = 0, ny = 0;
				int dIdx = 0;
				int distance = getDistance(santas[i].point.x, lu.x, santas[i].point.y, lu.y);
				for(int j=0; j<4; j++) {
					int tempNx = santas[i].point.x + sdx[j];
					int tempNy = santas[i].point.y + sdy[j];
					
					if(!checkMapArrange(tempNx, tempNy)) continue;
					
					// 산타 존재하면 pass
					if(map[tempNy][tempNx] != 0) continue;
					
		
					// 이동한게 더 작으면 이동
					if(distance > getDistance(tempNx, lu.x, tempNy, lu.y)) {
						nx = tempNx;
						ny = tempNy;
						dIdx = j;
						distance = getDistance(tempNx, lu.x, tempNy, lu.y);
					}

				}
				
				// 이동 못하면 pass
				if(nx == 0 && ny == 0) continue;
				
				map[santas[i].point.y][santas[i].point.x] = 0;
				// 이동 했는데 루돌프 충돌
				if(lu.x == nx && lu.y == ny) {
					scores[i] += D;
					santas[i].stun = turn + 1;
					bump(i, lu.x, lu.y, -sdx[dIdx], -sdy[dIdx], D);
				}
				else {
					santas[i].point.x = nx;
					santas[i].point.y = ny;
					map[ny][nx] = i;
				}
			}
			
			// 3. 살아남은 산타 점수 add
			for(int i=1; i<=P; i++) {
				if(santas[i].finish) continue;
				scores[i] += 1;
			}
			turn += 1;
		}
		
		for(int i=1; i<=P; i++) {
			System.out.print(scores[i] + " ");
		}
	}
	
	// action : l - 루돌프, s - 산타, a - 상호작용
	public static void bump(int santaIdx, int x, int y, int luDx, int luDy, int power) {
		int nx = x + (power * luDx);
		int ny = y + (power * luDy);
		
		if(!checkMapArrange(nx, ny)) {
			santas[santaIdx].finish = true;
			santaDeadCnt += 1;
			return;
		}
		
		// 상호 작용
		if(map[ny][nx] != 0) {
			bump(map[ny][nx], nx, ny, luDx, luDy, 1);
		}
		
		map[ny][nx] = santaIdx;
		santas[santaIdx].point.y = ny;
		santas[santaIdx].point.x = nx;
	}

	public static boolean checkMapArrange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
	
	public static int getDistance(int x1, int x2, int y1, int y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
	
	static class Santa {
		int stun;
		boolean finish;
		Point point;
		Santa(int y, int x) {
			this.stun = 0;
			this.finish = false;
			this.point = new Point(x, y);
		}
	}
	
	static class Point {
		int x, y;
		Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
