
import java.util.*;
import java.io.*;

// 불안한 무빙워크
public class samsung2020_2_1_1 {
    static Rail rail;
    static String[] actions = {"move_rail", "move_person", "add_person"};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int k = stoi(st.nextToken());

        rail = new Rail(n, k);

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n * 2; i++) {
            int curSafeSize = stoi(st.nextToken());

            rail.addLineSize(i, curSafeSize);
        }

        while(true) {
            rail.addCnt();

            for(String action : actions) {
                rail.run(action);

                if(rail.checkFinish()) break;
            }

            if(rail.finish) break;
        }

        System.out.println(rail.experimentCnt);
    }

    public static class Rail {
        int lineSize; // n
        int k; // k
        int outIdx; // 내리는 indx
        int[] line; // line 안정성 저장
        boolean[] persons; // person 위치 저6장
        int experimentCnt; // 실험 횟수 저장
        boolean finish; // 종료 여부
        int deadLineCnt; // 안정성 0 개

        Rail(int size, int k){
            this.lineSize = size * 2;
            this.k = k;
            this.outIdx = size - 1;
            this.line = new int[this.lineSize];
            this.persons = new boolean[this.lineSize];
            this.experimentCnt = 0;
            this.finish = false;
            this.deadLineCnt = 0;
        }

        public void addCnt() {
            this.experimentCnt += 1;
        }

        public boolean checkFinish() {
            // 1. n번 칸 위치에 사람이 위치하면 즉시 내린다.
            if(this.persons[outIdx]) {
                this.persons[outIdx] = false;
            }

            // 2. 안정성이 0인칸이 k개 이상이면 과정 종료
            if(this.k <= this.deadLineCnt) {
                this.finish = true;
                return true;
            }

            return false;
        }

        public void railRotate() {
            // 레일 안정성 이동
            int temp = this.line[lineSize - 1];
            for(int i=this.lineSize - 1; i > 0; i--) {
                this.line[i] = this.line[i - 1];
            }
            this.line[0] = temp;

            // person 이동
            boolean tempPerson = this.persons[this.lineSize - 1];
            for(int i=this.lineSize - 1; i > 0; i--) {
                this.persons[i] = this.persons[i - 1];
            }
            this.persons[0] = tempPerson;
        }

        public void personRotate() {
            // 2. 한칸 이동 (안정성 -1)
            for(int i=this.lineSize / 2 - 1; i > 0; i--) {
                // 현재 칸의 안정성이 0인 경우 pass
                if(this.line[i] == 0) continue;

                // 현재 칸에 사람 있으면 pass
                if(this.persons[i]) continue;

                // 이전 칸에 사람이 없으면 pass
                if(!this.persons[i - 1]) continue;

                this.persons[i] = this.persons[i - 1];
                this.persons[i - 1] = false;
                this.line[i] -= 1;

                if(this.line[i] == 0) this.deadLineCnt += 1;
            }
        }

        public void run(String action) {
            if(action.equals("move_rail")) {
                this.railRotate();
            }
            else if(action.equals("move_person")) {
                this.personRotate();
            }
            else if(action.equals("add_person")) {
                this.addPerson();
            }
        }

        public void addPerson() {
            // 3. 1번칸에 사람이 없고 안정성이 0이 아니면 한명 더 올림 (안정성 -1)
            if(this.line[0] != 0 && this.persons[0] == false) {
                // 사람 추가
                this.persons[0] = true;
                // 안정성 감소
                this.line[0] -= 1;

                if(this.line[0] == 0) this.deadLineCnt += 1;
            }
        }

        public void addLineSize(int idx, int value) {
            this.line[idx] = value;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
