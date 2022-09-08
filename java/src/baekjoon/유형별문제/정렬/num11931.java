package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class num11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = stoi(br.readLine());
        Integer[] arr = new Integer[N];

        for(int i =0; i < N ; i++){
            arr[i] = stoi(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int item : arr){
            sb.append(item).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
