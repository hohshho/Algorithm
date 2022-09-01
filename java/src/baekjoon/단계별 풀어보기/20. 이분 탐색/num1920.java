package pakcage20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class num1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int N = StringToInt(br.readLine());
		String[] nData = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			int value = StringToInt(nData[i]);
			if(map.containsKey(value) == false)
				map.put(value,1);
			else
				map.put(value,map.get(value)+1);
		}
		
		int M = StringToInt(br.readLine(                                                 ));
		String[] mData = br.readLine().split(" ");
		
		for(int i=0; i<M; i++) {
			int value = map.get(StringToInt(mData[i])) != null ? map.get(StringToInt(mData[i])) : 0;
			sb.append(value + " ");
		}
		System.out.println(sb);
	}
	public static int StringToInt(String input) {
		return Integer.parseInt(input);
	}
}
