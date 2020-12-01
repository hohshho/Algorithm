package package14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

public class num10870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] data = new int[N][2];
		
		LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<Integer, Integer>();
		int [] indexCount = new int[200001];
		ArrayList<Integer> index = new ArrayList<Integer>();
		int indexI = 0;
		
		for(int i=0;i<N;i++) {
			String inputData = br.readLine();
			String[] inputSplitData = inputData.split(" ");
			int x = Integer.parseInt(inputSplitData[0]);
			int y = Integer.parseInt(inputSplitData[1]);
			
			if(hm.isEmpty()) {
				index.add(x);
				indexI++;
				indexCount[x]++;
				hm.put(x,y);
			}else {
				indexCount[x]++;
				hm.put(x,y);
			}
		}
		Collections.sort(index);
		int dataIndex=0;
		for(int i=0;i<indexI;i++) {
			if(indexCount[index.get(i)] == 1) {
				data[dataIndex][0] = index.get(i);
				data[dataIndex][1] = hm.get(index.get(i));
				dataIndex++;
			}else {
				int[] yArray = new int[indexCount[index.get(i)]];
				for(int j=0;j<indexCount[index.get(i)];j++) {
					yArray[j] = hm.get(index.get(i));
				}
				Arrays.sort(yArray);
				for(int j=0;j<indexCount[index.get(i)];j++) {
					data[dataIndex][0] = index.get(i);
					data[dataIndex][1] = yArray[j];
					dataIndex++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.println(data[i][0] + " " + data[i][1]);
		}
	}
}
