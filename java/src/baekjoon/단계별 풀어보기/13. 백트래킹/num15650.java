package package13;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num15650 {

	static StringBuilder sb = new StringBuilder();
	
	static void saveSb(int[] output) {
		for(int i=0;i<output.length;i++) {
			sb.append(output[i] + " ");
		}
		sb.append("\n");
	}
	
	static void permutation(boolean[] visited, int[] output, int depth, int n, int r, int a) {
		if(depth == r) {
			saveSb(output);
			return;
		}
		
		for(int i=a;i<n;i++) { 
			visited[i] = true;
			output[depth] = i+1;
			permutation(visited, output, depth+1,n,r,i+1);
			visited[i] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputData = br.readLine().split(" ");
		int n = Integer.parseInt(inputData[0]);
		int r = Integer.parseInt(inputData[1]);
		int[] output = new int[r];
		boolean[] visited = new boolean[n];
		
		permutation(visited, output, 0, n, r, 0);
		
		System.out.println(sb);
	}

}
