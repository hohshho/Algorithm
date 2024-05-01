import java.io.*;
import java.util.*;

public class samsung2023_2_2_2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
//
		int L = stoi(st.nextToken());
		int Q = stoi(st.nextToken());

		Line line = new Line(L);
		Queue<Command> q = new LinkedList<Command>();
		int finishTime = 0;

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
			
			if(i == Q - 1) {
				finishTime = curT;
			}
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
				line.eat();
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
		HashMap<Integer, HashMap<String, Integer>> sushiLine;

		Line(int lineCnt) {
			this.personCnt = 0;
			this.sushiCnt = 0;
			this.lineCnt = lineCnt;
			this.personLine = new Person[lineCnt];
			this.sushiLine = new HashMap<Integer, HashMap<String, Integer>>();
		}

		void rotate() {
			HashMap<Integer, HashMap<String, Integer>> newSushiLine = new HashMap<Integer, HashMap<String, Integer>>();

			for(int key : sushiLine.keySet()) {
				newSushiLine.put((key + 1) % this.lineCnt, (HashMap<String, Integer>) this.sushiLine.get(key).clone());
			}

			this.sushiLine = newSushiLine;
		}

		void addSushi(int idx, String name) {
			this.sushiCnt += 1;
			
			if(!this.sushiLine.containsKey(idx)) {
				this.sushiLine.put(idx, new HashMap<String, Integer>());
			}
			int curSushiCnt = !this.sushiLine.get(idx).containsKey(name) ? 0 : this.sushiLine.get(idx).get(name);

			this.sushiLine.get(idx).put(name, curSushiCnt + 1);
		}

		void addPerson(int idx, int cnt, String name) {
			this.personCnt += 1;
			this.personLine[idx] = new Person(cnt, name);
		}

		void eat() {
			for (int i = 0; i < lineCnt; i++) {
				if (this.personLine == null)
					continue;

				Person curPerson = this.personLine[i];
				
				if(curPerson == null) continue;

				HashMap<String, Integer> curPlace = this.sushiLine.get(i);

				// 스시 처리
				if(curPlace == null) continue;
				if (curPlace.containsKey(curPerson.name) && curPlace.get(curPerson.name) > 0) {
					// 스시 처리
					int getSushiCnt = curPlace.get(curPerson.name);
					if(curPlace.get(curPerson.name) > curPerson.cnt) {
						getSushiCnt = curPerson.cnt;
					}
					this.sushiLine.get(i).put(curPerson.name, curPlace.get(curPerson.name) - getSushiCnt);
					this.sushiCnt -= getSushiCnt;

					// person처리
					this.personLine[i].cnt -= getSushiCnt;

					// 다 먹은 사용자 제거
					if (this.personLine[i].cnt == 0) {
						this.personLine[i] = null;
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
