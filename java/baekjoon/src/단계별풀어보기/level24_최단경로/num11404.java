package 단계별풀어보기.level24_최단경로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num11404 {
	static int N, M, INF = 100000000;
	static int[][] dis;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		
		dis = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dis[i][j] = i == j ? 0 : INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			String[] abc = br.readLine().split(" ");
			int a = stoi(abc[0])-1;
			int b = stoi(abc[1])-1;
			int c = stoi(abc[2]);
			
			dis[a][b] = Math.min(dis[a][b], c);
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dis[i][j] = Math.min(dis[i][j], dis[i][k] +dis[k][j]);
				}
			}
		}
		
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            	dis[i][j] = dis[i][j] == INF ? 0 : dis[i][j];
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