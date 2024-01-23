import java.util.*;

public class num130 {
    static class Solution {
        static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        static int ySize, xSize;

        public void solve(char[][] board) {
            ySize = board.length;
            xSize = board[0].length;

            run(board);

            for (char[] line : board) {
                for (char part : line) {
                    System.out.print(part);
                }
                System.out.println();
            }
        }

        public static void run(char[][] board) {


            for (int i = 0; i < xSize; i++) { // x
                for (int j = 0; j < ySize; j++) { // y
                    int x = i, y = j;

                    if (!checkMap(x, y, board)) continue;

                    flip(x, y, board);
                }
            }
        }

        public static void flip(int x, int y, char[][] board) {
            boolean[][] flipVisited = new boolean[ySize][xSize];

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{x, y});
            flipVisited[y][x] = true;
            board[y][x] = 'X';

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int cx = cur[0], cy = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i], ny = cy + dy[i];

                    if (!checkMapArrange(nx, ny)) continue;

                    if (board[ny][nx] == 'X' || flipVisited[ny][nx]) continue;

                    board[ny][nx] = 'X';
                    flipVisited[ny][nx] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        // TODO: 이거 빨리 푸느라 bfs로 했는데 dfs로 수정해보자
        public static boolean checkMap(int x, int y, char[][] board) {
            if (board[y][x] != 'O') return false;

            boolean[][] visited = new boolean[board.length][board[0].length];

            if (checkBorderCheck(x, y)) return false;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{x, y});
            visited[y][x] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int cx = cur[0], cy = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i], ny = cy + dy[i];

                    if (!checkMapArrange(nx, ny)) continue;

                    if (visited[ny][nx]) continue;

                    if (board[ny][nx] == 'O') {
                        // 경계 체크
                        if (checkBorderCheck(nx, ny)) return false;

                        q.add(new int[]{nx, ny});
                        visited[ny][nx] = true;
                    }
                }
            }

            return true;
        }

        public static boolean checkBorderCheck(int x, int y) {
            return x == 0 || y == 0 || x + 1 == xSize || y + 1 == ySize;
        }

        public static boolean checkMapArrange(int x, int y) {
            return x >= 0 && y >= 0 && x < xSize && y < ySize;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solve(new char[][]{{'O', 'X', 'X', 'O', 'X'}, {'X', 'X', 'X', 'X', 'O'}, {'X', 'X', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}});
    }
}
