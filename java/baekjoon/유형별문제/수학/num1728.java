package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class num1728 {
    static int N;
    static LinkedList<Integer> arr;
    static LinkedList<HashSet<Integer>> v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr.add(stoi(input[0]));
        }


//        for (int i = 0; i <= N; i++) {
//            String[] beadList = br.readLine().split(" ");
//
//            for (int j = 0; j < beadList.length; j++) {
//                beads[i][j] = stoi(beadList[j]);
//            }
//        }

    }
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
