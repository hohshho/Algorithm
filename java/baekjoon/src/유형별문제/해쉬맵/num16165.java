package 유형별문제.해쉬맵;

import java.io.*;
import java.util.*;

public class num16165 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        HashMap<String, HashSet<String>> girlGroup = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            int count = stoi(br.readLine());

            HashSet<String> set = new HashSet<>();
            for (int j = 0; j < count; j++) {
                set.add(br.readLine());
            }

            girlGroup.put(key, set);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            int action = stoi(br.readLine());

            if (action == 0) {
                HashSet<String> members = girlGroup.get(input);
                LinkedList<String> list = new LinkedList();

                for(String member : members) {
                    list.add(member);
                }

                Collections.sort(list);

                for(String member : list){
                    System.out.println(member);
                }
                continue;
            }

            for (String key : girlGroup.keySet()) {
                HashSet<String> member = girlGroup.get(key);

                if(!member.contains(input)) continue;

                System.out.println(key);
            }
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
