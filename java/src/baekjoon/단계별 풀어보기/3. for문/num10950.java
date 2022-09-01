package package3;

import java.util.Scanner;

public class num10950 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[][] num = null;
		int i;
		num = new int[x][2];
		for(i=0;i<x;i++) {
			num[i][0]=sc.nextInt();
			num[i][1]=sc.nextInt();
		}
		for(i=0;i<x;i++) {
			System.out.println(num[i][0]+num[i][1]);
		}
	}
}
