package 단계별풀어보기.level5_1차원배열;

import java.io.IOException;
import java.util.Scanner;

public class num1546 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int i,score;
		double max=0,sum=0;
		
		for(i=0;i<num;i++) {
			score = sc.nextInt();
			sum+=score;
			if(score>max) {
				max = score;
			}
		}
		System.out.println(sum/max*100/num);
		
	}
}
