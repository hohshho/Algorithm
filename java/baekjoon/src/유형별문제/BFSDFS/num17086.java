package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num17086 {
    static int N, M, map[][], result = 0;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        N = stoi(input[0]);
        M = stoi(input[1]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(line[j]) == 1 ? -1 : 0;
            }
        }

        for(int i =0; i<N; i++ ){
            for(int j=0; j<M; j++){
                if(map[i][j] == -1) continue;
                bfs(i, j);
            }
        }

        System.out.println(result);

    }

    static void bfs(int x, int y){
        visited = new boolean[N][M];
        q = new LinkedList<int[]>();
        q.add(new int[] {x, y, 0});

        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<8; i++){
                int curX = cur[0] + dx[i];
                int curY = cur[1] + dy[i];
                int distance = cur[2];

                if(!isRange(curX, curY)) continue;
                if(visited[curX][curY]) continue;

                // 종료 조건 (상어 만나면 루프 종료)
                if(map[curX][curY] == -1) {
                    result = Math.max(result, distance + 1);
                    return;
                }

                visited[curX][curY] = true;
                q.add(new int[]{curX, curY, distance + 1});
            }
        }
    }

    static boolean isRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
