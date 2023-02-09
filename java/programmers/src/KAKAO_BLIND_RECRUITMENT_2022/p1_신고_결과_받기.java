import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashSet<String> stopIdList = new HashSet<>();

        for(String id : id_list){
            countMap.put(id, 0);
            reportMap.put(id, new HashSet<>());
        }

        for(String item : report) {
            String[] itemArr = item.split(" ");
            String id = itemArr[0];
            String reportId = itemArr[1];
            boolean flag = false;

            HashSet<String> reportList = reportMap.get(id);

            if(reportList.contains(reportId)) {
                flag = true;
            }

            if(flag) continue;

            reportList.add(reportId);

            int count = countMap.get(reportId) + 1;
            countMap.put(reportId, count);
            if(count >= k) {
                stopIdList.add(reportId);
            }
        }

        for(int i=0; i<id_list.length; i++) {
            HashSet<String> reportList = reportMap.get(id_list[i]);
            int cnt = 0;

            for(String reportId : reportList) {
                if(stopIdList.contains(reportId)){
                    cnt++;
                }
            }

            answer[i] = cnt;
        }

        return answer;
    }
}

public class p1_신고_결과_받기 {
    public static void main(String[] args){
        Solution sol = new Solution();

        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        for(int item : sol.solution(id_list, report, k)) {
            System.out.println(item);
        };
    }
}
