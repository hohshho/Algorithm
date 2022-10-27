package level12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class num1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) 
                    return 1;
                else if(o1.length() < o2.length()) 
                    return -1;
                else
                    return o1.compareTo(o2);
			}
			
		});
		
		for(int i=0;i<N;i++) {
			if(i!=0) {
				if(arr[i-1].equals(arr[i])) {
					continue;
				}
			
			}
			sb.append(arr[i] + "\n");
		}
		
		System.out.println(sb);
	}

}
