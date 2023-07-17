package kit;

import java.util.*;

public class bbb {
    static ArrayList<ArrayList<Integer>> adj;
    static int LIMIT, newFriendCnt = 0, answer = 0;
    static HashSet<Integer> checkedFriend = new HashSet();
    static HashSet<Integer> visited = new HashSet();

    public int solution(int[][] relationships, int target, int limit) {
        LIMIT = limit;

        adj = new ArrayList<>();
        for(int i=0; i < 101; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] relationship : relationships) {
            adj.get(relationship[0]).add(relationship[1]);
            adj.get(relationship[1]).add(relationship[0]);
        }

        checkedFriend.add(target);
        Queue<Integer> q = new LinkedList<Integer>();
        for(int friend : adj.get(target)) {
            answer += 5;
            q.add(friend);
            checkedFriend.add(friend);
        }

        int depth = 1;

        while(!q.isEmpty()){
            int size = q.size();

            if(depth >= limit) break;

            for(int i=0; i<size; i++){
                int cur = q.poll();

                for(int next : adj.get(cur)) {

                    if(!checkedFriend.contains(next)) {
                        q.add(next);
                        checkedFriend.add(next);
                        newFriendCnt += 1;
                        answer += 10;
                    }
                }
            }

            depth += 1;
        }


        return newFriendCnt + answer;
    }


    public static void main(String[] args) {
        bbb sol = new bbb();

        int item = sol.solution(new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 1, 100);
        System.out.println(item);
    }

}
