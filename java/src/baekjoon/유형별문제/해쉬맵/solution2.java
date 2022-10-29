package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class solution2 {
    static LinkedList<Integer>[] stacks;
    static int center = -1;

    public int[] solution(int n, int[][] queries) {
        ArrayList<Integer> answer = new ArrayList<>();

        stacks = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            stacks[i] = new LinkedList<>();
        }

        for (int[] item : queries) {
            int stackIndex = item[0] - 1;
            int num = item[1];
            String command = num > 0 ? "push" : "pop";

            if (command.equals("push")) {
                push(stackIndex, num);
            } else {
                answer.add(pop(stackIndex, n));
            }
        }

        int[] res = new int[answer.size()];

        for(int i=0; i < answer.size(); i++) {
            res[i] = answer.get(i);
        }

        for(int item : res) {
            System.out.println(item);
        }
        return res;
    }

    public static int pop(int stackIndex, int n) {
        int result = -1;

        // 1. 값이 없을 경우
        if (center == -1)
            return result;

        // 2. 중앙값 삭제 여부 확인
        if (stacks[stackIndex].get(stacks[stackIndex].size() - 1) != center) {
            // 2.1) 중앙값 삭제 아니면 바로 리턴
            return stacks[stackIndex].removeLast();
        }

        // 2.2) 중앙 값 삭제시 처리
        int searchIndex = stackIndex;
        result = center;

        // 값이 존재하는 스택 확인
        int nextCenter = -1;
        for (int i = 0; i < n; i++) {
            searchIndex = searchIndex == n - 1 ? 0 : searchIndex+1;

            // 값이 하나만 있을 경우 pass
            if (stacks[searchIndex].size() < 2) {
                continue;
            }

            nextCenter = stacks[searchIndex].get(1);
            // 나머지 스택 처리
            if (nextCenter != -1) {
                for (int j = 0; j < n; j++) {
                    if (j == searchIndex) {
                        stacks[j].poll(); // 맨 앞 값 제거
                        continue;
                    }

                    stacks[j].poll(); // 맨 앞 값 제거
                    stacks[j].addFirst(nextCenter); // 맨 앞 값 추가
                }
            }

            center = nextCenter;
            return result;
        }

        if(nextCenter == -1) {
            for(int i=0; i<n; i++) {
                stacks[i] = new LinkedList<>();
            }
        }

        center = nextCenter;
        return result;
    }

    public static void push(int stackIndex, int num) {
        // 비었을 경우
        if (center == -1) {
            for (LinkedList<Integer> stack : stacks) {
                stack.push(num);
            }

            center = num;
            return;
        }

        // 삽입
        stacks[stackIndex].addLast(num);
    }

    public static void main(String[] args) {
        solution2 a = new solution2();
//        System.out.println(a.solution(6, new int[][]{{1, 3}, {1, 2}, {3, 6}, {3, -1}, {4, 5}, {2, -1}, {3, -1}, {1, -1}}));
        System.out.println(a.solution(4, new int[][]{{3, 1}, {3, 2}, {1, -1}, {2, 1}, {1, -1}, {1, -1}}));
    }
}
