import java.util.*;
import java.io.*;

public class samsung2022_1_1_1 {
	// 맵크기, 도망자 수, 나무 위치, 끝나는 turn수
	static int N, M, H, K;
	// 상, 우, 하, 좌
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static Sol sol;
	static Runner runner;
	static int finishCnt = 0;

	// 맵에 도망자의 인덱스 저장
	static HashSet<Integer>[][] runnerIndexMap;
	// 도망자의 상태 값 저장
	static Runner[] runners;
	// 맵에 나무 저장
	static boolean[][] treeMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		H = stoi(st.nextToken());
		K = stoi(st.nextToken());

		runnerIndexMap = new HashSet[N][N];
		runners = new Runner[M + 1];
		treeMap = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				runnerIndexMap[i][j] = new HashSet<Integer>();
			}
		}

		for (int i = 1; i <= M; i++) {
			// 입력 순서 : y축, x축, 방향
			st = new StringTokenizer(br.readLine());
			int y = stoi(st.nextToken());
			int x = stoi(st.nextToken());
			int direction = stoi(st.nextToken());

			runners[i] = new Runner(i, x, y, direction);

		}

		for (int i = 0; i < H; i++) {
			// 입력 순서 : y축, x축
			st = new StringTokenizer(br.readLine());

			int y = stoi(st.nextToken());
			int x = stoi(st.nextToken());

			treeMap[y][x] = true;
		}

		for (int i = 1; i <= K; i++) {
			// 1. 도망자 턴
			runnerTurn();

			// 2. 술래 이동
			solTurn(K);

			// 도망자가 모두 잡혔을 경우 종료
			if (finishCnt == M)
				break;
		}

		System.out.println(sol.score);
	}

	public static void runnerTurn() {
		for (int i = 1; i < M; i++) {
			// 1. 잡힌 도망자 pass
			if(runners[i].finish) continue;
			
			// 2. 현재 도망자 거리 체크 (3이상 일 경우 pass)
			if(getDistance(runners[i].x, runners[i].y) > 3) continue;
			
			// 3. 다음 위치 확인 후 방향 전환
			if(isInrange(
					runners[i].x + dx[runners[i].direction], 
					runners[i].y + dy[runners[i].direction])
					) {
				runners[i].setBackDirection();
			}
			
			int nx = runners[i].x + dx[runners[i].direction];
			int ny = runners[i].y + dy[runners[i].direction];
			
			// 4. 다음 위치에 술래가 있을 경우 pass
			if(sol.x == nx && sol.y == ny) continue;
			
			// 5. 맵 갱신, 도망자 상태 변환
			runnerIndexMap[runners[i].y][runners[i].x].remove(runners[i].index);
			runners[i].setXY(nx, ny);
			runnerIndexMap[runners[i].y][runners[i].x].add(runners[i].index);
		}
	}

	public static void solTurn(int turn) {
		// 1. 방향 이동
		
		// 2. 전환하는 자리 일 경우 바라보는 방향 전환
		
		// 3. 현재 자리 기준 +2 까지 검사 후 도망자 잡기
		// 3.1) 나무에 가려진 경우 pass
		
		// 3.2) 잡힌경우 turn * 도망자 수 / score갱신
		
		// 3.3) 도망자 finish처리
	}

	static class Runner {
		int index, direction, x, y;
		boolean finish;

		Runner(int index, int direction, int x, int y) {
			this.index = index;
			this.direction = direction;
			this.x = x;
			this.y = y;
			this.finish = false;
		}

		void setBackDirection() {
			this.direction = (this.direction + 2 + 4) % 4;
		}
		
		void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static class Sol {
		int direction, x, y, score;

		Sol(int direction, int x, int y, int score) {
			this.direction = direction;
			this.x = x;
			this.y = y;
			this.score = score;
		}

		void setScore(int score) {
			this.score = score;
		}
		
		void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int getDistance(int x, int y) {
		return Math.abs(sol.x - x) + Math.abs(sol.y - y);
	}

	public static boolean isInrange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
