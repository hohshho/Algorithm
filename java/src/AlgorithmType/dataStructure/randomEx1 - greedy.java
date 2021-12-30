package dataStructure;

import java.util.Scanner;

public class randomEx1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = 0;
		int x = 0;
		int y = 0;
		while (n1 >= 100000 || n1 <= 2) {
			n1 = sc.nextInt();
		}
		int[] n2 = new int[n1];

		for (int i = 0; i < n1; i++) {
			while (n2[i] >= 1000000 || n2[i] <= 0) {
				n2[i] = sc.nextInt();
			}
			if (n2[i] >= n1) {
				y++;
				continue;
			}

			if (x < n2[i]) {
				x = n2[i];
			}
		}
		if (n1 < x + y) {
			System.out.println(n1);
		} else {
			System.out.println(x + y);
		}
	}
}

//		Scanner scanner = new Scanner(System.in);
//		int n = -1;
//		int LargeN = 0;
//		int Eq = 0;
//		int max = 0;
//		while (n > 100000 || n <= 0) {
//			n = scanner.nextInt();
//		}
//		int f[] = new int[n]; // �迭�� ����� ����
//
//		for (int i = 0; i < f.length; i++) {
//			f[i] = scanner.nextInt(); // Ű���忡�� �Է¹��� ���� ����
//			if (f[i] == n) {
//				Eq++;
//				break;
//			} else if (f[i] > n)
//				LargeN++;
//			else {
//				if (max < f[i])
//					max = f[i];
//			}
//		}
//		if (Eq == 1)
//			System.out.println(n);
//		else
//			System.out.println(max + LargeN);
//
//		scanner.close();
//	}
//}
