package package9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class num1978 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int size = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        int primeCnt = 0;
        for(int i=0; i < size; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(isPrimeNumber(num)) primeCnt++;
        }
        System.out.println(primeCnt);
    }
    public static boolean isPrimeNumber(int num) {
        
        if(num == 1) return false;
        
        for(int i = 2; i < num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
 
}
 
