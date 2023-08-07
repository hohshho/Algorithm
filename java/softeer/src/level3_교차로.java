import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class level3_교차로 {
    static int N;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        result = new int[N];


    }

    static class Car{
        int index, time;
        String direction;
        Car(int index, int time, String direction){
            this.index = index;
            this.time = time;
            this.direction = direction;
        }
    }

    public static class CrossLoad{
        LinkedList<Integer> A, B, C, D; // car의 index 저장

        CrossLoad() {
            A = new LinkedList<>();
            B = new LinkedList<>();
            C = new LinkedList<>();
            D = new LinkedList<>();
        }




    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
