package package28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num1976 {
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		parent = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			String[] inputData = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				int num = stoi(inputData[j]);
				if(num == 1) {
					union(i, j+1);
				}
			}
		}
		
		String[] map = br.readLine().split(" ");
		boolean resultIndex = true;
		int index = parent[stoi(map[0])];
		
		for(int i=1; i<map.length; i++) {
			if(index != parent[stoi(map[i])])
				resultIndex = false;
		}
		System.out.println(resultIndex == true ? "YES" : "NO");
	}
	
	public static int find_parent(int num) {
		if(parent[num] == num)
			return num;
		return parent[num] = find_parent(parent[num]);
	}
	
	public static void union(int a, int b) {
		a = find_parent(a);
		b = find_parent(b);
		if (a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
		}
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
