package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num3015 {
    static long N, res;
    static Stack<long[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stol(br.readLine());

        for(int i=0; i<N; i++){
            long input = stol(br.readLine());
            // 0 = 높이, 1 = 개수
            long[] now = new long[]{input, 1};
            long[] top;

            // 스택에 담겨 있을 필요 없는 값들 제거하며 값 증가
            while(!stack.empty() && stack.peek()[0] <= now[0]){
                top = stack.pop();
                res += top[1];

                // 키가 같을 경우 같은 키를 가진사람과 모두 쌍을 지을 수 있음
                if(top[0] == input){
                    now[1] += top[1];
                }
            }

            // 값이 있으면 현재 값과 매칭 가능
            if(!stack.empty()) {
                res++;
            }

            stack.push(now);
        }

        System.out.println(res);

    }

    public static long stol(String s){
        return Long.parseLong(s);
    }
}
