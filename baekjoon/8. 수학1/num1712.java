package package8;

import java.io.*;
import java.util.*;

public class num1712 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

		if((C-B) < 0) {
			bw.write("-1\n");
		}else {
			bw.write(((A / (C - B)) + 1) + "\n");
		}
        bw.flush();
        br.close();
        bw.close();
	}
}
