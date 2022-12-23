package 유형별문제.스택;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<String>();
        int result = 0;

        String[] inputData = br.readLine().split("");

        for (int i = 0; i < inputData.length; i++) {
            String item = inputData[i];

            if (item.equals("(")) {
                st.push(item);
            } else {
                st.pop();
                if (inputData[i - 1].equals("(")) {
                    result += st.size();
                }
                if (inputData[i - 1].equals(")")) {
                    result++;
                }

            }
        }

        System.out.println(result);


    }
}
