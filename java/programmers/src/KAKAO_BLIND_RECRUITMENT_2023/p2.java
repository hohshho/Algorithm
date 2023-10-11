package KAKAO_BLIND_RECRUITMENT_2023;

public class p2 {
    static class Solution {
        // n : 일렬로 나열된 집의 수
        // cap : 트럭에 실을 수 있는 택배 상자 수
        // deliveries : 배달 할 재활용 택배 상자 개수
        // pickups : 수거할 빈 재활용 택배 상자 개수
        //
        // return : 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동거리
        //
        // 집 간 거리 1
        // 출발 지점 0
        // 접근 아이디어 : 일단 최단거리로는 구현x -> 정렬 조건이 뒤에 사건에 영향 받는 거 같음 -> dfs로 구현
        // 1. 처음 출발 시 택배에 물건 가득 실어 출발
        // 2.
        Long answer = Long.MAX_VALUE;
        int Caps;
        int N;
        int[] Deliveries, Pickups;
        int finish = 0;

        public long solution(int cap, int n, int[] deliveries, int[] pickups) {

            // 1. 전역변수 화 -> dfs시 넘겨줘야 하는 값이 많으면 메모리 터짐
            Caps = cap;
            N = n;
            Deliveries = new int[N + 1];
            Pickups = new int[N + 1];

            for (int i = 0; i < N; i++) {
                Deliveries[i + 1] = deliveries[i];
                Pickups[i + 1] = pickups[i];
                finish += 1;
            }

            dfs(0, cap, 0, 0, 0);

            return answer;
        }

        // 현재 위치, 현재 트럭에 담고있는 수, 배달/수거, 움직인 수, 동작 수행 수
        public void dfs(int curPosition, int curCap, int action, int move, int jobs) {
            if (jobs == finish) {
                move += curPosition; // 이건 필요한지 확인
                answer = Math.min(move, answer);

                return;
            }

            // 배달
            if (action == 0) {
                for (int i = 1; i <= N; i++) {
                    if(Deliveries[i] == 0) continue;

                    // 배달 완료 가능한 수 계산
                    Deliveries[i] =


                }
            }
            // 수거
            else {

            }
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long res = sol.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});

        System.out.println(res);
    }
}
