package level22_동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num11066 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int dataLen = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			String[] arrData = br.readLine().split(" ");
			
			for(int j=0; j<dataLen; j++) {
				list.add(Integer.parseInt(arrData[j]));
			}
			
			int result = sumPage(list,1,dataLen,0);
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}

	public static int sumPage(ArrayList<Integer> list, int depth, int dataLen, int result) {
		
		int minIndex=0, minIndex2=0,sumValue;
		int minValue=501, minValue2=501;
		if(depth == dataLen)
			return result;
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i)<minValue2) {
				minIndex2 = i;
				minValue2 = list.get(i);
				if(minValue2<minValue) {
					int temp = minIndex2;
					int temp2 = minValue2;
					minIndex2 = minIndex;
					minValue2 = minValue;
					minIndex = temp;
					minValue = temp2;
				}
			}
		}
		
		if(minIndex>minIndex2) {
			sumValue= list.remove(minIndex) + list.remove(minIndex2);
		}else {
			sumValue= list.remove(minIndex2) + list.remove(minIndex);
		}
		list.add(sumValue);
		
		return sumPage(list,depth+1,dataLen,result+sumValue);
	}
}
