package 단계별풀어보기.level12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class num2750 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> data = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			data.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(data,Collections.reverseOrder());
		
		for(int value: data) {
			sb.append(value).append('\n');
		}
		
		System.out.println(sb);
	}
}
