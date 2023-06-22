package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x,y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class num14502 {

    static int N, M, res;
    static int map[][], testMap[][];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = stoi(stk.nextToken());
        M = stoi(stk.nextToken());

        map = new int[N][M];
        testMap = new int[N][M];
        q = new LinkedList<>();

        for(int i=0; i<N; i++){
            String[] inputData = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = stoi(inputData[j]);
            }
        }

        makeWall(0);

        System.out.println(res);

    }

    // 벽 생성
    public static void makeWall(int depth){
        if(depth == 3){
            insertTestMap();
            spreadVirus();
            res = Math.max(countSafe(), res);
            return;
        }

        for(int i = 0; i<N; i++){
           for(int j = 0; j<M; j++){
               if(map[i][j] == 0) {
                   map[i][j] = 1;
                   makeWall(depth + 1);
                   map[i][j] = 0;
               }
           }
        }
    }

    // 퍼질 수 있는 바이러스 표기
    public static void spreadVirus(){
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(checkMap(nx, ny)){
                    if(testMap[nx][ny] == 0){
                        testMap[nx][ny] = 2;
                        q.offer(new Point(nx, ny));
                    }
                }

            }
        }
    }

    // map check
    public static boolean checkMap(int x, int y){
        return x >= 0 && y>=0 && x<N && y<M;
    }

    // 안전지대 개수 반환
    public static int countSafe(){
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(testMap[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    // test map 생성
    public static void insertTestMap(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                testMap[i][j] = map[i][j];
                if(testMap[i][j] == 2){
                    q.offer(new Point(i, j));
                }
            }
        }
    }

    public static int stoi(String data) {
        return Integer.parseInt(data);
    }
}
