package save;

import java.util.PriorityQueue;

public class zsolution3 {
    static PriorityQueue<Document> pq = new PriorityQueue<>();
    static int[][] list;
    static int n, time;

    static class solution {
        public int[] solution(int[][] data) {
            n = data.length;
            int[] answer = new int[n];

            list = data;
            pq.add(new Document(list[0][0], list[0][1], list[0][2]));


            int answerIdx = 0;
            int listIdx = 1;
            while (!pq.isEmpty()) {
                Document cur = pq.poll();
                int curPage = cur.pageNum;

                while(curPage != 0) {
                    curPage--;
                    time++;
                }

                answer[answerIdx] = cur.n;
                answerIdx++;

                if (listIdx < n) {
                    while (listIdx < n && time >= list[listIdx][1]) {
                        pq.add(new Document(list[listIdx][0], list[listIdx][1], list[listIdx][2]));
                        listIdx++;
                    }
                }

                if(pq.isEmpty() && listIdx < n) {
                    pq.add(new Document(list[listIdx][0], list[listIdx][1], list[listIdx][2]));
                    time = list[listIdx][1];
                    listIdx++;
                }
            }

            return answer;
        }
    }

    static class Document implements Comparable<Document> {
        int n, requestTime, pageNum;

        Document(int n, int requestTime, int pageNum) {
            this.n = n;
            this.requestTime = requestTime;
            this.pageNum = pageNum;
        }

        @Override
        public int compareTo(Document o) {
            if (this.pageNum == o.pageNum) {
                return this.n - o.n;
            }

            return this.pageNum - o.pageNum;
        }
    }

    public static void main(String[] args) {
        zsolution3.solution a = new zsolution3.solution();

//        System.out.println(a.solution(new int[][]{{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}}).toString());
//        System.out.println(a.solution(new int[][]{{1, 0, 3}, {2, 1, 3}, {3, 3, 2}, {4, 9, 1}, {5, 10, 2}}).toString());
        System.out.println(a.solution(new int[][]{{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 18, 6}, {5, 25, 5}}).toString());
    }
}
