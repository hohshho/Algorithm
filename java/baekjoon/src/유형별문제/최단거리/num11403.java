package 유형별문제.최단거리;

import java.io.*;

public class num11403 {
	static int INF = 1000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = stoi(br.readLine());
		int[][] dis = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dis[i][j] = INF;
			}
		}
		
		for(int i=0; i<N; i++) {
			String[] inputData = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				dis[i][j] = stoi(inputData[j]);
				if(dis[i][j] == 0) dis[i][j] = INF;
			}
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
				}
			}
		}
		
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            	dis[i][j] = dis[i][j] == INF ? 0 : 1;
                sb.append(dis[i][j] + " ");
            }
            sb.append("\n");
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
		
	}
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
