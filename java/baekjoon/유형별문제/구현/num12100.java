package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num12100 {
    static int N, res;
    static int[][] map;
    static String[] commands = {"left", "right", "up", "down"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(input[j]);
            }
        }

        dfs(0);

        System.out.println(res);
    }

    public static void dfs(int depth) {
        if (depth == 5) {
            findResult();
            return;
        }

        int copy[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            run(commands[i]);
            dfs(depth + 1);

            for (int j = 0; j < N; j++) {
                map[j] = copy[j].clone();
            }
        }
    }

    public static void run(String command) {
        if (command.equals("left")) {
            for(int i=0; i<N; i++) {
                int insertIdx = 0;
                int value = 0;
                for (int searchIdx = 0; searchIdx < N; searchIdx++) {
                    if(map[i][searchIdx] == 0) continue;

                    if (value == map[i][searchIdx]) {
                        map[i][insertIdx - 1] = value * 2;
                        map[i][searchIdx] = 0;
                        value = 0;
                    }else {
                        value = map[i][searchIdx];
                        map[i][searchIdx] = 0;
                        map[i][insertIdx] = value;
                        insertIdx++;
                    }
                }
            }

        } else if (command.equals("right")) {
            for(int i=0; i<N; i++) {
                int insertIdx = N - 1;
                int value = 0;

                for (int searchIdx = N - 1; searchIdx >= 0; searchIdx--) {
                    if(map[i][searchIdx] == 0) continue;

                    if (value == map[i][searchIdx]) {
                        map[i][insertIdx + 1] = value * 2;
                        map[i][searchIdx] = 0;
                        value = 0;
                    }else {
                        value = map[i][searchIdx];
                        map[i][searchIdx] = 0;
                        map[i][insertIdx] = value;
                        insertIdx--;
                    }
                }
            }

        } else if (command.equals("up")) {
            for(int i=0; i<N; i++) {
                int insertIdx = 0;
                int value = 0;
                for (int searchIdx = 0; searchIdx < N; searchIdx++) {
                    if(map[searchIdx][i] == 0) continue;

                    if (value == map[searchIdx][i]) {
                        map[insertIdx - 1][i] = value * 2;
                        map[searchIdx][i] = 0;
                        value = 0;
                    }else {
                        value = map[searchIdx][i];
                        map[searchIdx][i] = 0;
                        map[insertIdx][i] = value;
                        insertIdx++;
                    }
                }
            }
        } else if (command.equals("down")) {
            for(int i=0; i<N; i++) {
                int insertIdx = N - 1;
                int value = 0;
                for (int searchIdx = N - 1; searchIdx >= 0; searchIdx--) {
                    if(map[searchIdx][i] == 0) continue;

                    if (value == map[searchIdx][i]) {
                        map[insertIdx + 1][i] = value * 2;
                        map[searchIdx][i] = 0;
                        value = 0;
                    }else {
                        value = map[searchIdx][i];
                        map[searchIdx][i] = 0;
                        map[insertIdx][i] = value;
                        insertIdx--;
                    }
                }
            }
        }
    }

    public static void findResult() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                res = Math.max(res, map[i][j]);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
