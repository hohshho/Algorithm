package level25_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num1644 {
	static int N, sum = 0, s = 0, e = 0, count = 0;
	static boolean primeCheckArr[];
	static ArrayList<Integer> primeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		primeCheckArr = new boolean[N+1];        
        primeList = new ArrayList<Integer>();
        
        getPrimeNumber();
        
        getCountResult();
        
        System.out.println(count);
		
	}
	
	public static void getCountResult() {
		while(true) {
			if(sum>=N) sum-=primeList.get(s++);
			else if(e == primeList.size()) break;
			else sum+=primeList.get(e++);
			if(sum == N) count++;	
		}
	}
	
	public static void getPrimeNumber() {
		primeCheckArr[0] = primeCheckArr[1] = true;  
		
        for(int i=2; i*i<=N; i++){
            if(!primeCheckArr[i]) {
            	for(int j=i*i; j<=N; j+=i)
            		primeCheckArr[j]=true;                
            }
        }
        
        for(int i=1; i<=N;i++){
        	if(!primeCheckArr[i]) primeList.add(i); 
        }
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
