import java.util.*;
import java.io.*;


public class fibonacciEx {
	private static int F(int n, int r[]) {
		if(n<=1) return 1;
		else if(r[n]>0) return r[n];
		else
			return r[n] = F(n-1, r) + F(n-2, r);
	}
	public static void main(String[] args) {
		int[] r = new int[100];
		System.out.println(F(6,r));
	}
	//Àç±Í ÇÔ¼ö
	
	private static int F2(int n) {
		int last1, last2,result=0;
		
		if(n<=1) {
			return 1;
		}
		
		last1 =1;
		last2 =1;
		for(int i=1;i<n;i++) {
			result = last1+last2;
			last1 = last2;
			last2 = result;
		}
		return result;
	}
}
