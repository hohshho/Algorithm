package package28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class num4195 {
	static int N, F, index;
	static HashMap<String, Integer> map;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = stoi(br.readLine());
		
		for(int i=0; i<N; i++) {
			map = new HashMap<String, Integer>();
			index = 1;
			
			F = stoi(br.readLine());
			parent = new int[2*F+1];
			Arrays.fill(parent, -1);
			
			for(int j=0; j<F; j++) {
				String[] inputData = br.readLine().split(" ");
				int v1 = getMapValue(inputData[0]);
				int v2 = getMapValue(inputData[1]);
				int result = -union(v1,v2);
				sb.append(result+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static int find_parent(int num) {
		if(parent[num] < 0)
			return num;
		return parent[num] = find_parent(parent[num]);
	}
	
	public static int union(int a, int b) {
		a = find_parent(a);
		b = find_parent(b);
		if (a != b) {
            if (a < b) {
            	parent[a] += parent[b];
                parent[b] = a;
            } else {
            	parent[b] += parent[a];
                parent[a] = b;
            }
		}
		return parent[a] < 0 ? parent[a] : parent[b];
	}
	
	public static int getMapValue(String string) {
		if(!map.containsKey(string)) {
			map.put(string, index);
			index++;
		}
		return map.get(string);
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
