package dataStructure;

import java.util.*;
import java.io.*;

public class random2Ex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		int num1 = Integer.parseInt(num);
		int num2 =0;
		String[] array_word;
		int[] x = new int[10];
		int[] x2 = new int[10];
		int count = 0;
		array_word = num.split("");
		for (int i = 0; i < array_word.length; i++) {
			x[i] = Integer.parseInt(array_word[i]);
			count++;
		}
		System.out.println(array_word);
		if (x[0] == 0) {
			System.out.println(1);
			return;
		}
		
		for(int i =1; i<count+1;i++) {
			
		}
//		if(num1==0) {
//			System.out.println(1);
//		}else if(num1>0 && num1<11) {
//			System.out.println(1);
//		}else if(num1>=11 && num1<111) {
//			System.out.println(2);
//		}else if(num1>=111 && num1<1110) {
//			System.out.println(3);
//		}else if(num1>=1111 && num1<11110) {
//			System.out.println(4);
//		}else if(num1>=11111 && num1 < 111110) {
//			System.out.println(5);
//		}else if(num1>=111111 && num1 < 1111110) {
//			System.out.println(6);
//		}else if(num1>=1111111 && num1 < 11111110) {
//			System.out.println(7);
//		}else if(num1>=11111111 && num1 < 111111110) {
//			System.out.println(8);
//		}else if(num1>=111111111 && num1 < 1111111110) {
//			System.out.println(9);
//		}
		

	}
}

//		for (int i = 0; i < x.length; i++) {
//			if (x[i] >= 1) {
//				count++;
//			}
//
//		}		
//		else if (count2 > count)
//			if(x[0]>=2)
//				System.out.println(count2);
//			else
//				System.out.println(count2-1);
//		else
//			System.out.println(count);
//
//	}
