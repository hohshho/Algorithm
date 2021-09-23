package package28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1717 {
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] NM = br.readLine().split(" ");
		
		N = stoi(NM[0]);
		M = stoi(NM[1]);
		parent = new int[N];
		
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			String[] inputData = br.readLine().split(" ");
			
			int action = stoi(inputData[0]);
			int a = stoi(inputData[1])-1;
			int b = stoi(inputData[2])-1;
			
			
			if(action == 0) {
				union(a,b);
			}else {
				sb.append(find_parent(a) == find_parent(b) ? "YES" : "NO");
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static int find_parent(int num) {
		if(parent[num] != num)
			parent[num] = find_parent(parent[num]);
		return parent[num];
	}
	
	public static void union(int a, int b) {
		int aParent = find_parent(a);
		int bParent = find_parent(b);
		if(aParent<bParent)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
