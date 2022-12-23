package 단계별풀어보기.level5_1차원배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class num2577 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A,B,C,i,res,dataLen,x;
		String data;
		ArrayList list = new ArrayList();
		
		A=Integer.parseInt(br.readLine());
		B=Integer.parseInt(br.readLine());
		C=Integer.parseInt(br.readLine());
		
		res=A*B*C;
		data = Integer.toString(res);
		dataLen = data.length();
		int[] arr = new int[10];
		for(i=0;i<dataLen+1;i++) {
			if(i==dataLen) {
				break;
			}
			list.add(data.substring(i,i+1));
		}
		
		for(i=0;i<list.size();i++) {
			x= Integer.parseInt((String) list.get(i));
			arr[x]++;
		}
		
		for(i=0;i<10;i++) {
			System.out.println(arr[i]);
		}
		
	}
}
