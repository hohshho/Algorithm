import java.io.*;
import java.util.*;

public class num14499 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = stoi(st.nextToken()); // y
		int m = stoi(st.nextToken()); // x
		Map map = new Map(n, m);
		
		int curY = stoi(st.nextToken());
		int curX = stoi(st.nextToken());
		int K = stoi(st.nextToken());
		
		Dice dice = new Dice(curX, curY);
		
		for(int i=0; i<map.N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<map.M; j++) {
				map.inputValue(j, i, stoi(st.nextToken()));
			}
		}
		
		dice.changeMap(map);
	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			dice.move(map, stoi(st.nextToken()) - 1);
		}
		
		System.out.println(dice.sb.toString());
		return;
	}
	
	static class Map {
		int[][] state;
		int N, M;  // X축, Y축
		
		Map(int N, int M) {
			this.N = N;
			this.M = M;
			this.state = new int[N][M];
		}
		
		void inputValue(int x, int y, int value) {
			this.state[y][x] = value;
		}
		
		boolean checkMapArrange(int x, int y) {
			return x >= 0 && y >= 0 && x < M && y < N;
		}
	}
	
	static class Dice {
		int top, bottom, east, west, north, south;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int x, y;
		StringBuilder sb;
		
		Dice(int x, int y){
			this.top = 0;
			this.bottom = 0;
			this.east = 0;
			this.west = 0;
			this.north = 0;
			this.south = 0;
			this.x = x;
			this.y = y;
			this.sb = new StringBuilder();
		}
		
		void changeMap(Map map) {
			if(map.state[this.y][this.x] == 0) {
				map.state[this.y][this.x] = this.bottom;
				return;
			}
			
			this.bottom = map.state[this.y][this.x];
			map.state[this.y][this.x] = 0;
		}
		
		void move(Map map, int direction) {
			int nx = this.x + this.dx[direction];
			int ny = this.y + this.dy[direction];
			
			// 이동 한 칸이 밖인 경우 pass
			if(!map.checkMapArrange(nx, ny)) {
				return;
			}
			
			this.x = nx;
			this.y = ny;
			
			if(direction == 0) { // 동
				int temp = this.bottom;
				this.bottom = this.east;
				this.east = this.top;
				this.top = this.west;
				this.west = temp;
			}
			else if (direction == 1) { // 서 
				int temp = this.bottom;
				this.bottom = this.west;
				this.west = this.top;
				this.top = this.east;
				this.east = temp;
				
			}
			else if (direction == 2) { // 북 
				int temp = this.bottom;
				this.bottom = this.north;
				this.north = this.top;
				this.top = this.south;
				this.south = temp;
			}
			else if (direction == 3) { // 남 
				int temp = this.bottom;
				this.bottom = this.south;
				this.south = this.top;
				this.top = this.north;
				this.north = temp;
			}
			
			this.changeMap(map);
			
			System.out.println(this.getTop());
		}
		
		public int getTop() {
			return this.top;
		}
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
