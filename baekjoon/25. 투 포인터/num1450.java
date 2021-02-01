package package25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class num1450 {
	static int N, C, count =0, index;
	static int[] arr;
	static ArrayList<Integer> left, right;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NC = br.readLine().split(" ");
		N = stoi(NC[0]);
		C = stoi(NC[1]);
		arr = new int[N];
		
		String[] arrData = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = stoi(arrData[i]);
		}
		
		left = new ArrayList<Integer>();
		right = new ArrayList<Integer>();
		
		calcPart(0,N/2,0,left);
		calcPart(N/2+1,N-1,0,right);
		
		Collections.sort(left);
		Collections.sort(right);
		
		for (int i = 0; i < left.size(); i++) {
            index = -1;
            binarySearch(0, right.size() - 1, left.get(i));
            count += index + 1;
		}
		
		System.out.println(count);
	}
	
    static void binarySearch(int start, int end, int val) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;

        if (right.get(mid) + val <= C) {
            index = mid;
            binarySearch(mid + 1, end, val);
        } else {
            binarySearch(start, mid - 1, val);
        }
    }

	public static void calcPart(int s, int e, int sum, ArrayList<Integer> list) {
		if (sum > C) return;
		if (s > e) {
			list.add(sum);
			return;
		}
		calcPart(s + 1, e, sum, list);
		calcPart(s + 1, e, sum + arr[s], list);
	}

	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
