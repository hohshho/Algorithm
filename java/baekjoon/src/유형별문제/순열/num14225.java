package 유형별문제.순열;

import java.io.*;
import java.util.*;

public class num14225 {
    static int n;
    static int[] s;
    static boolean[] checkList = new boolean[2000001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i < n; i++){
            recursive(i, s[i]);
        }

        for(int i=1; i < checkList.length; i++){
            if(!checkList[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    private static void recursive(int idx, int num){
        checkList[num] = true;
        for(int i=idx+1; i < n; i++){
            recursive(i, num + s[i]);
        }
    }
}
