package package18;

import java.util.LinkedList;
import java.util.Scanner;
public class num1021 {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		Scanner scan = new Scanner(System.in);
		boolean flag;
		int n = scan.nextInt(), m = scan.nextInt(), num, answer = 0;
		
		for(int i = 1; i <= n; i++) list.add(i);
		for(int i = 0; i < m; i++) {
			num = scan.nextInt(); flag = false;
			while(!flag) {
				if(list.get(0) == num) {
					list.remove(0); flag = true;
				}
				else {
					if(list.indexOf(num) <= list.size()/2)
						list.add(list.size()-1, list.remove(0));
					else
						list.add(0, list.remove(list.size()-1));
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
