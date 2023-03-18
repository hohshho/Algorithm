package 유형별문제.save;

import java.util.*;

public class gsolution2 {

    public int[] solution(int N, int[] coffee_times) {
        Machine machine = new Machine(N);

        machine.addCoffeeTimes(coffee_times);

        machine.run();

        return machine.getCompleteWorkList();
    }

    static class Machine {
        LinkedList<Coffee> coffeeTimeList;
        int taskQueueSize;
        LinkedList<Coffee> taskQueue;
        // task queue에 담긴 coffee가 얼마나 흘렀는지
        HashMap<Integer, Integer> map;
        LinkedList<Integer> completeWorkList;

        Machine(int N) {
            coffeeTimeList = new LinkedList<>();
            completeWorkList = new LinkedList<>();
            taskQueue = new LinkedList<>();
            taskQueueSize = N;
            map = new HashMap<>();
        }

        public void addCoffeeTimes(int[] coffee_times) {
            for (int i = 0; i < coffee_times.length; i++) {
                coffeeTimeList.add(new Coffee(i + 1, coffee_times[i]));
            }
        }

        public void run() {
            while (!coffeeTimeList.isEmpty() || !taskQueue.isEmpty()) {
                // 1. taskQueue가 비었으면 빈 만큼 커피 추가
                if (!coffeeTimeList.isEmpty()) {
                    for (int i = taskQueue.size(); i < taskQueueSize; i++) {
                        Coffee cur = coffeeTimeList.getFirst();

                        taskQueue.add(cur);
                        coffeeTimeList.remove(0);
                        map.put(cur.index, 0);
                    }
                }

                // 2. 다음 검사 할 시간 계산
                int minTime = Integer.MAX_VALUE;
                Iterator<Coffee> itr = taskQueue.iterator();

                while (itr.hasNext()) {
                    Coffee cur = itr.next();

                    minTime = Math.min(cur.time - map.get(cur.index), minTime);
                }

                // 3. 시간 처리
                for (int i = 0; i < taskQueue.size(); i++) {
                    Coffee cur = taskQueue.get(i);
                    int time = map.get(cur.index) + minTime;
                    map.remove(cur.index);

                    map.put(cur.index, time);
                }

                // 4. 커피 완성 확인 후 완성 리스트에 추가
                int deleteCnt = 0;
                for (int i = 0; i <= taskQueue.size() - 1; i++) {
                    Coffee cur = taskQueue.get(i - deleteCnt);
                    // Queue에 담긴 후 완성시간 만큼 시간이 흘렀나 검사
                    if (cur.time > map.get(cur.index)) {
                        continue;
                    }

                    // 완성 리스트 추가
                    completeWorkList.add(cur.index);

                    // queue에서 제거
                    taskQueue.remove(i);
                    map.remove(cur.index);
                    deleteCnt += 1;
                }
            }
        }

        public int[] getCompleteWorkList() {
            int[] list = new int[completeWorkList.size()];
            for (int i = 0; i < completeWorkList.size(); i++) {
                list[i] = completeWorkList.get(i);
            }

            return list;
        }
    }

    static class Coffee implements Comparable<Coffee> {
        int index, time;

        Coffee(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Coffee o) {
            if (this.time != o.time) {
                return this.time - o.time;
            }
            return this.index - o.index;
        }
    }

    public static void main(String[] args) {
        gsolution2 a = new gsolution2();
        for (int n : a.solution(3, new int[]{4, 2, 2, 5, 3})) {
            System.out.println(n);
        }
    }
}
