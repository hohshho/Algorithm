package level14_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class num1003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		int[][] dp;
		int n;

		for (int i = 0; i < t; i++) {
			n = input.nextInt();
			if (n == 0) {
				System.out.println("1 0");
				continue;
			} else if (n == 1) {
				System.out.println("0 1");
				continue;
			} else {
				dp = new int[n + 1][2];
				dp[0][0] = 1;
				dp[1][1] = 1;
				for (int j = 2; j <= n; j++) {
					dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
					dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
				}
				System.out.println(dp[n][0] + " " + dp[n][1]);
			}
		}
	}

}
