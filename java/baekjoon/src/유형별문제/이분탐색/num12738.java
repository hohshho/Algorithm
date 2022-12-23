package 유형별문제.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num12738 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        String[] inputArrData = br.readLine().split(" ");

        for(int i=0;i<N;i++) {
            arr[i] = stol(inputArrData[i]);
        }

        System.out.println(psearch(arr));
    }

    public static int psearch(long[] arr) {
        int start = 0;
        int end = arr.length;
        int index = 0;

        while(start<=end) {
            int mid = (start+end)/2;
            if(checkArr(arr,mid)) {
                index = mid;
                start = mid+1;
            }else {
                end = mid-1;
            }
        }

        return index;
    }

    public static boolean checkArr(long[] arr, int mid) {
        int count=0;

        for(int j = 0; j<arr.length; j++) {
            long temp = arr[j];
            for(int i =j+1;i<arr.length;i++) {
                if(arr[i]>temp) {
                    temp=arr[i];
                    count++;
                }
                if(count>=mid-1)
                    return true;
            }
        }
        return false;
    }

    public static long stol(String string) {
        return Long.parseLong(string);
    }
}

