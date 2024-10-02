package 유형별문제.그리디;

import java.io.*;
import java.util.*;

public class num11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = stoi(st.nextToken());
        }

        Arrays.sort(arr);
        int sum = arr[0];
        for(int i=1; i<N; i++){
            arr[i] = arr[i] + arr[i - 1];
            sum += arr[i];
        }

        System.out.println(sum);

    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
