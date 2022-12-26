package 유형별문제.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class num17143 {
    // FIXME: 풀던 문제
    static int R, C, M, result;
    // 위, 좌, 아래, 오른쪽
    static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
    static HashMap<Integer, Shark> sharks = new HashMap<Integer, Shark>();
    // 열 번호, 열에 속한 상어
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] firstLine = br.readLine().split(" ");
        R = stoi(firstLine[0]);
        C = stoi(firstLine[1]);
        M = stoi(firstLine[2]);

        for (int i = 1; i <= C; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            map.put(i, list);
        }

        for (int i = 1; i <= M; i++) {
            String[] sharkData = br.readLine().split(" ");

            int y = stoi(sharkData[0]);
            int x = stoi(sharkData[1]);
            int speed = stoi(sharkData[2]);
            int direction = stoi(sharkData[3]) - 1;
            int size = stoi(sharkData[4]);

            // 상, 좌, 하, 우
            if (direction == 1)
                direction = 2;
            else if (direction == 2)
                direction = 3;
            else if (direction == 3)
                direction = 1;

            sharks.put(i, new Shark(x, y, speed, direction, size));

            ArrayList<Integer> list = map.get(x);

            list.add(i);
            // key : x좌표 / value : 상어 index
            map.put(x, list);
        }

        for (int i = 1; i <= C; i++) {
            // 1. 상어 잡기
            if (map.containsKey(i)) {
                int y = 101; // R, C 100이하
                int getShark = 0;
                ArrayList<Integer> list = map.get(i);

                if (!list.isEmpty()) {
                    for (int SharkNum : list) {
                        // 가장 가까운 상어 index
                        Shark item = sharks.get(SharkNum);
                        if (y > item.y) {
                            y = item.y;
                            getShark = SharkNum;
                        }
                    }

                    Shark getSharkObj = sharks.get(getShark);
                    result += getSharkObj.size;

                    sharks.remove(getShark);
                    list.remove(Integer.valueOf(getShark));

                    map.remove(i);
                    if (list.size() != 0) {
                        map.put(i, list);
                    }
                }
            }

            // map 초기화
            map.clear();
            for (int j = 1; j <= C; j++) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                map.put(j, list);
            }

            // 2. 상어 이동
            for (int key : sharks.keySet()) {
                Shark item = sharks.get(key);
                int x = item.x;
                int y = item.y;
                int speed = item.speed;
                int direction = item.direction;
                int size = item.size;

                // 속력만큼 상어 이동 시키기
                if (direction == 0 || direction == 2) // 상 하
                    speed %= (R - 1) * 2;
                else if (direction == 1 || direction == 3) // 좌 우
                    speed %= (C - 1) * 2;

                for (int s = 0; s < speed; s++) {
                    // 현재 r, c에 방향에 맞게 1칸씩 추가하며 위치 이동
                    int ny = y + dy[direction];
                    int nx = x + dx[direction];

                    // 이동할 새로운 위치가 범위를 벗어나 벽에 부딪히면
                    if (ny < 1 || ny > R || nx < 1 || nx > C) {
                        y -= dy[direction]; // 다시 값 돌려주고
                        x -= dx[direction];
                        direction = (direction + 2) % 4; // 방향 반대로
                        continue;
                    }

                    // 위치 벗어나지 않을때는 새로운 위치로 이동
                    y = ny;
                    x = nx;
                }

                sharks.put(key, new Shark(x, y, speed, direction, size));

                ArrayList<Integer> list = map.get(x);

                list.add(key);
                // key : x좌표 / value : 상어 index
                map.put(x, list);
            }

            // 3. 동일한 위치 상어 체크
            for(int key : map.keySet()) {
                ArrayList<Integer> list = map.get(key);
                ArrayList<Integer> deleteItems = new ArrayList<>();

                if (list.size() < 2) continue;

                for (int j = 0; j < list.size(); j++) {
                    Shark firstItem = sharks.get(list.get(j));

                    for (int k = j + 1; k < list.size(); k++) {
                        Shark secondItem = sharks.get(list.get(k));

                        if (firstItem.y == secondItem.y) {
                            deleteItems.add(firstItem.size > secondItem.size ? k : j);
                        }
                    }
                }

                Collections.sort(deleteItems, Collections.reverseOrder());

                for(int deleteKey: deleteItems){
                    list.remove(deleteKey);
                }

                map.put(key, list);
            }
        }

        System.out.println(result);
    }

    static class Shark {
        int x, y, speed, direction, size;

        Shark(int x, int y, int speed, int direction, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
