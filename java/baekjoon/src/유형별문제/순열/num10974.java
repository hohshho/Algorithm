package 유형별문제.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num10974 {
    public static void main(String[] args) throws NumberFormatException, IOException {
//    	int[] list = new int[]{5,4,3};
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] list = new int[N];
    	
    	for(int i=0;i<N;i++) {
    		list[i] = i+1;
    	}
    	// #1 시작 조건에 맞게 list 오름차순 정렬 (시작조건)
    	Arrays.sort(list);
    	permutation(list);
    }
    // #2 처음 list값 print 후, 다음 순열 찾음
    public static void permutation(int[] list) {
        int[] curArray = list;
        while (true) {
        	printArray(curArray);
        	curArray = nextPermutation(curArray);
            if (curArray == null) {
                break;
            }
        }
    }
    
    public static int[] nextPermutation(int[] list) {
    	  // #3 수열의 바로 앞 값 보다 큰 값 중 가장 큰 index 찾는다. 
        // (가장 적은 차이로 순서를 바꾸기 위해서 가장 큰 index를 찾음) 
        int i = list.length -1;
        while(i>0 && list[i-1] >= list[i])
        	i--;
        
        // #6 list가 내림차순으로 정렬되어 있으면 순열을 끝까지 찾은 것 (종료조건)
        if(i<=0)
        	return null;
        
        int j = list.length -1;
        // #4 다음 수열의 특징 : 이전 순열보다 값이 큼
        // -> list[i-1] < list[j] 값을 찾고, 값을 바꿔준다.
        while(list[j] <= list[i-1])
        	j--;
        
        int temp = list[i-1];
        list[i - 1] = list[j];
        list[j] = temp;
        // #5 a[i] 이후 부분을 오름차순으로 셋팅 
        j= list.length-1;
        while (i < j) {
            temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            i++;
            j--;
        }
        
        return list;
    }
    
    public static void printArray(int[] array) {
    	for(int i=0;i<array.length;i++)
    		System.out.print(array[i] + " ");
    	System.out.println();
    }
    
}