package pccp;
import java.util.*;

public class 보물지도 {
    class Solution {
        int N, M;
        // 출발 지점 (0, m - 1), 도착 지점 (n - 1, 0)
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        boolean[][] map;
        boolean[][][] visited;

        // 가로, 세로, 구멍
        public int solution(int n, int m, int[][] holes) {
            int answer = 0;
            N = n;
            M = m;

            map = new boolean[m][n];
            visited = new boolean[2][m][n];

            for(int[] hole : holes) {
                int x = hole[0] - 1;
                int y = m - hole[1];
                map[y][x] = true;
            }

            PriorityQueue<Point> q = new PriorityQueue<>();
            q.add(new Point(0, m - 1, 0, 0));
            visited[0][m - 1][0] = true;
            visited[1][m - 1][0] = true;

            while(!q.isEmpty()) {
                Point cur = q.poll();

                if(cur.x == n - 1 && cur.y == 0) {
                    answer = cur.cnt;
                    break;
                }

                if(cur.jump == 0) {
                    for(int i=0; i < 4; i++){
                        int nx = cur.x + dx[i] + dx[i];
                        int ny = cur.y + dy[i] + dy[i];

                        if(!isInrance(nx, ny)) continue;

                        if(visited[1][ny][nx]) continue;

                        if(map[ny][nx]) continue;

                        q.add(new Point(nx, ny, cur.cnt + 1, 1));
                        visited[1][ny][nx] = true;
                    }
                }

                for(int i=0; i < 4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(!isInrance(nx, ny)) continue;

                    if(visited[cur.jump][ny][nx]) continue;

                    if(map[ny][nx]) continue;

                    q.add(new Point(nx, ny, cur.cnt + 1, cur.jump));
                    visited[cur.jump][ny][nx] = true;
                }
            }

            return answer == 0 ? -1 : answer;
        }

        public boolean isInrance(int x, int y){
            return x >= 0 && y >= 0 && x < N && y < M;
        }

        static class Point implements Comparable<Point>{
            int x, y, cnt, jump;

            Point(int x, int y, int cnt, int jump){
                this.x = x;
                this.y = y;
                this.cnt = cnt;
                this.jump = jump;
            }

            @Override
            public int compareTo(Point p){
                return this.cnt - p.cnt;
            }
        }
    }
}
