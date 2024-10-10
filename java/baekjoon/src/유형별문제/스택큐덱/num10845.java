package 유형별문제.스택큐덱;

import java.util.*;
import java.io.*;

public class num10845 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = stoi(br.readLine());

        int item = 0;
        Queue<Integer> q = new LinkedList<>();
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String action = st.nextToken();

            if(action.equals("push")) {
                item = stoi(st.nextToken());
                q.offer(item);
            }
            else if(action.equals("front")) {
                if(q.isEmpty()) sb.append("-1\n");
                else sb.append(q.peek()).append("\n");
            }
            else if(action.equals("back")) {
                if(q.isEmpty()) sb.append("-1\n");
                else sb.append(item).append("\n");
            }
            else if(action.equals("size")) {
                sb.append(q.size()).append("\n");
            }
            else if(action.equals("empty")) {
                if(q.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            }
            else if(action.equals("pop")) {
                if(q.isEmpty()) sb.append("-1\n");
                else sb.append(q.poll() + "\n");

            }

        }

        System.out.println(sb.toString());
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
