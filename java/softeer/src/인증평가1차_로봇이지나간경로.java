import java.util.*;
import java.io.*;


public class 인증평가1차_로봇이지나간경로
{
    static int H, W, sx, sy, sdirection;
    static String[][] map;
    // 동, 남, 서, 북 / R -> + 1, L -> -1
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static HashSet<Integer> pointList = new HashSet<Integer>();
    static HashSet<Integer> visitedSet = new HashSet<Integer>();
    static String resPoint = "", resDirection = "", resAction = "";

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        H = stoi(st.nextToken());
        W = stoi(st.nextToken());

        map = new String[H][W];

        for(int i=0; i<H; i++){
            String[] input = br.readLine().split("");

            for(int j=0; j<W; j++){
                map[i][j] = input[j];

                if(input[j].equals(".")) continue;

                pointList.add(W * i + j);
            }
        }

        getRes();

        System.out.println(resPoint);
        System.out.println(resDirection);
        System.out.println(resAction);
    }

    public static void getRes(){
        for(int point : pointList){
            for(int i=0; i<4; i++){

                sx = point % W;
                sy = point / W;
                sdirection = i;

                visitedSet.add(sy * W + sx % W);
                search(sx, sy, sdirection, 1, "");
                visitedSet.remove(sy * W + sx % W);
            }
        }

    }

    public static void search(int x, int y, int direction, int cnt, String cmd){
        // 종료 조건 : 방문한 개수가 동일하게 생기면 탈출
        if(pointList.size() == cnt) {
            // 최초 값 추가
            if(resAction.equals("") || resAction.length() > cmd.length()) {
                resPoint = (sy + 1) + " " + (sx + 1);
                // 동 남 서 북
                if(sdirection == 0){
                    resDirection = ">";
                }
                else if(sdirection == 1) {
                    resDirection = "v";
                }
                else if(sdirection == 2) {
                    resDirection = "<";
                }
                else {
                    resDirection = "^";
                }

                resAction = cmd;
            }
            return;
        }

        // 로봇의 동작 방법 4가지
        // 1. 보는 방향으로 A
        // 2. L방향으로 회전 후 A
        // 3. R방향으로 회전 후 A
        // 4. R방향으로 2번 회전 후 A
        for (int i=0; i<4; i++ ){
            int ndirection = direction;
            String actionPart = "A";

            if(i == 1){
                ndirection = direction - 1 < 0 ? 3 : direction - 1;
                actionPart = "LA";
            }
            else if(i == 2) {
                ndirection = direction + 1 > 3 ? 0 : direction + 1;
                actionPart = "RA";
            }
            else if(i == 3) {
                ndirection = (direction + 2) % 4;
                actionPart = "RRA";
            }

            int ny1 = y+dy[ndirection], nx1=x+dx[ndirection];
            int ny2 = y+2*dy[ndirection], nx2=x+2*dx[ndirection];

            // 방문할 수 없으면 pass
            if(!checkGo(nx2, ny2)) continue;
            if(!map[ny1][nx1].equals("#")
                    || !map[ny2][nx2].equals("#")
                    || visitedSet.contains(ny1 * W + nx1 % W)
                    || visitedSet.contains(ny2 * W + nx2 % W)
            ) continue;

            // 방문 처리
            visitedSet.add(ny1 * W + nx1 % W);
            visitedSet.add(ny2 * W + nx2 % W);

            // 재귀
            search(nx2, ny2, ndirection, cnt + 2, cmd + actionPart);

            // 방문 처리 -
            visitedSet.remove(ny1 * W + nx1 % W);
            visitedSet.remove(ny2 * W + nx2 % W);
        }
    }

    public static boolean checkGo(int x, int y){
        return x >= 0 && y >= 0 && x < W && y < H;
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}

