package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num2613 {

	static int N, M, result;
	static int[] list;
	static int[] countList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputNM = br.readLine().split(" ");
		N = stoi(inputNM[0]);
		M = stoi(inputNM[1]);

		list = new int[N];
		countList = new int[M + 1];
		String[] listData = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			list[i] = stoi(listData[i]);
		}

		parametric();
		System.out.println(result);
		deleteZero();
		
		for (int i = 0; i < M; i++) {
			System.out.print(countList[i] + " ");
		}
	}
	
	private static void parametric() {
		int start = 0;
		int end = N * 100;

		while (start <= end) {
			int mid = (start + end)/2;
			if (isPossible(mid)) {
				result = mid;
				end = mid-1;
			} else {
				start = mid + 1;
			}
		}
	}

	private static boolean isPossible(int mid) {
		int count = 0;
		int tempSum = 0;
		int[] tempCount = new int[M + 1];
		for (int i = 0; i < N; i++) {
			if (list[i] > mid) {
				return false;
			}
			if (tempSum + list[i] > mid) {
				tempSum = list[i];
				count++;
			} else {
				tempSum += list[i];
			}
			if (count >= M) {
				return false;
			}
			tempCount[count]++;
		}
		countList = tempCount;
		return true;

	}
	
	private static void deleteZero() {
		int index;
		for (int i = 0; i < M; i++) {
			if (countList[i] == 0) {
				index = i - 1;
				countList[i]++;
				while (true) {
					if (countList[index] == 1) {
						index--;
						continue;
					}
					break;
				}
				countList[index]--;
			}
		}
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}