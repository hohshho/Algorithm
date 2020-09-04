package package9;

import java.util.Scanner;

public class num1002 {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int x = in.nextInt();
			int y = in.nextInt();
			int w = in.nextInt();
			int h = in.nextInt();
			
			System.out.println(Math.min(Math.min(w-x, x),Math.min(h-y, y)));
			
		}
	
}
