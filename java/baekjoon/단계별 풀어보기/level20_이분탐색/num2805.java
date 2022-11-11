package level20_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputNK = br.readLine().split(" ");
		long max=0;
		int N = Integer.parseInt(inputNK[0]);
		long K = StringToLong(inputNK[1]);
		long[] tree = new long[N];
		String[] treeData = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			tree[i] = StringToLong(treeData[i]);
			max = max > tree[i] ? max : tree[i];
		}
		
		max = Psearch(tree, K, max);
		System.out.println(max);
	}
	
	public static long Psearch(long[] tree, long K, long max) {
		long start = 0;
		long end = max;
		long count = 0;
		while(start<=end) {
			long mid = (start+end)/2;
			if(checkTree(tree,K, mid)) {
				start = mid +1;
				count = mid;
			}else {
				end = mid -1;
			}
		}
		return count;
	}
	
	public static boolean checkTree(long[] tree, long K, long mid) {
		long len = 0;
		for(long value : tree) {
			len += value - mid > 0 ? value - mid : 0;
		}
		return len>=K ? true : false;
	}
	
	public static long StringToLong(String string) {
		return Long.parseLong(string);
	}

}
