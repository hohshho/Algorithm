package 단계별풀어보기.level27_트리;

import java.io.*;
import java.util.*;

public class num2263 {
	static int N;
	static int[] position, inOrder, postOrder;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		N = stoi(br.readLine());
		position = new int[N+1];
		inOrder = new int[N+1];
		postOrder = new int[N+1];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			inOrder[i] = stoi(st1.nextToken());
			postOrder[i] = stoi(st2.nextToken());
			position[inOrder[i]] = i;
		}
		
		solve(1, N, 1, N);
		bw.flush(); bw.close(); br.close();
	}
	public static void solve(int inStart, int inEnd, int postStart, int postEnd) throws IOException {
        if(inStart > inEnd || postStart > postEnd) return;
        int root = postOrder[postEnd]; // 포스트오더의 끝부분이 루트이다
        bw.write(root + " ");
        int p = position[root];
        solve(inStart, p-1, postStart, postStart+(p-inStart)-1); // 왼쪽탐색
        solve(p+1,inEnd,postStart+(p-inStart),postEnd-1); // 오른쪽탐색
	}
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
