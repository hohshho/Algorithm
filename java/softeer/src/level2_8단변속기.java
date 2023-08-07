import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class level2_8단변속기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int res = 0; // 1 = descending, 2 = ascending, 3 = mixed
        int prev = stoi(st.nextToken());

        if(prev != 1 && prev != 8) {
            System.out.println("mixed");
            return;
        }

        res = prev == 1 ? 2 : 1;

        while(st.hasMoreTokens()){
            int next = stoi(st.nextToken());

            if(Math.abs(next - prev) != 1) {
                res = 3;
                break;
            }

            if(res == 1 && prev < next) {
                res = 3;
                break;
            }

            if(res == 2 && prev > next){
                res = 3;
                break;
            }

            prev = next;
        }

        System.out.println(res == 3 ? "mixed" : res == 2 ? "ascending" : "descending");
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
