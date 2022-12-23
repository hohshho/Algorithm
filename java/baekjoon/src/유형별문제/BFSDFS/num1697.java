package 유형별문제.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num1697 {
	static int n,k,count=0;
	static int result;
	static int arr[] = new int[100001];
	static boolean visited[] = new boolean[100001];
	static int[] d = new int[]{1, 2, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		n = Integer.parseInt(nk[0]);
		k = Integer.parseInt(nk[1]);
		
		bfs();
		
		System.out.println(arr[k]);
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[n] = true;
		q.offer(n);
		while (!q.isEmpty()) {
			int now = q.poll(); 
			if (now - 1 >= 0) {
				if (visited[now - 1] == false) {
					q.add(now - 1);
					visited[now - 1] = true;
					arr[now - 1] = arr[now] + 1;
				}
			}
			if (now + 1 < 100001) {
				if (visited[now + 1] == false){
					q.offer(now + 1);
					visited[now + 1] = true;
					arr[now + 1] = arr[now] + 1;
				}
			}
			if (now * 2 < 100001) {
				if (visited[now * 2] == false) { 
					q.offer(now * 2); 
					visited[now * 2] = true; 
					arr[now * 2] = arr[now] + 1; 
					} 
				} 
			}
	}
}
