package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num11728 {
	public static int[] mergeSort(String[] A, String[] B) {
		int mergeArrLen = A.length + B.length;
		int[] mergeArr = new int[mergeArrLen];
//		int[] aIntArr = new int[A.length];
//		int[] bIntArr = new int[B.length];
		
//		for(int i=0;i<A.length;i++) {
//			aIntArr[i] = Integer.parseInt(A[i]);
//		}
//		
//		for(int i=0;i<B.length;i++) {
//			bIntArr[i] = Integer.parseInt(B[i]);
//		}
		Arrays.sort(A);
		Arrays.sort(B);
		int asize = A.length;
		int bsize = B.length;
		int mIndex = 0;
		int aIndex = 0;
		int bIndex = 0;
		
//		for(int i=0;i<mergeArrLen;i++) {
//			if(aIndex==A.length) {
//				mergeArr[i]=Integer.parseInt(B[bIndex]);
//				bIndex++;
//			}else if(bIndex==B.length) {
//				mergeArr[i]=Integer.parseInt(A[aIndex]);
//				aIndex++;
//			}else {
//				if(Integer.parseInt(A[aIndex])<Integer.parseInt(B[bIndex])) {
//					mergeArr[i] = Integer.parseInt(A[aIndex]);
//					aIndex++;
//				}else {
//					mergeArr[i] = Integer.parseInt(B[bIndex]);
//					bIndex++;
//				}
//			}
//			
//		}
        while (aIndex< asize && bIndex< bsize){
            if(Integer.parseInt(A[aIndex]) < Integer.parseInt(B[bIndex])){
            	mergeArr[mIndex++]= Integer.parseInt(A[aIndex++]);
            }else{
            	mergeArr[mIndex++]= Integer.parseInt(B[bIndex++]);
            }
        }

        while(bIndex<bsize){
        	mergeArr[mIndex++] = Integer.parseInt(B[bIndex++]);
        }
        while(aIndex<asize){
        	mergeArr[mIndex++] = Integer.parseInt(A[aIndex++]);
        }
		
		
		return mergeArr;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arrSize = br.readLine().split(" ");
		
		String[] A = new String[Integer.parseInt(arrSize[0])];
		String[] B = new String[Integer.parseInt(arrSize[1])];
		
		A = br.readLine().split(" ");
		B = br.readLine().split(" ");
		
		int[] answer = mergeSort(A, B);
		
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i] + " ");
		}
		
		
	}

}
