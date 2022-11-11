package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class num13701 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        StringBuilder sb = new StringBuilder();

        BitSet bitSet = new BitSet();

        while (st.hasMoreTokens()) {
            final int nextNum = Integer.parseInt(st.nextToken());
            if (!bitSet.get(nextNum)) {
                bitSet.set(nextNum);
                sb.append(nextNum + " ");
            }
        }

        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}