package 유형별문제.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class num25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] firstLine = br.readLine().split(" ");
        String[] input = br.readLine().split(" ");
        Integer[] numArr = new Integer[input.length];

        int N = stoi(firstLine[0]);
        int K = stoi(firstLine[1]);

        for(int i=0; i<input.length; i++ ){
            numArr[i] = stoi(input[i]);
        }

        Arrays.sort(numArr, Collections.reverseOrder());

        System.out.println(numArr[K-1]);


    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
