package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num14726 {
	public static boolean validNum(String cardNum) {
		int value = 0;
		
		char[] cardArray = cardNum.toCharArray();
		
		for(int i=cardNum.length()-1;i>=0;i--) {
			if(i%2 !=0) {
				value+=cardArray[i]-'0';
				continue;
			}
			
			int evenNum = (cardArray[i]-'0') ;
			if(evenNum* 2>10) {
				evenNum = 1 + (evenNum-10);
			}
			value +=evenNum;
		}
		
		return (value%10==0) ? true : false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		String cardValidValue;
		boolean[] cardIndex = 	new boolean[N];
		for(int i=0;i<N;i++) {
			cardIndex[i] = validNum(br.readLine());
		}
		for(int i=0;i<N;i++) {
			if(cardIndex[i] == true)
				System.out.println("T");
			else
				System.out.println("F");
		}
	}
}
