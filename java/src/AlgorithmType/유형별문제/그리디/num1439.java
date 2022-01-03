package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int zeroCount = 0; int oneCount = 0;
		String[] S = br.readLine().split("");
		int index = stoi(S[0]);
		if(index==0) 
			zeroCount++;
		else 
			oneCount++;	
		
		for(int i=1; i<S.length; i++) {
			index = index == stoi(S[i]) ? index : stoi(S[i]);
			if(!S[i-1].equals(S[i])) {
				if(S[i].equals("0"))
					zeroCount++;
				else
					oneCount++;
			}
		}
		System.out.println(zeroCount < oneCount ? zeroCount : oneCount);
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
