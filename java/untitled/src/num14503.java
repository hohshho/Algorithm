import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16:46분 시작 / 종료 17:17분 / 31분 소요
public class num14503 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Rooms rooms = new Rooms(stoi(st.nextToken()), stoi(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		
		Robot robot = new Robot(
					stoi(st.nextToken()), 
					stoi(st.nextToken()), 
					stoi(st.nextToken()));
		
		for(int i=0; i<rooms.N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<rooms.M; j++) {
				rooms.addState(j, i, stoi(st.nextToken()));
			}
		}
		
		robot.run(rooms);
		
		System.out.println(robot.cleanRoomsCnt);
	}
	
	static class Rooms {
		// y축, x축 
		int N, M;
		int[][] state;
		
		Rooms(int N, int M) {
			this.N = N;
			this.M = M;
			this.state = new int[N][M];
		}
		
		void addState(int x, int y, int value) {
			this.state[y][x] = value;
		}
		
		boolean checkMapArrange(int x, int y) {
			return x >= 0 && y >= 0 && y < N && x < M;
		}
	}
	
	static class Robot {
		// 북, 동, 남, 서 
		int[] dx = {0, 1, 0, -1}; 
		int[] dy = {-1, 0, 1, 0};
		int direction, curX, curY;
		int cleanRoomsCnt = 0;
		
		Robot(int curY, int curX, int direction){
			this.direction = direction;
			this.curX = curX;
			this.curY = curY;
		}
		
		void run(Rooms rooms) {
			while(true) {
				// 1. 청소 된 칸 검사
				if(rooms.state[this.curY][this.curX] == 0) {
					rooms.state[this.curY][this.curX] = 2;
					this.cleanRoomsCnt += 1;
				}
			
				if(this.checkClean(rooms)) {
					// 3. 청소되지 않는칸이 있는 경우
					// 3.1 반시계 방향으로 회전
					this.direction -= 1;
					if(direction == -1) {
						this.direction = 3;
					}
				
					// 3.2. 앞쪽칸이 청소되지 않은 경우 한칸 전진
					int nx = dx[this.direction] + this.curX;
					int ny = dy[this.direction] + this.curY;
					if(rooms.state[ny][nx] == 0) {
						this.curX = nx;
						this.curY = ny;
					}
					
					continue;
				} 
				else {
					// 2. 청소 되지않는 칸 없는 경우
					
					int backDirection = (this.direction + 2) % 4;
					int nx = this.dx[backDirection] + this.curX;
					int ny = this.dy[backDirection] + this.curY;
					// 2.2 뒤쪽 칸이 벽이라 후진 못하는 경우 아예 종료
					if(rooms.state[ny][nx] == 1) return;
					
					// 2.1 후진 가능할 경우 후진 후 continue;
					this.curX = nx;
					this.curY = ny;
				}
				
			}
		}
		
		boolean checkClean(Rooms rooms) {
			// 0 : 청소 가능, 1 : 청소 불가능 하지만 후진 가능, 2 : 작동 종료 
			int result = 0;
			
			for(int i=0; i<4; i++) {
				int nx = this.dx[i] + this.curX;
				int ny = this.dy[i] + this.curY;
				
				if(!rooms.checkMapArrange(nx, ny)) continue;
				
				if(rooms.state[ny][nx] == 0) return true;
			}
			
			return false;
		}
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
