import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num15649 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputData = br.readLine().split(" ");
		int n = Integer.parseInt(inputData[0]);
		int r = Integer.parseInt(inputData[1]);
		int[] output = new int[r];
		boolean[] visited = new boolean[n];
		
		permutation(output,visited, 0,n,r);
	}
	
	static void permutation(int[] output,boolean[] visited,int depth, int n, int r) {
		if(depth == r) {
			printOutput(output);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i]==false){
				visited[i] = true;
				output[depth] = i+1;
				permutation(output,visited,depth+1,n,r);
				visited[i] = false;	
			}
		}
	}
	static void printOutput(int[] output) {
		for(int i=0;i<output.length; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
	}
	
}
