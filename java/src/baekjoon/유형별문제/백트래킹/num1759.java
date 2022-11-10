package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class num1759 {
    static int L, C;
    static String[] list;
    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        L = stoi(input[0]);
        C = stoi(input[1]);

        list = br.readLine().split(" ");

        Arrays.sort(list);

        getStringList(0, "", 0, new int[]{0, 0});

        for (String item : res) {
            System.out.println(item);
        }
    }

    public static void getStringList(int depth, String password, int index, int[] check) {
        if (depth == L) {
            if (check[0] >= 1 && check[1] >= 2) {
                res.add(password);
            }
            return;
        }

        for (int i = index; i < C; i++) {
            int flag = check(list[i]) ? 0 : 1;

            check[flag] += 1;
            getStringList(depth + 1, password + list[i], i + 1, check);
            check[flag] -= 1;
        }

        return;
    }

    public static boolean check(String item) {
        return item.equals("a") || item.equals("e") || item.equals("i") || item.equals("o") || item.equals("u");
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
