package package21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class num11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<numArr> q = new PriorityQueue<numArr>();
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int value = Integer.parseInt(br.readLine());
			if(value!=0)
				q.offer(new numArr(value));
			else {
				if(!q.isEmpty()) {
					sb.append(q.poll().getNum());
				}else {
					sb.append("0");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}

class numArr implements Comparable<numArr>{
	private int num;
	public numArr(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return this.num;
	}
	
	@Override
	public int compareTo(numArr o) {
		if(this.num > o.getNum()) return -1;
		else if(this.num < o.getNum()) return 1;
		else return 0;
	}
}