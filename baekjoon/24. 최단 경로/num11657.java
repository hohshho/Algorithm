package package24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11657 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputNM = br.readLine().split(" ");
		int N = stoi(inputNM[0]);
		int M = stoi(inputNM[1]);
		
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
