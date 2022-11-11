package level14_동적계획법1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num9461 {
	 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        long[] padobanSeq = new long[101]; 
        padobanSeq[1] = 1;
        padobanSeq[2] = 1;
        padobanSeq[3] = 1;
        padobanSeq[4] = 2;
        padobanSeq[5] = 2;
        
        for(int i=6; i<padobanSeq.length; i++) { 
            // 점화식 f(n) = f(n-1) + f(n-5)
            padobanSeq[i] = padobanSeq[i-1] + padobanSeq[i-5];
        }
        
        int testCase = Integer.parseInt(st.nextToken());
        for(int j=0; j<testCase; j++) {
            st = new StringTokenizer(br.readLine());
            sb.append(padobanSeq[Integer.parseInt(st.nextToken())]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        
    }    
}