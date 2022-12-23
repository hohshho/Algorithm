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
    // 위, 아래, 오른쪽, 왼쪽
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
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

        for (int i = 0; i < M; i++) {
            String[] sharkData = br.readLine().split(" ");

            int x = stoi(sharkData[0]) - 1;
            int y = stoi(sharkData[1]) - 1;
            int speed = stoi(sharkData[2]);
            int direction = stoi(sharkData[3]) - 1;
            int size = stoi(sharkData[4]);

            sharks.put(i, new Shark(x, y, speed, direction, size));

            ArrayList<Integer> list;
            if(map.containsKey(y)){
                list = map.get(y);
                map.remove(y);
            }else {
                list = new ArrayList<Integer>();
            }

            list.add(i);
            map.put(y, list);
        }

        for (int i = 0; i < C; i++) {
            // 1. 상어 잡기
            if(map.containsKey(i)){
                int x = 101; // R, C 100이하
                int getShark = 0;
                ArrayList<Integer> list = map.get(i);
                if(list == null){
                    continue;
                }
                for(int SharkNum : list){
                    // 가장 가까운 상어 index
                    Shark item = sharks.get(SharkNum);
                    if(x > item.x){
                        x = item.x;
                        getShark = SharkNum;
                    }
                }

                Shark getSharkObj = sharks.get(getShark);
                result += getSharkObj.size;

                sharks.remove(getShark);
                list.remove(getShark);

                map.remove(i);
                if(list.size() != 0){
                    map.put(i, list);
                }
            }

            // map 초기화

            // 2. 상어 이동
            for(int key : sharks.keySet()){
                Shark item = sharks.get(key);
                int x = item.x;
                int y = item.y;
                int speed = item.speed;
                int direction = item.direction;
                int size = item.size;

                if(item.direction == 0 && item.direction == 1) {
                    int rotate = (R-1) * 2;
                    if(item.speed >= rotate) {
                        speed = speed % rotate;
                    }

                    for(int j = 0; j < speed; j++){
                        int nx = x + dx[direction];
                        int ny = y + dy[direction];

                        // 위 벽에 닿을 경우
                        if(nx < 1) {
                            direction = 2;
                            nx = nx + 2;
                        }

                        // 아래 벽에 닿을 경우
                        if(nx > R){
                            direction = 1;
                            nx = nx - 2;
                        }
                        x = nx;
                        y = ny;
                    }

                }else {
                    int rotate = (C-1) * 2;
                    if(item.speed >= rotate) {
                        speed = speed % rotate;
                    }

                    for(int j = 0; j < speed; j++){
                        int nx = x + dx[direction];
                        int ny = y + dy[direction];

                        // 왼쪽 벽에 닿을 경우
                        if(ny < 1) {
                            direction = 3;
                            ny = ny + 2;
                        }

                        // 오른쪽 벽에 닿을 경우
                        if(ny > C){
                            direction = 4;
                            ny = ny - 2;
                        }
                        x = nx;
                        y = ny;
                    }
                }

                sharks.put(key, new Shark(x, y, speed, direction, size));

                ArrayList list;
                if(map.containsKey(y)){
                    list = map.get(y);
                    map.remove(y);
                }else {
                    list = new ArrayList<>();
                }

                list.add(key);
                map.put(y, list);
            }

            // 3. 동일한 위치 상어 체크
            for(int key : map.keySet()){
                ArrayList<Integer> list = map.get(key);
                ArrayList<Integer> deleteItems = new ArrayList<>();

                for(int j=0; j<list.size(); j++){
                    Shark firstItem = sharks.get(list.get(j));

                    for(int k=j; k < list.size(); k++){
                        Shark secondItem = sharks.get(list.get(k));

                        if(firstItem.x == secondItem.x) {
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
