package pccp;
import java.util.*;

public class 석유시추 {


    class Solution {
        // key : 석유 덩어리 index / value : 석유 덩어리 크기
        HashMap<Integer, Integer> energeMap = new HashMap<>();
        // land에 속한 석유 index
        int[][] indexMap;
        boolean[][] visited;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int xLen, yLen;

        public int solution(int[][] land) {
            yLen = land.length;
            xLen = land[0].length;

            makeIndexMap(land);

            return getResult();
        }

        public void makeIndexMap(int[][] land) {
            visited = new boolean[yLen][xLen];
            indexMap = new int[yLen][xLen];
            int index = 0;
            int size = 0;
            // y
            for(int i=0; i<yLen; i++){
                // x
                for(int j=0; j<xLen; j++){
                    // 방문 했거나 석유가 없는 경우 pass
                    if(land[i][j] == 0 || visited[i][j]) continue;

                    Queue<int[]> q = new LinkedList<>();
                    visited[i][j] = true;
                    q.add(new int[]{j, i});
                    size = 1;
                    index += 1;
                    indexMap[i][j] = index;

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();

                        int x = cur[0];
                        int y = cur[1];

                        for(int k=0; k<4; k++){
                            int nx = dx[k] + x;
                            int ny = dy[k] + y;

                            if(!checkMap(nx, ny)) continue;

                            if(visited[ny][nx] || land[ny][nx] == 0) continue;

                            indexMap[ny][nx] = index;
                            size += 1;
                            q.add(new int[] {nx, ny});
                            visited[ny][nx] = true;
                        }
                    }

                    energeMap.put(index, size);
                }
            }

        }

        public int getResult() {
            int result = 0;
            for(int i=0; i<xLen; i++){
                HashSet<Integer> saveIndexSet = new HashSet<>();
                int temp = 0;

                for(int j=0; j<yLen; j++){
                    if(indexMap[j][i] == 0) continue;
                    saveIndexSet.add(indexMap[j][i]);
                }

                for(int index : saveIndexSet){
                    temp += energeMap.get(index);
                }

                result = Math.max(temp, result);
            }

            return result;
        }

        public boolean checkMap(int x, int y){
            return x >= 0 && y >= 0 && x < xLen && y < yLen;
        }
    }
}
