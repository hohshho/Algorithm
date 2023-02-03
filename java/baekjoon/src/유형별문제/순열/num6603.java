package 유형별문제.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num6603 {
    static StringBuilder sb = new StringBuilder();
    static int k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] inputData = br.readLine().split(" ");

            k = stoi(inputData[0]);

            if(k == 0) {
                break;
            }

            arr = new int[k];

            for(int i=1; i<=k; i++){
                arr[i-1] = stoi(inputData[i]);
            }

            combination(0, 0, new int[6]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void combination(int idx, int cnt, int[] selected){
        if(cnt == 6) {
            for(int i=0; i<selected.length; i++){
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx; i < k; i++){
            selected[cnt] = arr[i];
            combination(i + 1, cnt + 1, selected);
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
