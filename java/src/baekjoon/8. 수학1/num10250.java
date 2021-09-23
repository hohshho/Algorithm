package package8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num10250 {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] person = new int[num];
        int[] a = new int[num];
        int[] b = new int[num];
        
        for(int i=0;i<num;i++) {
        	String str = br.readLine();
        	StringTokenizer stk = new StringTokenizer(str);
        	int H = Integer.parseInt(stk.nextToken());
        	int W = Integer.parseInt(stk.nextToken());
        	int N = Integer.parseInt(stk.nextToken());
        	
        	if(N%H==0) {
        		a[i] = H;
        		b[i] = N/H;
        	}else {
            	a[i] = N%H;
            	b[i] = N/H+1;
        	}
        }
        
        for(int i=0;i<a.length;i++) {
        	if(b[i]<10) {
        		System.out.println(a[i]+"0"+b[i]);
        	}else {
        		System.out.println(a[i]+""+b[i]);
        	}
        }
	}
}
