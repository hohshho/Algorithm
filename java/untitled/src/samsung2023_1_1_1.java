import java.util.*;
import java.io.*;

// 15:40분 시작 / 16:22분 종료
public class samsung2023_1_1_1 {
	// 행(y), 열(x)
	static int N, M, K;
	// 우/하/좌/상
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] bdx = {0, 0, -1, -1, -1, 1, 1, 1};
	static int[] bdy = {-1, 1, 0, -1, 1, 0, -1, 1};
	// map에 po index저장 용
	static int[][] mapPoIdx;
	static int[][] damageMap;

	// 포탑 관리
	static LinkedList<Po> livePo;

	// 살아있는 포탑 개수 카운
	static int liveCnt = 0;

	// 영향 받은 포탑 저장
	static boolean[][] attackedPo;

	// 레이저 공격 시 이전 index 저장
	static int[][] backPoIdx;

	// 레이저 공격 방문 여부 저장
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());

		mapPoIdx = new int[N][M];
		livePo = new LinkedList<Po>();
		damageMap = new int[N][M];

		int idx = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				int damage = stoi(st.nextToken());
				damageMap[i][j] = damage;

				if (damage != 0) {
					// 포탑 추가
					livePo.add(new Po(idx, j, i, damage, 0, false));
					mapPoIdx[i][j] = idx;
					liveCnt += 1;
					idx += 1;
				}
			}
		}

		for (int i = 1; i <= K; i++) {
			// 0. 전처리
			attackedPo = new boolean[N][M];
			visited = new boolean[N][M];
			backPoIdx = new int[N][M];
			mapPoIdx = new int[N][M];


			// 살아있는 포탑이 1개 이하라면 바로 종료합니다.
			if (liveCnt <= 1)
				break;
			
			// 살아있는 포탑 저장 갱신
			LinkedList<Po> newPoList = new LinkedList<Po>();
			
			liveCnt = 0;
			int newIdx = 1;
			// 죽은 처리
			newPoList.add(new Po(0, 0, 0, -1, 0, false)); // 의미 없는 데이터
			Collections.sort(livePo);
			for (Po item : livePo) {
				if (item.death) continue;
				
				if (damageMap[item.y][item.x] == 0) continue;
				
				if (item.n == 0) continue;
				
				newPoList.add(new Po(newIdx, item.x, item.y, item.damage, item.attackTurn, item.death));
				mapPoIdx[item.y][item.x] = newIdx;
				liveCnt += 1;
				newIdx += 1;
			}
			livePo = newPoList;

			// 1. 대상 지정
			// 1.1 공격자 선정 (데미지 갱신, turn갱신)
			Po start = livePo.get(1);

			// 1.2 피해자 선정
			Po finish = livePo.get(livePo.size() - 1);
			
			livePo.get(1).addDamage(N + M);
			livePo.get(1).setAttackTurn(i);

			// 2. 공격
			// 공격 중간 (포탑 부서짐 처리)
			// 2.1 레이저 공격
			if (!lazerAttack(i, start, finish)) {
				// 2.2 불가능 하면 포탄 공격
				bombAttack(i, start, finish);
			}
		
			// 3. 포탑 정비
			for (Po po : livePo) {
				if (po.death) continue;
				
				if (po.n == 0) continue;

				if (attackedPo[po.y][po.x]) continue;

				livePo.get(po.n).addDamage(1);
			}
		}

		int result = 0;
		for (Po po : livePo) {
			if (po.death) continue;
			
			if (damageMap[po.y][po.x] == 0) continue;
			
			if (po.n == 0) continue;

			result = Math.max(result, po.damage);
		}

		System.out.println(result);
	}

	static void bombAttack(int turn, Po start, Po finish) {

		// 가장 강한 포탑 공격 처리
		livePo.get(finish.n).minusDamage(start.damage);

		// 공격 진
		for (int dir = 0; dir < 8; dir++) {
			int nx = (finish.x + bdx[dir] + M) % M;
			int ny = (finish.y + bdy[dir] + N) % N;
			
			if(start.x == nx && start.y == ny) continue;
			
			if(damageMap[ny][nx] == 0) continue;

			// pow / 2만큼의 공격
			livePo.get(mapPoIdx[ny][nx]).minusDamage(start.damage / 2);
		}
	}

	static boolean lazerAttack(int turn, Po start, Po finish) {
		// 공격자는 해당 공격 영향x
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(start.n);
		visited[start.y][start.x] = true;

		boolean canAttack = false;
		// 공격 가능한지 확인
		while (!q.isEmpty()) {
			int curIdx = q.poll();

			// 도착하면 공격
			if (finish.y == livePo.get(curIdx).y && finish.x == livePo.get(curIdx).x) {
				canAttack = true;
				break;
			}

			// 다음 순서 탐색
			for (int i = 0; i < 4; i++) {
				int nx = (livePo.get(curIdx).x + dx[i] + M) % M;
				int ny = (livePo.get(curIdx).y + dy[i] + N) % N;

				// 방문 했으면 패스
				if (visited[ny][nx])
					continue;

				// 죽었으면 pass
				if (damageMap[ny][nx] == 0)
					continue;

				q.add(mapPoIdx[ny][nx]);
				visited[ny][nx] = true;
				backPoIdx[ny][nx] = curIdx;
			}
		}

		// 공격 가능하면 어택
		if (canAttack) {
			// finish부터 시작 -> start로 이동하며 공격
			int curIdx = finish.n;
			int cx = finish.x;
			int cy = finish.y;
			livePo.get(mapPoIdx[cy][cx]).minusDamage(livePo.get(start.n).damage);

			// 다음 순서로 갱신
			curIdx = backPoIdx[cy][cx];
			cx = livePo.get(curIdx).x;
			cy = livePo.get(curIdx).y;

			while (curIdx != start.n) {
				livePo.get(curIdx).minusDamage(livePo.get(start.n).damage / 2);
				curIdx = backPoIdx[cy][cx];
				cx = livePo.get(curIdx).x;
				cy = livePo.get(curIdx).y;
			}
		}
		
		return canAttack;
	}

	static class Po implements Comparable<Po> {
		int n, x, y, damage, attackTurn;
		boolean death;

		Po(int n, int x, int y, int damage, int turn, boolean death) {
			this.n = n;
			this.x = x;
			this.y = y;
			this.damage = damage;
			this.attackTurn = turn;
			this.death = death;
		}
		
		void setN(int n) {
			this.n = n;
		}

		void setAttackTurn(int turn) {
			this.attackTurn = turn;
		}

		void setDeath(boolean death) {
			this.death = death;
		}

		void minusDamage(int damage) {
			this.damage -= damage;
			if (this.damage <= 0) {
				this.damage = 0;
				this.death = true;
				liveCnt -= 1;
			}

			attackedPo[this.y][this.x] = true;
			damageMap[this.y][this.x] = this.damage;
		}

		// damage를 더해주고, damage Map을 갱신한다.
		void addDamage(int damage) {
			this.damage += damage;
			damageMap[this.y][this.x] = this.damage;
			attackedPo[this.y][this.x] = true;
		}

		// 공격력 가장 높음, 공격한지 가장 오래된 포탑 - 행열, 합 작은, 열값 작은
		public int compareTo(Po p) {
			if (this.damage != p.damage) return this.damage - p.damage;
			if (this.attackTurn != p.attackTurn) return p.attackTurn - this.attackTurn;
			if (this.x + this.y != p.x + p.y) return (p.x + p.y) - (this.x + this.y);
			return p.x - this.x;
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
