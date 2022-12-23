package 단계별풀어보기.level8_수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class num10757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputData = br.readLine().split(" ");
		System.out.println(new BigInteger(inputData[0]).add(new BigInteger(inputData[1])));
	}

}
