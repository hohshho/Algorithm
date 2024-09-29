package 유형별문제.정렬;

import java.io.*;
import java.util.*;

public class num1302 {
    static HashMap<String, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());

        for(int i=0; i<N; i++){
            String input = br.readLine();

            if(map.containsKey(input)) {
                map.get(input).addCnt();
            }
            else{
                map.put(input, new Node(input));
            }
        }

        LinkedList<Node> list = new LinkedList<>();
        for(String key : map.keySet()) {
            list.add(new Node(key, map.get(key).cnt));
        }
        Collections.sort(list);

        System.out.println(list.get(0).name);

    }

    public static class Node implements Comparable<Node> {
        int cnt;
        String name;

        Node(String name){
            this.name = name;
            this.cnt = 1;
        }

        Node(String name, int cnt){
            this.name = name;
            this.cnt = cnt;
        }

        void addCnt() {
            this.cnt += 1;
        }

        @Override
        public int compareTo(Node t){
            if(t.cnt != this.cnt) return t.cnt - this.cnt;
            // string비교는 compareTo
            return this.name.compareTo(t.name);
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
