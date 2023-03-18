package 유형별문제.구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num14890 {
    static int[][] map;
    static int N, L;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NL = br.readLine().split(" ");

        N = stoi(NL[0]);
        L = stoi(NL[1]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(input[j]);
            }
        }

        checkRow();
        checkColumn();

        System.out.println(res);
    }

    static void checkColumn() {
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            int sameCount = 1;
            int pre = 0;
            int cur = 0;
            int downCnt = 0;

            for (int j = 1; j < N; j++) {
                cur = map[j][i];

                pre = map[j - 1][i];


                if (cur == pre) {
                    sameCount += 1;
                    if(downCnt != 0) downCnt--;
                }

                // 2. 높아지는 경사 놓을 때
                if (pre < cur) {
                    // 동일한 길 L개 이하일 경우 실패
                    if (sameCount < L) flag = false;

                    if (cur - pre != 1) flag = false;

                    if(downCnt != 0) flag = false;

                    sameCount = 1;
                }

                // 3. 낮아지는 경사 놓을 때 -> 다음 l - 1개만큼 똑같은지 검사
                if (pre > cur) {
                    int cnt = 1;
                    int next;

                    // 높이가 2이상 불가능
                    if (pre - cur != 1) {
                        flag = false;
                        break;
                    }

                    if (L > 1) {
                        while (true) {
                            // 3.1) 범위 초과 검사
                            if (cnt + j >= N) {
                                flag = false;
                                break;
                            }

                            next = map[j+cnt][i];

                            if (cur != next) {
                                flag = false;
                                break;
                            }

                            if (cnt == L - 1) break;

                            cnt += 1;
                        }

                        j = j + L - 1;
                        downCnt = L;

                        if(j == N - 1) {
                            if(cur != map[j][i]) flag = false;
                        }
                    }
                    if (L == 1) {
                        if(j + 1 < N) {
                            if (map[j + 1][i] > cur) flag = false;
                        }
                    }
                }

                if (flag == false) break;

                // 3. 이전 값이랑 같은 값 일직선 pass
                pre = cur;
            }

            if (flag) res += 1;
        }
    }

    static void checkRow() {
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            int sameCount = 1;
            int pre = 0;
            int cur = 0;
            int downCnt = 0;

            for (int j = 1; j < N; j++) {
                cur = map[i][j];

                pre = map[i][j - 1];

                if (cur == pre) {
                    sameCount += 1;
                    if(downCnt != 0) downCnt--;
                }
                // 처음에 경사로 바로 놓을 수 있음

                // 2. 높아지는 경사 놓을 때
                if (pre < cur) {
                    // 동일한 길 L개 이하일 경우 실패
                    if (sameCount < L) flag = false;

                    if (cur - pre != 1) flag = false;

                    if(downCnt != 0) flag = false;

                    sameCount = 1;
                }

                // 3. 낮아지는 경사 놓을 때 -> 다음 l - 1개만큼 똑같은지 검사
                if (pre > cur) {
                    int cnt = 1;
                    int next;

                    // 높이가 2이상 불가능
                    if (pre - cur != 1) {
                        flag = false;
                        break;
                    }

                    if (L > 1) {
                        while (true) {
                            // 3.1) 범위 초과 검사
                            if (cnt + j >= N) {
                                flag = false;
                                break;
                            }

                            next = map[i][j + cnt];

                            if (cur != next) {
                                flag = false;
                                break;
                            }

                            if (cnt == L - 1) break;

                            cnt += 1;
                        }

                        j = j + L - 1;
                        downCnt = L;

                        if(j == N - 1) {
                            if(cur != map[i][j]) flag = false;
                        }
                    }
                    if (L == 1) {
                        if(j + 1 < N) {
                            if (map[i][j + 1] > cur) flag = false;
                        }
                    }
                }

                if (flag == false) break;
            }

            if (flag) res += 1;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
