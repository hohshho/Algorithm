package kit;

import java.util.*;

class completeSearch_피로도 {
    static int K, max, answer = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        K = k;
        max = dungeons.length;
        visited = new boolean[max];

        permutation(0, new int[max], dungeons);

        return answer;
    }

    public static void permutation(int cnt, int[] selected, int[][] dungeons) {
        if(cnt == max) {

            int piro = K;
            int res = 0;

            for(int i=0; i<max; i++){
                int[] dungeon = dungeons[selected[i]];
                int minPiro = dungeon[0];
                int removePiro = dungeon[1];

                if(piro < minPiro) continue;

                piro -= removePiro;
                res += 1;
            }

            answer = Math.max(res, answer);

            return;
        }

        for(int i=0; i<max; i++){
            if(visited[i]) continue;

            visited[i] = true;
            selected[cnt] = i;
            permutation(cnt + 1, selected, dungeons);
            visited[i] = false;
        }
    }
}