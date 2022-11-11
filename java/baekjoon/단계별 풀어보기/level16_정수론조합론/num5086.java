package level16_정수론조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num5086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] value;
		int[] valueInt = new int[2];
		
		while(true) {
			value = br.readLine().split(" ");
			valueInt[0] = Integer.parseInt(value[0]); valueInt[1] = Integer.parseInt(value[1]);
			if(valueInt[0] == 0 && valueInt[1] == 0)
				break;
			if(valueInt[0]/valueInt[1]!=0 && valueInt[0]%valueInt[1]==0)
				sb.append("multiple\n");
			else if(valueInt[1]/valueInt[0]!=0 && valueInt[1]%valueInt[0]==0)
				sb.append("factor\n");
			else
				sb.append("neither\n");
		}
		System.out.println(sb);
		
	}

}
