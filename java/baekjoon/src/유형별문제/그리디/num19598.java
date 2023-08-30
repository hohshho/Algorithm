package 유형별문제.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class num19598 {
    static LinkedList<Meeting> allMeetings = new LinkedList<>();
    static LinkedList<Room> rooms = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = stoi(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            allMeetings.add(new Meeting(start, end));
        }

        for (Meeting curMeeting : allMeetings) {
            // 첫번째 처리
            if (rooms.isEmpty()) {
                Room room = new Room(new Meeting(curMeeting.start, curMeeting.end));
                rooms.add(room);
                continue;
            }

            for (int i = 0; i < rooms.size(); i++) {
                Room curRoom = rooms.get(i);
                boolean finish = false;
                Meeting prev = null, cur;

                for (int j = 0; j < curRoom.list.size(); j++) {
                    cur = curRoom.list.get(j);

                    // 처음 부분 처리
                    if (prev == null) {
                        if (cur.start >= curMeeting.end) {
                            curRoom.list.addFirst(curMeeting);
                            finish = true;
                            break;
                        }

                        prev = cur;
                        continue;
                    }

                    // 중간 부분 처리
                    if (curMeeting.start >= prev.end && curMeeting.end <= cur.start) {
                        curRoom.list.add(j - 1, curMeeting);
                        finish = true;
                        break;
                    }

                    // 마지막 부분 처리
                    if (j == curRoom.list.size() - 1 && curMeeting.start >= cur.end) {
                        curRoom.list.addLast(curMeeting);
                        finish = true;
                        break;
                    }
                }

                if (!finish && i == rooms.size() - 1) {
                    Room room = new Room(new Meeting(curMeeting.start, curMeeting.end));
                    rooms.add(room);
                    break;
                }
            }
        }

        System.out.println(rooms.size());

    }

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.start - o.start;
        }
    }

    static class Room {
        LinkedList<Meeting> list;

        Room(Meeting meeting) {
            list = new LinkedList<>();
            this.list.add(meeting);
        }

//        public void add(Meeting meeting) {
//            this.list.add(new Meeting(meeting.start, meeting.end));
//            Collections.sort(this.list);
//        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
