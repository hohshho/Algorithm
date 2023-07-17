package kit;

import java.util.*;

public class aaa {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    static LinkedHashSet<String> set = new LinkedHashSet();

    public int solution(String s, int N) {
        if(s.equals("")) return -1;

        String[] arr = s.split("");

        for(String item : arr){
            int intItem = stoi(item);

            if(set.contains(item) || N < intItem) {
                LinkedList<String> removeList = new LinkedList();

                for(String part : set) {
                    removeList.add(part);

                    if(part.equals(item)) break;
                }

                for(String part : removeList){
                    set.remove(part);
                }
            }

            if(N >= intItem && N > 0) set.add(item);

            if(set.size() == N) {
                String cur = "";
                String removeItem = "";

                for(String part : set){
                    if(removeItem.equals("")) removeItem = part;
                    cur += part;
                }
                pq.add(stoi(cur));
                if(set.size() > 0) set.remove(removeItem);
            }
        }

        return pq.isEmpty() ? -1 : pq.peek();
    }

    public int stoi(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) {
        aaa sol = new aaa();

        int item = sol.solution("313253123", 1);
        System.out.println(item);
    }
}
