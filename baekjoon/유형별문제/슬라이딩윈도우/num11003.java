package slidingWindow;

import java.io.*;
import java.util.*;

public class num11003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = stoi(st.nextToken());
        int L = stoi(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
        	arr[i] = stoi(st.nextToken());
            if (!deque.isEmpty() && deque.getFirst() <= i - L) {
            	deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[deque.getLast()] > arr[i]) {
            	deque.removeLast();
            }
            deque.addLast(i);
            sb.append(arr[deque.peekFirst()] + " ");
        }
        bw.write(sb.toString());
		bw.flush();
		bw.close();
    }
    
    public static int stoi(String string) {
    	return Integer.parseInt(string);
    }
}