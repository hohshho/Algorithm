package implementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNum = br.readLine().split("");
        int[] set = new int[10];
        int num;

        for(String item : inputNum){
            num = stoi(item);

            if(num == 9){
                num = 6;
            }
            set[num]++;
        }

        set[6] = set[6] / 2 + set[6] % 2;

        System.out.println(Arrays.stream(set).max().getAsInt());

    }
    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
