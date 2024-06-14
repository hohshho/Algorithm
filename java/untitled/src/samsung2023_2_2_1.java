import java.util.*;

import java.io.*;

// 16:40분
public class samsung2023_2_2_1 {
	// 게임판 크기, 턴 수, 산타 수, 루돌프 힘, 산타 힘
	static int N, M, P, C, D;
	// 좌, 하, 우, 상
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] scores;
	static Santa[] santas;
	static Rudolph rudolph;
	static int deathCnt = 0;
	static int[][] map;

	public static void main(String[] args) throws IOException {
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
		rudolph = new Rudolph(stoi(st.nextToken()) - 1, stoi(st.nextToken()) - 1);
		map[rudolph.y][rudolph.x] = -1;

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());

			int n = stoi(st.nextToken());
			int y = stoi(st.nextToken()) - 1;
			int x = stoi(st.nextToken()) - 1;

			santas[n] = new Santa(x, y);
			map[y][x] = n;
		}

		for (int turn = 1; turn <= M; turn++) {

			// 1. 루돌프 이동
			moveRudolph(turn);

			// 2. 산타 턴
			for (int i = 1; i <= P; i++) {
				moveSanta(i, turn);
				if (deathCnt == P)
					break;
			}

			// 3. 살아남은 산타 점수 add
			for (int i = 1; i <= P; i++) {
				if (santas[i].finish)
					continue;
				scores[i] += 1;
			}
		}

		for (int i = 1; i <= P; i++) {
			System.out.print(scores[i] + " ");
		}
	}

	static void moveRudolph(int turn) {
		// 1. 가까운 산타 탐색
		int minSantaIdx = getMinSantaIndex();

		// 1.2) 방향 탐색
		int tempDx = (santas[minSantaIdx].x - rudolph.x);
		int tempDy = (santas[minSantaIdx].y - rudolph.y);
		int luDx = tempDx > 0 ? 1 : tempDx == 0 ? 0 : -1;
		int luDy = tempDy > 0 ? 1 : tempDy == 0 ? 0 : -1;

		// 2. 이동
		// 2.1 이동 전에 초기화
		map[rudolph.y][rudolph.x] = 0;

		rudolph.x += luDx;
		rudolph.y += luDy;

		// 3. push
		if (map[rudolph.y][rudolph.x] != 0) {
			push(map[rudolph.y][rudolph.x], luDx, luDy, C, true, turn);
		}

		// map 갱신
		map[rudolph.y][rudolph.x] = -1;
	}

	static void moveSanta(int santaIndex, int turn) {
		// 벗어난 산타 pass
		if (santas[santaIndex].finish) return;

		// 기절 된 산타 pass
		if (santas[santaIndex].stun >= turn) return;

		// 방향 탐색
		int minIdx = -1;
		int minDistance = getDistance(santas[santaIndex].x, rudolph.x, santas[santaIndex].y, rudolph.y);
		for (int j = 0; j < 4; j++) {
			int nx = santas[santaIndex].x + dx[j];
			int ny = santas[santaIndex].y + dy[j];

			if (!isInrange(nx, ny))
				continue;

			// 산타 존재하면 pass
			if (map[ny][nx] > 0)
				continue;

			// 이동한게 더 작으면 갱신
			int curDistance = getDistance(nx, rudolph.x, ny, rudolph.y);
			if (minDistance >= curDistance) {
				minIdx = j;
				minDistance = curDistance;
			}
		}

		if (minIdx == -1) return;

		// 이동 전에 초기화
		map[santas[santaIndex].y][santas[santaIndex].x] = 0;

		// 이동
		santas[santaIndex].x += dx[minIdx];
		santas[santaIndex].y += dy[minIdx];

		// 이동 했는데 루돌프 충돌
		if (map[santas[santaIndex].y][santas[santaIndex].x] == -1) {
			push(santaIndex, -dx[minIdx], -dy[minIdx], D, true, turn);
			// 루돌프 다시 map에 체크
			map[rudolph.y][rudolph.x] = -1;

		} else {
			map[santas[santaIndex].y][santas[santaIndex].x] = santaIndex;
		}

	}

	static void push(int santaIdx, int pDx, int pDy, int pushCnt, boolean action, int turn) {
		// 1. 현재 맵 초기화
		map[santas[santaIdx].y][santas[santaIdx].x] = 0;

		int nx = santas[santaIdx].x + (pDx * pushCnt);
		int ny = santas[santaIdx].y + (pDy * pushCnt);

		// 2. 밀렸으니 push된 만큼 점수 획득, 스턴 (상호 작용이면 점수 획득 x)
		if (action) {
			scores[santaIdx] += pushCnt;
			santas[santaIdx].stun = turn + 1;
		}

		// 3. 산타 현재 값 갱신
		santas[santaIdx].x = nx;
		santas[santaIdx].y = ny;

		// 4. 다음 위치가 범위 밖인 경우
		if (!isInrange(nx, ny)) {
			// 4.1 죽은 표시 후 종료
			santas[santaIdx].finish = true;
			deathCnt += 1;
			return;
		}

		// 4. 만약 다음 자리에 산타가 있을 경우 push
		if (map[santas[santaIdx].y][santas[santaIdx].x] != 0) {
			push(map[santas[santaIdx].y][santas[santaIdx].x], pDx, pDy, 1, false, turn);
		}

		// 5. 이동한 위치에서 맵 표시
		map[santas[santaIdx].y][santas[santaIdx].x] = santaIdx;
	}

	static int getMinSantaIndex() {
		// 1.1) 가장 가까운 산타 탐색
		int minSantaIdx = 0;
		int minDistance = 0;
		for (int i = 1; i <= P; i++) {
			// 벗어난 산타 pass
			if (santas[i].finish)
				continue;

			int curDistance = getDistance(rudolph.x, santas[i].x, rudolph.y, santas[i].y);

			if (minSantaIdx == 0) {
				minSantaIdx = i;
				minDistance = curDistance;
				continue;
			}

			// 기존 산타의 거리보다 작으면
			if (minDistance > curDistance) {
				minSantaIdx = i;
				minDistance = curDistance;
			} else if (minDistance == curDistance) {
				// 거리 같으면 y좌표 위치에 따라
				if (santas[minSantaIdx].y < santas[i].y) {
					minSantaIdx = i;
					minDistance = curDistance;
				}
				// 그래도 같으면 x좌표 위치에 따라
				else if (santas[minSantaIdx].y == santas[i].y && santas[minSantaIdx].x > santas[i].x) {
					minSantaIdx = i;
					minDistance = curDistance;
				}
			}
		}

		return minSantaIdx;
	}

	static int getDistance(int x1, int x2, int y1, int y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}

	static boolean isInrange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	static class Santa {
		int x, y, stun;
		boolean finish;

		Santa(int x, int y) {
			this.x = x;
			this.y = y;
			this.stun = 0;
			this.finish = false;
		}
	}

	static class Rudolph {
		int x, y;

		Rudolph(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
