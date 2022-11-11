package level11_브루트포스;

import java.util.*;

public class num2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		for(int i=0; i<N; i++){ 
			int decompos=i; 
			// 분해합이 될 변수
			String numtoString = Integer.toString(i);
			// 각 자리수를 더하기 위해 N을 문자열로 바꿈 
			for(int j=0; j<numtoString.length(); j++){
				decompos+=Character.getNumericValue(numtoString.charAt(j));
			} 
			if(N==decompos){
				System.out.print(i);
				return ;
			} 
		} 
		System.out.print(0); 
	} 
}