package package9;

import java.io.*;
import java.util.*;

public class num4948 {
	public static boolean go(int value) {
		if(value<2) return false;
		for(int i=2;i*i<=value;i++) {
			if(value%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true) {
			int num = Integer.parseInt(br.readLine());
			int count=0;
			if(num == 0) {
				break;
			}
			for(int i=num+1;i<=2*num;i++) {
				if(go(i)) {
					count++;
				}
			}
			list.add(count);
		}
		Iterator iter = list.iterator();
		while(iter.hasNext()){//다음값이 있는지 체크
		    System.out.println(iter.next()); //값 출력
		}
	}
}
