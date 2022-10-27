package level17_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class num2504 {
    static Stack<String> st = new Stack<String>();

    static class Calc {
        int calcValue;
        int check;

        Calc(int calcValue) {
            this.calcValue = calcValue;
        }

        Calc(int calcValue, int check) {
            this.calcValue = calcValue;
            this.check = check;
        }
    }

    static HashMap<String, Calc> SignCalcMap = new HashMap<String, Calc>() {{
        put("(", new Calc(2));
        put("[", new Calc(3));
        put(")", new Calc(2, 1));
        put("]", new Calc(3, 2));
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputData = br.readLine().split("");
        int result = 0;
        int value = 1;


        // ascii code ( = 40, ) = 41, [ = 91, ] = 93
        for (int i = 0; i < inputData.length; i++) {
            String item = inputData[i];

            if (item.equals("(") || item.equals("[")) {
                st.push(item);
                value *= SignCalcMap.get(item).calcValue;
                continue;
            }

            if (item.equals(")") || item.equals("]")) {
                if (!checkItem(item)) {
                    System.out.println(0);
                    return;
                }
                if (inputData[i-1].charAt(0) == item.charAt(0) - SignCalcMap.get(item).check) {
                    result += value;

                }
                st.pop();
                value /= SignCalcMap.get(item).calcValue;
            }
        }

        if(!st.isEmpty())
            System.out.println(0);
        else
            System.out.println(result);
    }

    public static int stoi(String s) {
        return s.charAt(0);
    }

    public static boolean checkItem(String item) {
        return !st.isEmpty() && st.peek().charAt(0) == item.charAt(0) - SignCalcMap.get(item).check;
    }
}
