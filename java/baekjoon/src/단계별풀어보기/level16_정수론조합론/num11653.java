package 단계별풀어보기.level16_정수론조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num11653 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int index = 1;
		
		while(true) {
			index++;
			if(n%index == 0) {
				n=n/index;
				list.add(index);
				index=1;
			}
			if(index>n)
				break;
		}
		int totalElements = list.size();
		for (int i = 0; i < totalElements; i++) {
			System.out.println(list.get(i));
		}
	}

}
