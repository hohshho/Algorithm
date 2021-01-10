package package16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num3036 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] arrData = br.readLine().split(" ");
		arr[0] = Integer.parseInt(arrData[0]);
		
		for(int i=1; i<N; i++) {
			arr[i] = Integer.parseInt(arrData[i]);
			int gcdValue = gcd(arr[0], arr[i]);
			sb.append(arr[0]/gcdValue+"/"+arr[i]/gcdValue+"\n");
		}
		System.out.println(sb);
	}
	public static int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a%b);
	}

}
