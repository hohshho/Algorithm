package package23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class num1707 {

	static final int RED = 1;
	static final int BLUE = -1;
	static ArrayList<ArrayList<Integer>> adj;
	static int[] colors;
	static int K, V, E;
	static boolean ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		K = stoi(br.readLine());

		for (int k = 0; k < K; ++k) {
			st = new StringTokenizer(br.readLine());

			V = stoi(st.nextToken());
			E = stoi(st.nextToken());

			ans = true;
			colors = new int[V + 1];
			adj = new ArrayList<>();
			for (int i = 0; i < V + 1; ++i) {
				adj.add(new ArrayList<>());
			}

			for (int i = 0; i < E; ++i) {
				st = new StringTokenizer(br.readLine());
				int from = stoi(st.nextToken());
				int to = stoi(st.nextToken());

				adj.get(from).add(to);
				adj.get(to).add(from);
			}

			for (int i = 1; i < V + 1; ++i) {
				if(colors[i] == 0) {
					if(dfs(i, RED)) break;
				}
			}
			System.out.println(ans ? "YES" : "NO");
		}
	}
	
	private static boolean dfs(int start, int color) {
		colors[start] = color;

		for (Integer i : adj.get(start)) {
			if (colors[i] == color) {
				ans = false;
				return true;
			}

			if (colors[i] == 0) {
				if (dfs(i, -color))
					return true;
			}
		}
		return false;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}