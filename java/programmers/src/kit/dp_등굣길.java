package kit;

import java.util.*;

class dp_등굣길 {
    static int M, N, mod = 1000000007;
    static int[][] map, dist;
    static HashMap<Integer, HashSet<Integer>> puddleMap = new HashMap(); // key : y좌표, value : x좌표

    // m : x축 , n : y축
    public int solution(int m, int n, int[][] puddles) {
        M = m;
        N = n;
        int answer = 0;

        map = new int[n][m];
        dist = new int[n][m];

        for(int[] puddle : puddles) {
            if(!puddleMap.containsKey(puddle[1] - 1)) puddleMap.put(puddle[1] -1, new HashSet<>());

            puddleMap.get(puddle[1] -1).add(puddle[0] -1);
        }


        dist[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j == 0) continue;
                int sum = 0;

                if(checkMapArrangeAndPuddle(j - 1, i)){
                    sum += dist[i][j - 1] % mod;
                }

                if(checkMapArrangeAndPuddle(j, i - 1)){
                    sum += dist[i - 1][j] % mod;
                }

                dist[i][j] = sum;
            }
        }

        return dist[n-1][m-1] % mod;
    }

    public static boolean checkMapArrangeAndPuddle(int x, int y){
        if(x < 0 || y < 0 || x >= M || y >= N) return false;

        if(puddleMap.containsKey(y) && puddleMap.get(y).contains(x)) return false;

        return true;
    }
}