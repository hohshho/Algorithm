package 단계별풀어보기.level15_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num13305 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		 
		long[] distances = new long[n - 1];
		long[] fuels = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n - 1; i++) {
			int distance = Integer.valueOf(st.nextToken());
			distances[i] = distance;
		}
		
		// 주유소 입력 받기
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int fuel = Integer.valueOf(st.nextToken());
			fuels[i] = fuel;
		}
		
		long price = distances[0] * fuels[0]; 
		int nowCity = 0;
		int nextCity = nowCity + 1;
		
		while(nextCity < n - 1) {
			if(fuels[nowCity] < fuels[nextCity]) {
				price += fuels[nowCity] * distances[nextCity];
			}
			else {
				price += fuels[nextCity] * distances[nextCity];
				nowCity = nextCity;
			}
			
			nextCity++;
		}
		
		System.out.print(price);
	}
}