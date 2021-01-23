package package24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11657 {
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputNM = br.readLine().split(" ");
		N = stoi(inputNM[0]);
		M = stoi(inputNM[1]);
		
		
		
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
