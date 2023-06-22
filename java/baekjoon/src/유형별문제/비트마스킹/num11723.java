package 유형별문제.비트마스킹;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class num11723 {
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        M = stoi(br.readLine());

        int cache = 0;
        while(M-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if(command.equals("add")) {
                // 합집합
                int num = stoi(st.nextToken());
                cache |= (1 << num);
            }
            else if(command.equals("remove")) {
                // 차집합
                int num = stoi(st.nextToken());
                cache &= ~(1 << num);
            }
            else if(command.equals("check")) {
                int num = stoi(st.nextToken());
                sb.append((cache & (1 << num)) == (1 << num) ? "1\n" : "0\n");
            }
            else if(command.equals("toggle")) {
                int num = stoi(st.nextToken());
                cache ^= (1 << num);
            }
            else if(command.equals("all")) {
                cache = (1 << 21) - 1;
            }
            else if(command.equals("empty")) {
                cache = 0;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
