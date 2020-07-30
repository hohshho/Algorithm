package package8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] al = new int[26];
		int ch,chInt=0;
		int i=0;
		String str = br.readLine();
		for(i=0;i<al.length;i++) {
			al[i] = -1;
		}
		
		for(i=0;i<str.length();i++) {
			ch = (int)str.charAt(i);
			chInt = ch-97;
			if(al[chInt]==-1)
				al[chInt] = i;
		}
		
		for(i=0;i<26;i++) {
			System.out.print(al[i]+" ");
		}	
		
		
		
	}
}
