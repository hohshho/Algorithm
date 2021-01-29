package package28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num20040 {
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int index = 0;
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		parent = new int[N+1];
		for(int i =0; i<=N; i++) {
			parent[i] = i;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = stoi(st.nextToken());
			int v2 = stoi(st.nextToken());
			if(!union(v1,v2)) {
				index = i+1;
				break;
			}
		}
		System.out.println(index);
	}
	
	public static boolean union(int a, int b) {
		a = find_parent(a);
		b = find_parent(b);
		if(a==b)
			return false;
		if(a!=b) {
			if(a < b) {
				parent[b] = a;
			}else {
				parent[a] = b;
			}
		}
		return true;
	}
	
	public static int find_parent(int num) {
		if(parent[num] == num)
			return num;
		return parent[num] = find_parent(parent[num]);
	}
	
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
