import java.util.*;
import java.io.*;


public class 염기서열커버 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        LinkedList<char[]> list = new LinkedList<char[]>();

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();

            // 초기값
            if (list.size() == 0) {
                list.add(input);
                continue;
            }

            // 맞는 값이 있는지 확인
            int check = -1;
            for (int j = 0; j < list.size(); j++) {
                char[] part = list.get(j);
                // for(int k=0; k<part.length; k++){
                //     System.out.print(part[k] + " ");
                // }
                // System.out.println("");

                if (checkInput(input, part)) {
                    check = j;
                    break;
                }
            }

            // 없으면 list에 추가
            if (check == -1) {
                list.add(input);
                continue;
            }

            // 있을 때 비교 후 .값 교체 해야하면 교체
            char[] part = list.get(check);
            char[] newPart = getNewPart(input, part);
            list.remove(check);
            list.add(check, newPart);
        }

        System.out.println(list.size());
    }

    public static char[] getNewPart(char[] input, char[] part) {
        char[] newPart = new char[input.length];

        for (int i = 0; i < input.length; i++) {
            newPart[i] = part[i] != '.' ? part[i] : input[i];
        }

        return newPart;
    }

    public static boolean checkInput(char[] input, char[] part) {
        for (int i = 0; i < input.length; i++) {
            if (part[i] == '.' || input[i] == '.') continue;

            if (part[i] == input[i]) continue;

            return false;
        }
        return true;
    }


    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
