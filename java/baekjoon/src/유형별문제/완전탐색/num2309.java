package 유형별문제.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num2309 {
    static int[] list = new int[9];
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i < 9; i++){
            list[i] = stoi(br.readLine());
            sum += list[i];
        }

        Arrays.sort(list);
        int A, B;
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                A = list[i];
                B = list[j];

                if(sum - A - B == 100) {
                    for(int k=0; k<9; k++){
                        if(k == i || k == j) continue;
                        System.out.println(list[k]);
                    }
                    return;
                }
            }
        }

    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
