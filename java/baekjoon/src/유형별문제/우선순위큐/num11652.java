package 유형별문제.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class num11652 {
    static HashMap<Long, Long> map = new HashMap<>();
    static long maxCnt = 0, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long N = stol(br.readLine());

        for(int i=0; i<N; i++){
            long num = stol(br.readLine());
            long curCnt = 1;

            if(map.containsKey(num)){
                curCnt = map.get(num) + 1;
                map.remove(num);
            }

            map.put(num, curCnt);

            if(curCnt > maxCnt || (curCnt == maxCnt && max > num)) {
                maxCnt = curCnt;
                max = num;
            }
        }

        System.out.println(max);
    }

    public static long stol(String s){
        return Long.parseLong(s);
    }
}
