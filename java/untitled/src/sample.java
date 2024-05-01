import java.io.*;
import java.util.*;

// 02:02 ~
public class sample {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
//
        int L = stoi(st.nextToken());
        int Q = stoi(st.nextToken());

        Line line = new Line(L);
        Queue<Command> q = new LinkedList<Command>();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int action = stoi(st.nextToken());
            int curT = stoi(st.nextToken());

            Command command = new Command(action, curT);

            if (action == 100) {
                command.setLineIdx(stoi(st.nextToken()));
                command.setName(st.nextToken());
            } else if (action == 200) {
                command.setLineIdx(stoi(st.nextToken()));
                command.setName(st.nextToken());
                command.setCnt(stoi(st.nextToken()));
            }
            q.add(command);
        }

        StringBuilder sb = new StringBuilder();
        int curTime = 0;
        while (!q.isEmpty()) {

            // 초밥 회전
            line.rotate();

            // 현재 자리 사용자 밥 먹기 (밥 먹었는데 다 먹었으면 나간처리)
            line.eat();

            curTime += 1;
            if (q.peek().time != curTime) {
                continue;
            }

            Command curCommand = q.poll();

            // 초밥 만들기
            if (curCommand.action == 100) {
                // 라인에 초밥 추가
                line.addSushi(curCommand.lineIdx, curCommand.name);
            }
            // 손님 입장
            else if (curCommand.action == 200) {
                // 손님 추가
                line.addPerson(curCommand.lineIdx, curCommand.cnt, curCommand.name);

                // 현재 자리 사용자 밥먹기 (밥 먹었는데 다 먹었으면 나간처리)
                line.eat();
            }
            // 사진 촬영
            else if (curCommand.action == 300) {
                line.takePicture(sb);
            }
        }

        System.out.println(sb.toString());
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static class Line {
        int personCnt, sushiCnt, lineCnt;
        Person[] personLine;
        ArrayList<HashMap<String, Integer>> sushiLine;

        Line(int lineCnt) {
            this.personCnt = 0;
            this.sushiCnt = 0;
            this.lineCnt = lineCnt;
            this.personLine = new Person[lineCnt];
            this.sushiLine = new ArrayList<HashMap<String, Integer>>();

            for(int i=0; i<lineCnt; i++) {
                sushiLine.add(new HashMap<String, Integer>());
            }
        }

        void rotate() {
            ArrayList<HashMap<String, Integer>> newSushiLine = new ArrayList<HashMap<String, Integer>>();

            for (int i = 0; i < this.lineCnt; i++) {
                if(this.sushiLine.get((i + 1) % this.lineCnt).isEmpty()) continue;

                newSushiLine.add(this.sushiLine.get((i + 1) % this.lineCnt));
            }

            this.sushiLine = newSushiLine;
        }

        void addSushi(int idx, String name) {
            this.sushiCnt += 1;

            int curSuishiCnt = !sushiLine.get(idx).containsKey(name) ? 0 : sushiLine.get(idx).get(name);

            sushiLine.get(idx).put(name, curSuishiCnt + 1);
        }

        void addPerson(int idx, int cnt, String name) {
            this.personCnt += 1;
            this.personLine[idx] = new Person(cnt, name);
        }

        void eat() {
            for (int i = 0; i < lineCnt; i++) {
                if (personLine == null)
                    continue;

                Person curPerson = personLine[i];

                if(curPerson == null) continue;

                HashMap<String, Integer> curPlace = sushiLine.get(i);

                // 스시 처리
                if (curPlace.containsKey(curPerson.name) && curPlace.get(curPerson.name) > 0) {
                    // 스시 처리
                    sushiLine.get(i).put(curPerson.name, curPlace.get(curPerson.name) - 1);
                    this.sushiCnt -= 1;

                    // person처리
                    personLine[i].cnt -= 1;

                    // 다 먹은 사용자 제거
                    if (personLine[i].cnt == 0) {
                        personLine[i] = null;
                        this.personCnt -= 1;
                    }
                }
            }
        }

        void takePicture(StringBuilder sb) {
            sb.append(this.personCnt + " " + this.sushiCnt + "\n");
        }
    }

    static class Command {
        int action, time, lineIdx, cnt;
        String name;

        Command(int action, int time) {
            this.action = action;
            this.time = time;
        }

        void setName(String name) {
            this.name = name;
        }

        void setLineIdx(int lineIdx) {
            this.lineIdx = lineIdx;
        }

        void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }

    public static class Person {
        int cnt;
        String name;

        Person(int cnt, String name) {
            this.cnt = cnt;
            this.name = name;
        }
    }
}

