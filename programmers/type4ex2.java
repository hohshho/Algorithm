package programmers;
import java.util.*;

public class type4ex2 {
	public static void main(String[] args) {
		int[] numbers = new int[] {6, 10, 2}; // 3, 30, 34, 5, 9
		
		String str = solution(numbers);
		
		System.out.println(str);
	}
	
	public static String solution(int[] numbers) {
		String answer = "";
	
		String[] number = new String[numbers.length];
		
		for(int i=0;i<number.length;i++) {
			number[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(number, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if(a.length() == b.length()) {
					return b.compareTo(a);
				}
				String sum = a+b;
				String reverseSum=b+a;
				return reverseSum.compareTo(sum);
			}
		});
		 
        if (number.length > 0 && "0".equals(number[0])) { // means "0000"
            answer = "0";
        } else {
            StringBuilder sb = new StringBuilder();
 
            for (String num : number) {
                sb.append(num);
            }
 
            answer = sb.toString();
        }
 
        return answer;
	}
	
}
