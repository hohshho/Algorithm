package package15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class num1931 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int MAX = 0;
		
		for(int i=0;i<N;i++) {
			String[] inputData = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(inputData[0]);
			arr[i][1] = Integer.parseInt(inputData[1]);
			if(MAX<arr[i][1])
				MAX = arr[i][1];
		}
		
		Arrays.sort(arr,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		

        int count = 0;    // 최대값 변수 
        int end = -1;    // 다음시작 시간과 비교할 변수a
        for (int i = 0; i < N; i++) {
            //현재 시작시간이 이전 종료시간보다 늦을 경우 
            if (arr[i][0] >= end) {	
                end = arr[i][1];    //현재 종료시간을 다음 시작시간과 비교하기위해 저장 
                count++;
            }
        }
        System.out.println(count);
	}

}
