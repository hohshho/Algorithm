package 유형별문제.save;

import 유형별문제.구현.num21608;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class zSolutionz2 {
    static class Solution {
        public int[] solution(int[][] data) {
            Printer printer = new Printer();

            printer.addWorkList(data);

            printer.run();

            return printer.getCompleteWorkList();
        }

        static class Printer {
            LinkedList<Document> workList;
            int workTime;
            Queue<Document> taskQueue;
            LinkedList<Integer> completeWorkList;

            Printer() {
                workTime = Integer.MAX_VALUE;
                workList = new LinkedList<>();
                completeWorkList = new LinkedList<>();
                taskQueue = new PriorityQueue<Document>();
            }

            public void addWorkList(int[][] works){
                for(int[] work : works){
                    workList.add(new Document(work[0], work[1], work[2]));
                    // start time 계산
                    workTime = Math.min(workTime, work[1]);
                }
            }

            public void run() {
                while(!workList.isEmpty() || !taskQueue.isEmpty()) {
                    System.out.println(123);
                    // 1. 현재 시간보다 낮은 작업 모두 workQueue에 추가
                    int minTime = Integer.MAX_VALUE;
                    for(int i = workList.size() - 1; i >= 0; i--){
                        Document cur = workList.get(i);

                        minTime = Math.min(minTime, cur.startTime);
                        if(workTime >= cur.startTime){
                            taskQueue.add(cur);
                            workList.remove(i);
                        }
                    }

                    // 2. 인쇄
                    Document print = taskQueue.poll();
                    // TODO: pass처리
                    if(print == null) {
                        workTime = minTime;
//                        workTime++;
                        continue;
                    }
                    completeWorkList.add(print.index);
                    workTime += print.page;
                }
            }

            public int[] getCompleteWorkList() {
                int[] list = new int[completeWorkList.size()];
                for(int i = 0; i < completeWorkList.size(); i++) {
                    list[i] = completeWorkList.get(i);
                }

                return list;
            }
        }

        static class Document implements Comparable<Document> {
            int index, startTime, page;
            Document(int index, int startTime, int page){
                this.index = index;
                this.startTime = startTime;
                this.page = page;
            }

            @Override
            public int compareTo(Document o) {
                if(this.page != o.page) {
                    return this.page - o.page;
                }
                return this.index - o.index;
            }
        }
    }

    public static void main(String[] args) {
        Solution a = new Solution();

        int[] answer = a.solution(new int[][]{{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 100, 2}});
//        int[] answer = a.solution(new int[][]{{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 5}});

        for(int item : answer){
            System.out.println(item);
        }
    }
}
