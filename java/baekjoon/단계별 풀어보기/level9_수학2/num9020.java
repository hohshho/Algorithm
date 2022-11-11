package level9_수학2;

import java.io.*;
import java.util.*;


class node {
	int a;
	int b;
	node(int a,int b){
		this.a = a;
		this.b = b;
	}
}
public class num9020 {
	public static boolean go(int value) {
		if(value<2) return false;
		for(int i=2;i*i<=value;i++) {
			if(value%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		ArrayList<node> list = new ArrayList<node>();
		node printData;
		
		for(int i=0;i<num;i++) {
			int data=Integer.parseInt(br.readLine());
			int index = data/2;
			int a = index;
			int b = index;
			for(int j=0;j<index;j++) {
				if(go(a) == true && go(b) == true) {
					list.add(new node(a,b));
					break;
				}
				a--;
				b++;
			}
			
			
		}
		
		Iterator iter = list.iterator();
		
		while(iter.hasNext()) {
			printData = (node) iter.next();
			System.out.println(printData.a + " " + printData.b);
		}
		
	}
}
