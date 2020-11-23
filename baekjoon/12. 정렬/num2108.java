package package12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class num2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 1. 산술평균 위한 값
		int sum = 0;
		// 4. 범위
		int max = -4001;
		int min = 4001;
		// 3. 최빈값
		int indexValue =0;
		int[] cnt = new int[8001]; // 0이 4000 값에 4000더한 값index에 저장
		
		int N = Integer.parseInt(br.readLine());
		int mid = 10000;
		int m = 10000;
		int m_max = 0;
		
		boolean flag = false;
		int count =0;
		
		
		for(int i=0;i<N;i++) {
			int value = Integer.parseInt(br.readLine());
			sum+=value;
			if(value>max)
				max=value;
			if(value<min)
				min=value;
			cnt[4000+value]++;
		}
		
		br.close();
		// 1
		
		sb.append((int)Math.round((double)sum / N)).append("\n");
		
		for(int i = min + 4000; i <=max +4000; i++){
			if(cnt[i] >0) {
				if(count < (N+1)/2) {
					count+=cnt[i];
					mid = i-4000;
				}
			}
			
			if(m_max < cnt[i]) {
				m_max = cnt[i];
				m = i - 4000;
				flag = true;	// 첫 등장이므로 true 로 변경 
			}
			// 이전 최빈값 최댓값과 동일한 경우면서 한 번만 중복되는 경우 
			else if(m_max == cnt[i] && flag == true) {
				m = i - 4000;
				flag = false;					
			}
		}
		
		
		// 2
		
		sb.append(mid).append("\n");
		
		// 3
		
		sb.append(m).append("\n");
		
		// 4
		if(max!=-4000 && min!=4000)
			sb.append(max-min).append("\n");
		else
			sb.append(0).append("\n");
		System.out.println(sb);
	}
}
