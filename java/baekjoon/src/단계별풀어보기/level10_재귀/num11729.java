package 단계별풀어보기.level10_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11729 {
	public static StringBuilder sb = new StringBuilder();
	
	/*
	 *  N : 원판의 개수
	 *  start : 출발지
	 *  mid : 옮기기 위해 이동시켜야 하는 장소
	 *  to : 목적지
	 */
	
	public static void Hanoi(int N, int start, int mid, int to) {
		// 이동할 원반의 수 1개
		// 종료 조건
		if(N == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		
		// step1
		Hanoi(N-1,start,to,mid);
		
		// step2
		sb.append(start + " " + to + "\n");
		
		// step3
		Hanoi(N-1,mid,start,to);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String num = Integer.toString((int) (Math.pow(2,N)-1));
		sb.append(num+"\n");
		Hanoi(N,1,2,3);
		System.out.println(sb);
		
	}
	
}
