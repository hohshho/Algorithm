package level16_정수론조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class num9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map;
		StringBuilder sb = new StringBuilder();
				
		int T = StringToInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int W = StringToInt(br.readLine());
			map = new HashMap<>();
			for(int j=0; j<W; j++) {
				String[] inputCase = br.readLine().split(" ");
				String caseName = inputCase[0];
				String caseKinds = inputCase[1];
				if(!map.containsKey(caseKinds))
					map.put(caseKinds,1);
				else
					map.put(caseKinds,map.get(caseKinds)+1);
			}
			int Result = 1;
			for(int val : map.values()) {
				Result *= val + 1; 
			}
			sb.append(Result-1 + "\n");
		}
		System.out.println(sb);
	}
	
	public static int StringToInt(String value) {
		return Integer.parseInt(value);
	}
}
