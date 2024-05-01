import java.util.*;
import java.io.*;

// 14:41분 시작 / 19:00분 종
public class samsung2022_2_1_1 {
	static int N, M, K;
	// 상, 우, 하, 좌
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static PriorityQueue<Gun>[][] gMap;
	static LinkedList<Player> pList = new LinkedList<Player>();
	static int[][] pMap;
	static int[] scores;
	static final int GO_FAIL = 1;
	static final int GO_WALK = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());

		gMap = new PriorityQueue[N][N];
		pMap = new int[N][N];
		scores = new int[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int power = stoi(st.nextToken());

				gMap[i][j] = new PriorityQueue<Gun>();

				if (power == 0)
					continue;

				gMap[i][j].add(new Gun(power));
			}
		}

		// 쓰레기 값
		pList.add(new Player(0, -1, -1, -1, -1));
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int y = stoi(st.nextToken()) - 1;
			int x = stoi(st.nextToken()) - 1;
			int d = stoi(st.nextToken());
			int s = stoi(st.nextToken());

			pList.add(new Player(i, x, y, d, s));
			pMap[y][x] = i;
		}

		for (int turn = 0; turn < K; turn++) {

			for (int cIdx = 1; cIdx <= M; cIdx++) {
				Player curPlayer = pList.get(cIdx);
				// 현재 칸 비워두기
				pMap[curPlayer.y][curPlayer.x] = 0;
				
				// 1. 플레이어 이동
				int nx = curPlayer.x + dx[curPlayer.direction];
				int ny = curPlayer.y + dy[curPlayer.direction];

				// 1.1 만약 격자 밖으로 이동하면 방향 전환(반대로)
				if (!isInrange(nx, ny)) {
					pList.get(cIdx).changeBackDirection();
					nx = curPlayer.x + dx[curPlayer.direction];
					ny = curPlayer.y + dy[curPlayer.direction];
				}

				// 1.2 상태 변경
				pList.get(cIdx).setXY(nx, ny);
				// 1.3 다음 로직 시작 전 갱신
				curPlayer = pList.get(cIdx);
				
				// 2. 이동 한 칸에 이동 후 플레이어가 없으면 총 변환
				if (pMap[ny][nx] == 0) {
					pList.get(cIdx).changeGun();
					// 맵 갱신
					pMap[ny][nx] = cIdx;
					continue;
				}

				// 3. 이동한 칸에 플레이어가 있으면 싸움 // map은 아직 변경된 상태가 아님
				Player nextPlayer = pList.get(pMap[ny][nx]);

				PriorityQueue<Player> fight = new PriorityQueue<Player>();
				fight.add(curPlayer);
				fight.add(nextPlayer);

				Player winner = fight.poll();
				Player loser = fight.poll();

				// 3.2 이긴 플레이어 score획득
				scores[winner.idx - 1] += (winner.getTotalPower() - loser.getTotalPower());

				// 3.3 진 유저 총 내려놓기
				pList.get(loser.idx).removeGun();

				// 3.4 진 유저 방향 탐색
				int nlx = 0, nly = 0;
				for (int i = 0; i < 4; i++) {
					nlx = nx + dx[loser.direction];
					nly = ny + dy[loser.direction];
					
					// 범위 밖이면 x
					if (!isInrange(nlx, nly)) {
						pList.get(loser.idx).rotateDirection();
						continue;
					}

					// 다른 플레이어 있으면x
					if (pMap[nly][nlx] != 0) {
						pList.get(loser.idx).rotateDirection();
						continue;
					}

					break;
				}
				
				// 3.5 진유저 이동, 이동해서 총 처리
				pList.get(loser.idx).setXY(nlx, nly);
				pMap[pList.get(loser.idx).y][pList.get(loser.idx).x] = loser.idx;
				pList.get(loser.idx).changeGun();
				
				// 3.6 현재 위치에 이긴사람 index표기
				pList.get(winner.idx).setXY(nx, ny);
				pMap[ny][nx] = winner.idx;
				pList.get(winner.idx).changeGun();
			}

		}

		for (int i = 0; i < M; i++) {
			System.out.print(scores[i] + " ");
		}
	}

	static class Gun implements Comparable<Gun> {
		int power;

		Gun(int power) {
			this.power = power;
		}

		void setPower(int power) {
			this.power = power;
		}

		@Override
		public int compareTo(Gun g) {
			return g.power - this.power;
		}
	}

	static class Player implements Comparable<Player> {
		int idx, x, y, power, direction;
		Gun gun;

		Player(int idx, int x, int y, int direction, int power) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.power = power;
			this.direction = direction;
		}

		void removeGun() {
			if(this.gun == null) return;
			
			gMap[this.y][this.x].add(new Gun(this.gun.power));
			this.gun = null;
		}

		// 상태 변화 (현재 가지고 있는 총, gun map에 표기 된 총)
		void changeGun() {
			// map에 건이 없을 경우 종료
			if (gMap[this.y][this.x].size() == 0)
				return;

			// 현재 가지고 있는 건이 없을 경우
			if (gun == null) {
				gun = new Gun(gMap[this.y][this.x].poll().power);
				return;
			}

			int mapMaxGunPower = gMap[this.y][this.x].poll().power;
			int curGunPower = this.gun.power;
			int minGunPower = Math.min(mapMaxGunPower, curGunPower);
			int maxGunPower = Math.max(mapMaxGunPower, curGunPower);

			// 현재 맵에 작은 총 추가
			gMap[this.y][this.x].add(new Gun(minGunPower));

			// 현재 플레이어 총 추가 
			this.gun = new Gun(maxGunPower);
		}

		void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int getTotalPower() {
			if (this.gun == null)
				return this.power;

			return this.power + this.gun.power;
		}

		void rotateDirection() {
			this.direction = this.direction + 1 == 4 ? 0 : this.direction + 1;
		}

		void changeBackDirection() {
//			this.direction = (this.direction + 2 + 4) % 4;
			this.direction = this.direction < 2 ? this.direction + 2 : this.direction - 2;
		}

		@Override
		public int compareTo(Player p) {
			if (p.getTotalPower() == this.getTotalPower())
				return p.power - this.power;
			return p.getTotalPower() - this.getTotalPower();
		}
	}

	public static boolean isInrange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}