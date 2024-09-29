package 유형별문제.스택큐덱;

import java.io.*;
import java.util.*;

public class num12789 {
    static int start = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int personCnt = stoi(br.readLine());

        Queue<Integer> line = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<personCnt; i++){
            line.add(stoi(st.nextToken()));
        }

        while(true){
            // 종료 조건 1. line에 남는 것이 없고, stack의 peek값과 다른경우
            if(line.isEmpty() && !stack.isEmpty() &&stack.peek() != start) {
                System.out.println("Sad");
                return;
            }
            // 종료 조건 3. 끝까지 끝난 경우
            if(start == personCnt) {
                System.out.println("Nice");
                return;
            }

            // line에 다음 숫자가 있는 경우
            if(!line.isEmpty() && line.peek() == start) {
                start += 1;
                line.poll();
                continue;
            }

            // stack에 다음 숫자가 있는 경우
            if(!stack.isEmpty() && stack.peek() == start) {
                start += 1;
                stack.pop();
                continue;
            }

            // 그 외 경우 스택에 푸시
            stack.push(line.poll());
        }


    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
