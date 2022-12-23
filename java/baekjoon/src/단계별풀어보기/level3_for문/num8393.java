package 단계별풀어보기.level3_for문;

import java.util.Scanner;

public class num8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int sum=0,i;
		for(i=1;i<x+1;i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
}
