package level13_백트래킹;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num15652 {

	static StringBuilder sb = new StringBuilder();
	
	static void saveSb(int[] output) {
		for(int i=0;i<output.length;i++) {
			sb.append(output[i] + " ");
		}
		sb.append("\n");
	}
	static boolean chkOutput(int[] output) {
		for(int i = output.length-1;i>0;i--) {
			if(output[i]<output[i-1]) {
				return true;
			}
		}
		return false;
	}
	static void permutation(boolean[] visited, int[] output, int depth, int n, int r) {
		if(depth == r) {
			boolean index = false;
			index = chkOutput(output);
			if(index == true) {
				return;
			}
			else {
				saveSb(output);
				return;
			}
		}
		
		for(int i=0;i<n;i++) { 
			visited[i] = true;
			output[depth] = i+1;
			permutation(visited, output, depth+1,n,r);
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
		
		permutation(visited, output, 0, n, r);
		
		System.out.println(sb);
	}

}
