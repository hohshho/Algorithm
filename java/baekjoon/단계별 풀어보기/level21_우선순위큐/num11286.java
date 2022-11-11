package level21_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class num11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<abs> q = new PriorityQueue<abs>();
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int value = Integer.parseInt(br.readLine());
			if(value!=0) {
				q.offer(new abs(value));
			} else {
				if(!q.isEmpty()) {
					sb.append(q.remove().getNum());
				}else {
					sb.append("0");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		
	}

}

class abs implements Comparable<abs>{
	private int num;
	
	abs(int num){
		this.num = num;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public int compareTo(abs target) {
		if(Math.abs(target.getNum()) < Math.abs(this.num))
			return 1;
		else if(Math.abs(target.getNum()) > Math.abs(this.num))
			return -1;
		else {
			if(target.getNum() < getNum())
				return 1;
			else if(target.getNum() > getNum())
				return -1;
			else return 0;
		}
	}
}