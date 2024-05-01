import java.util.*;
import java.io.*;

// 13:30분 시작 14:30분, 60분 / 14:40분 시작 16:00분 종료, 1시간 20분 80
public class samsung2023_2_1_1 {
	static int L, N, Q;

	// 상, 우, 하, 좌
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] initMap;
	static int[][] knightMap;
	static Knight[] knightList;
	static final int TRAP = 1;
	static final int WALL = 2;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = stoi(st.nextToken());
		N = stoi(st.nextToken());
		Q = stoi(st.nextToken());

		initMap = new int[L][L];
		knightMap = new int[L][L];
		// map
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < L; j++) {
				int inputValue = stoi(st.nextToken());

				if (inputValue == 0)
					continue;

				if (inputValue == TRAP) {
					initMap[i][j] = TRAP;
				} else if (inputValue == WALL) {
					initMap[i][j] = WALL;
				}
			}
		}

		knightList = new Knight[N + 1];

		// knight
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int y = stoi(st.nextToken()) - 1;
			int x = stoi(st.nextToken()) - 1;
			int h = stoi(st.nextToken());
			int w = stoi(st.nextToken());
			int k = stoi(st.nextToken());

			knightList[i] = new Knight(i, y, x, h, w, k);

			markKnightOnMap(i, i, false);
		}

		// command
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());

			int qKnightIdx = stoi(st.nextToken());
			int qDirection = stoi(st.nextToken());

			// 1. 사라진 기사 명령인지 검사
			if (knightList[qKnightIdx].finish)
				continue;

			// 2. 이동 가능한지 확인
			if (checkCommand(qKnightIdx, qDirection)) {
				// 2.1) 이동 가능하면 Push
				pushKnight(qKnightIdx, qDirection, false);
			}
		}
		
		for(int i=1; i<= N; i++) {
			if(knightList[i].finish) continue;
			
			result += knightList[i].defaultK - knightList[i].k;
		}

		System.out.println(result);
	}

	static void pushKnight(int qKnightIdx, int qDirection, boolean isNotFirst) {
		// 현재 나이트 상태
		Knight curKnight = knightList[qKnightIdx];

		// 현재 위치 0으로 map에 표기
		markKnightOnMap(qKnightIdx, 0, false);
		int nx = curKnight.x + dx[qDirection];
		int ny = curKnight.y + dy[qDirection];

		// 다음 위치 보는데 다른 나이트 있는 경우 다른 나이트 부터 push
		HashSet<Integer> anotherKnightIndexs = new HashSet<Integer>();
		for (int i = ny; i < ny + curKnight.h; i++) {

			for (int j = nx; j < nx + curKnight.w; j++) {
				if (knightMap[i][j] != qKnightIdx && knightMap[i][j] > 0) {
					anotherKnightIndexs.add(knightMap[i][j]);
				}
			}
		}

		if (!anotherKnightIndexs.isEmpty()) {
			for (int knightIndex : anotherKnightIndexs) {
				pushKnight(knightIndex, qDirection, true);
			}
		}

		// 현재 나이트 상태(기준점) 변경
		knightList[qKnightIdx].changePoint(qDirection);

		// 현재 나이트 맵에 표기
		markKnightOnMap(qKnightIdx, qKnightIdx, isNotFirst);
	}

	static boolean checkCommand(int knightIdx, int direction) {
		Knight curKnight = knightList[knightIdx];

		// 현재 위치 이상 없는지 확인
		HashSet<Integer> anotherKnightIdxList = new HashSet<Integer>();
		for (int i = curKnight.y; i < curKnight.y + curKnight.h; i++) {

			for (int j = curKnight.x; j < curKnight.x + curKnight.w; j++) {
				int nx = j + dx[direction];
				int ny = i + dy[direction];

				// 맵 범위 체크
				if (!isInrange(nx, ny))
					return false;

				// 벽이 있는지 체크
				if (initMap[ny][nx] == WALL)
					return false;

				// 현재 나이트 인덱스와 다른 나이트 존재하면 해당 index값 추가, 제거된 나이트는 검사 제거
				if (knightMap[ny][nx] != knightIdx && knightMap[ny][nx] != 0 && !knightList[knightIdx].finish) {
					anotherKnightIdxList.add(knightMap[ny][nx]);
				}
			}
		}

		// 다른 나이트 기존 존재하면 다른 나이트까지 검사
		if (!anotherKnightIdxList.isEmpty()) {
			for (int anotherKnightIdx : anotherKnightIdxList) {
				if (!checkCommand(anotherKnightIdx, direction))
					return false;
			}
		}

		return true;
	}

	/**
	 * value를 입력받아 해당 knight를 맵에 표시하는 함수
	 * 
	 * @param knightIdx
	 * @param value      : map에 표기할 값
	 * @param checkTramp : 해당 값이 true일 경우 이동 위치의 trap을 확인 후 체력 감소
	 */
	static void markKnightOnMap(int knightIdx, int value, boolean checkTrap) {
		Knight curKnight = knightList[knightIdx];

		int damage = 0;
		for (int i = curKnight.y; i < curKnight.y + curKnight.h; i++) {

			for (int j = curKnight.x; j < curKnight.x + curKnight.w; j++) {
				knightMap[i][j] = value;

				if (checkTrap && initMap[i][j] == TRAP) {
					damage += 1;
				}
			}
		}

		if (!checkTrap)
			return;

		// 만약 체력이 감소해서 제거되면 맵에서도 제거
		if (!curKnight.changeHealth(damage)) {
			for (int i = curKnight.y; i < curKnight.y + curKnight.h; i++) {

				for (int j = curKnight.x; j < curKnight.x + curKnight.w; j++) {
					knightMap[i][j] = 0;
				}
			}
		}
	}

	static class Knight {
		int n, x, y, h, w, k, defaultK;
		boolean finish;

		Knight(int n, int y, int x, int h, int w, int k) {
			this.n = n;
			this.x = x;
			this.y = y;
			this.h = h;
			this.w = w;
			this.k = k;
			this.defaultK = k;
			this.finish = false;
		}

		boolean changeHealth(int damage) {
			this.k -= damage;
			
			if (this.k < 1) {
				this.finish = true;
				return false;
			}
			
			return true;
		}

		void changePoint(int direction) {
			this.x = this.x + dx[direction];
			this.y = this.y + dy[direction];
		}
	}

	static boolean isInrange(int x, int y) {
		return x >= 0 && y >= 0 && x < L && y < L;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
