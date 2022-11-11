package HashMap;

import java.util.*;
import java.io.*;


public class main {
    static String Message, Key;
    static char[] msgArr, keyArr;
    static char[][] map = new char[5][5];
    static HashSet<Character> set = new HashSet<>();
    static String res = "";

    public static void main(String args[]) throws IOException { // TODO: Exception 추가해야함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // TODO: InputStreamReader 자동 완성 안되니 주의

        Message = br.readLine();
        Key = br.readLine();

        msgArr = Message.toCharArray();
        keyArr = Key.toCharArray();

        makeKeyMap();

        run();

        System.out.println(res);
    }

    public static void run() {
        for(int x=0; x<msgArr.length; x+=2){
            char[] item = new char[2];
            item[0] = msgArr[x];
            if(x % 2 == 1 && x == msgArr.length - 1) {
                item[1] = 'X';
            }else {
                item[1] = msgArr[x+1];
            }

            if(item[0] == item[1]) {
                item[1] = 'X';
                x-=1;
            }

            if(item[0] == item[1] && x != msgArr.length - 1) {
                item[1] = 'Q';
                x-=1;
            }

            int itemX1 = 0, itemY1 = 0, itemX2 = 0, itemY2 = 0;

            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(item[0] == map[i][j]) {
                        itemX1 = i;
                        itemY1 = j;
                    }

                    if(item[1] == map[i][j]) {
                        itemX2 = i;
                        itemY2 = j;
                    }
                }
            }

            // case1
            if(itemX1 == itemX2) {
                itemY1 = checkRange(itemY1 + 1);
                itemY2 = checkRange(itemY2 + 1);
            } else if(itemY1 == itemY2) { // case 2
                itemX1 = checkRange(itemX1 + 1);
                itemX2 = checkRange(itemX2 + 1);
            } else {
                int temp = itemY1;
                itemY1 = itemY2;
                itemY2 = temp;
            }

            res += map[itemX1][itemY1] + "" + map[itemX2][itemY2];
        }
    }

    public static int checkRange(int x) {
        if(x > 4) {
            return 0;
        }
        if( x < 0)
            return 4;
        return x;
    }

    public static void makeKeyMap() {
        int i = 0;
        int j = 0;

        for (char item : keyArr) {
            if (!set.contains(item)) {
                set.add(item);
                map[i][j] = item;
                j += 1;
                if (j > 4) {
                    i += 1;
                    j = 0;
                }
                continue;
            }
        }

        int index = 0;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (map[i][j] == 0) {
                    while (true) {
                        if (set.contains((char) ((65) + index))) {
                            set.remove((char) ((65) + index));
                            index += 1;
                            if(index == 9) {
                                index += 1;
                            }
                            continue;
                        }
                        break;
                    }
                    map[i][j] = (char) ((65) + index);
                    index += 1;
                    if(index == 9) {
                        index += 1;
                    }
                }
            }
        }
    }
}