package HashMap;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class num17219 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N, M;
    static Map<String, String> dic;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dic = new HashMap<String, String>();

        String[] NM = br.readLine().split(" ");

        N = stoi(NM[0]);
        M = stoi(NM[1]);

        makeDic(N);

        makeBuf(M);

        bw.flush();
        bw.close();
    }

    public static void makeDic(int N) throws IOException {
        for(int i = 0; i < N; i++){
            String[] inputData = br.readLine().split(" ");
            dic.put(inputData[0], inputData[1]);
        }
    }

    public static void makeBuf(int M) throws IOException {
        for(int i = 0; i < M; i++){
            String site = br.readLine();

            bw.write(dic.get(site) + "\n");

        }
    }

    public static int stoi(String string) {
        return Integer.parseInt(string);
    }
}
