package 유형별문제.해쉬맵;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/20920
public class num20920 {
    static HashMap<String, Node> map = new HashMap<>();
    static LinkedList<Node> list = new LinkedList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for(int i=0; i<N; i++){
            String input = br.readLine();

            if(input.length() < M) continue;

            // containsValue도 가능
            if(map.containsKey(input)){
                map.get(input).addCnt();
            }
            else{
                map.put(input, new Node(input));
            }
        }

        // map.entrySet(), map.keySet, map.values()
        for(String key : map.keySet()) {
            list.add(new Node(key, map.get(key).cnt));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(Node n : list){
            sb.append(n.word + "\n");
        }
        System.out.println(sb.toString());

    }

    static class Node implements Comparable<Node>{
        int cnt, len;
        String word;

        Node(String word) {
            this.cnt = 1;
            this.word = word;
            this.len = word.length();
        }
        Node(String word, int cnt){
            this.cnt = cnt;
            this.word = word;
            this.len = word.length();
        }

        void addCnt() {
            this.cnt += 1;
        }

        @Override
        public int compareTo(Node t) {
            // 1. 자주 나오는 단어
            if(this.cnt != t.cnt) return t.cnt - this.cnt;

            // 2. 단어의 길이
            if(this.len != t.len) return t.len - this.len;

            // 3. 알파벳 순
            return this.word.compareTo(t.word);
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
