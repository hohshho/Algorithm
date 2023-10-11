package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class num17837 {
    static int finish = -1;
    // 동, 서, 북, 남
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static int N, K;
    static Board[][] map;
    static LinkedList<Unit> unitList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new Board[N][N];

        for (int i = 0; i < N; i++) { // 열
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) { // 행
                int color = stoi(st.nextToken());
                map[i][j] = new Board(color);
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int y = stoi(st.nextToken()) - 1;
            int x = stoi(st.nextToken()) - 1;
            int direction = stoi(st.nextToken());

            map[y][x].unitIndexList.add(i);
            unitList.add(new Unit(direction, x, y));
        }

        for (int i = 1; i <= 1000; i++) {
            run(i);
            if (finish != -1) break;
        }

        System.out.println(finish);
    }

    public static void run(int turn) {
        for (int unitIndex = 0; unitIndex < K; unitIndex++) {
            // 1. 현재 유닛 상태
            Unit cur = unitList.get(unitIndex);

            // 2. get move data (움직일 수 있는지 여부, 다음 좌표)
            UnitMoveData curMoveData = cur.getMoveData();

            // 3. move data에 움직일 수 없다는 결과 값 있으면 pass
            if (!curMoveData.isMove) continue;

            // 4. 옮겨야 하는 리스트 계산 (지도 상에선 삭제)
            LinkedList<Integer> moveList = map[cur.y][cur.x].getMoveList(unitIndex);

            // 5. 리스트 전부 이동 (지도 상에 추가)
            map[curMoveData.ny][curMoveData.nx].addList(moveList);

            // 6. unitList 좌표 갱신
            for(int changeUnitIndex : moveList) {
                unitList.get(changeUnitIndex).x = curMoveData.nx;
                unitList.get(changeUnitIndex).y = curMoveData.ny;
            }

            if(map[curMoveData.ny][curMoveData.nx].unitIndexList.size() == K) {
                finish = turn;
                return;
            }
        }

    }

    static class Unit {
        int direction, x, y;

        Unit(int direction, int x, int y) {
            this.direction = direction;
            this.x = x;
            this.y = y;
        }

        UnitMoveData getMoveData() {
            // 1. 이동 시 범위 벗어나는 경우 -> 방향 전환
            if (!checkMapArea(x + dx[this.direction], y + dy[this.direction])) nextDirection();

            // 2. 다음 칸이 파란색 이동 불가
            if (map[y + dy[this.direction]][x + dx[this.direction]].color == 2) return new UnitMoveData(false);

            // 정상 처리
            return new UnitMoveData(true, x + dx[this.direction], y + dy[this.direction]);
        }

        void nextDirection() {
            if (this.direction == 0) {
                this.direction = 1;
            } else if (this.direction == 1) {
                this.direction = 0;
            } else if (this.direction == 2) {
                this.direction = 3;
            } else if (this.direction == 3) {
                this.direction = 2;
            }
        }
    }

    public static boolean checkMapArea(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }

    static class UnitMoveData {
        boolean isMove;
        int nx, ny;

        UnitMoveData(boolean isMove) {
            this.isMove = isMove;
        }

        UnitMoveData(boolean isMove, int nx, int ny) {
            this.isMove = isMove;
            this.nx = nx;
            this.ny = ny;
        }
    }

    static class Board {
        int color; // 0 : white, 1 : red, 2 : blue
        LinkedList<Integer> unitIndexList;

        Board(int color) {
            this.color = color;
            if (color != 2) {
                this.unitIndexList = new LinkedList<>();
            }
        }

        LinkedList getMoveList(int moveUnitIndex) {
            LinkedList list = new LinkedList();

            // 움직여야 하는 list 생성
            boolean flag = false;
            int deleteCnt = 0;
            for (int i = this.unitIndexList.size() - 1; i >= 0; i--) {
                if (this.unitIndexList.get(i) == moveUnitIndex) flag = true;

                if (!flag) continue;

                deleteCnt += 1;
                list.add(this.unitIndexList.get(i));
            }

            // 움직이는 말들 삭제
            while (deleteCnt-- > 0) this.unitIndexList.removeLast();

            return list;
        }

        void addList(LinkedList<Integer> list) {
            // 빨강일 경우 순서 뒤집는다.
            if (this.color == 1) Collections.sort(list, Collections.reverseOrder());

            for (int next : list) {
                this.unitIndexList.add(next);
            }
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
