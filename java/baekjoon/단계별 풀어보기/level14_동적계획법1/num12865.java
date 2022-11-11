package level14_동적계획법1;

import java.util.Scanner;

public class num12865 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// 물품의 수 
		int n = in.nextInt();
		
		// 버틸 수 있는 무게
		int k = in.nextInt();
		
		// 물품의 무게(0)와 가치(1)
		int a[][] = new int[n+1][2];
		
		// 행: 물품의 무게, 열: 1~k까지의 무게, 값: 물품의 가치 누적
		int dp[][] = new int[n+1][k+1];
		
		// 물품들의 무게와 가치 입력
		for(int i=1;i<n+1;i++) {
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt();
		}
		
        // 0행, 0열은 공백 인덱스로 비워둔다.
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<k+1;j++) {
            	// 비교 무게 - 물품의 무게 >= 0 인 경우,
				if(j - a[i][0] >= 0) {
                	// 이전 dp에 저장된 누적 가치와 자신의 가치+남은 무게의 가치 중 큰 값을 취한다.
					dp[i][j] = Math.max( dp[i-1][j], a[i][1]+dp[i-1][j-a[i][0]]);
				}else {
                	// 나머지는 이전 dp에 누적된 가치를 취한다.
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[n][k]);
				
		in.close();
	}

}