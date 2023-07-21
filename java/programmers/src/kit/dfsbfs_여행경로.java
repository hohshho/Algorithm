package kit;

import java.util.*;

public class dfsbfs_여행경로 {
    static LinkedList<String> departmentList = new LinkedList<>();
    static HashMap<String, Integer> mapCnt = new HashMap<>();
    static HashMap<String, Integer> siMap = new HashMap<>();
    static HashMap<Integer, String> isMap = new HashMap<>();
    static LinkedList<LinkedList<Integer>> adj = new LinkedList<>();
    static String min = "";
    static String[] result;
    static int ticketSize;

    public String[] solution(String[][] tickets) {
        ticketSize = tickets.length;

        // 1. 도착지 전체 리스트 생성(ICN 제외)
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];

            String start = ticket[0];
            String end = ticket[1];

            if (!departmentList.contains(start) && !start.equals("ICN")) departmentList.add(start);
            if (!departmentList.contains(end) && !end.equals("ICN")) departmentList.add(end);
        }

        // 2. ICN을 첫번째로 한 map 생성
        Collections.sort(departmentList);
        departmentList.addFirst("ICN");

        int idx = 1;
        for (String department : departmentList) {
            siMap.put(department, idx);
            isMap.put(idx, department);
            idx += 1;
        }

        // 3. adj 생성
        for (int i = 0; i <= departmentList.size(); i++) {
            adj.add(new LinkedList<>());
        }

        for (String[] tickect : tickets) {
            int start = siMap.get(tickect[0]);
            int end = siMap.get(tickect[1]);

            adj.get(start).add(end);
            String hash = start+"|"+end;
            if(!mapCnt.containsKey(hash)) mapCnt.put(hash, 1);
            else {
                int cnt = mapCnt.get(hash);
                mapCnt.put(hash, cnt + 1);
            }
            Collections.sort(adj.get(start));
        }

        // 4. dfs로 탐색
        search(1, 0, new HashMap<String, Integer>(), "");

        String[] data = min.split("/");
        result = new String[data.length + 1];
        result[0] = isMap.get(Integer.parseInt(data[0].split(",")[0]));

        for (int i = 0; i < data.length; i++) {
            String[] se = data[i].split(",");
            result[i + 1] = isMap.get(Integer.parseInt(se[1]));
        }
        return result;
    }

    public static void search(int start, int cnt, HashMap<String, Integer> visited, String answer) {
        if (cnt == ticketSize) {
            if (min.equals("")) min = answer;
            else min = min.compareTo(answer) > 0 ? answer : min;
            return;
        }

        for (int next : adj.get(start)) {
            int index = 1;
            String hash = start + "|" + next;
            if (visited.containsKey(hash) && visited.get(hash) == mapCnt.get(hash)) continue;

            answer += String.valueOf(start) + "," + String.valueOf(next) + "/";
            if(!visited.containsKey(hash)) visited.put(hash, 1);
            else {
                int curCnt = visited.get(hash);
                visited.put(hash, curCnt + 1);
            }

            search(next, cnt + 1, visited, answer);
            if(visited.get(hash) == 1) visited.remove(hash);
            else {
                int curCnt = visited.get(hash);
                visited.put(hash, curCnt - 1);
            }
            answer = answer.substring(0, answer.length() - (String.valueOf(start) + "," + String.valueOf(next) + "/").length());
        }

    }

    public static void main(String[] args) {
        dfsbfs_여행경로 sol = new dfsbfs_여행경로();

//        String[] items = sol.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
//        String[] items = sol.solution(new String[][]{{"ICN", "JFK"}, {"ICN", "JFK"}, {"JFK", "ICN"}, {"ICN", "AAD"}, {"JFK", "ICN"}});
        String[] items = sol.solution(new String[][]{{"ICN","A"},{"A","B"},{"A","C"},{"B","A"},{"C","A"}});
//        String[] items = sol.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});

        for (String item : items) {
            System.out.println(item);
        }
    }
}
