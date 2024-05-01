import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 17:22 분 시작
public class num17244 {
	// 동, 서, 남, 북
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int N, M, result = 0;
	static char[][] map;
	static int[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken()); // x축
		M = stoi(st.nextToken()); // y축
		
		map = new char[M][N];
		visited = new int[M][N];
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i = 0; i < M; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				char cur = line[j];
				map[j][i] = cur;
				
				if(cur == 'S') {
					
				}
				else if (cur == 'E') {
					
				}
				else if (cur == 'X') {
					
				}
			}
		}
		
		
		
		System.out.println(result);
		return;
	}
	
	static class Node{
		int x, y, cnt;
		Node(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	boolean checkMapArrange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
