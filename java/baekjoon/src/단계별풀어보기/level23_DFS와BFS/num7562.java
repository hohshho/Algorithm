package 단계별풀어보기.level23_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class num7562 {
    static int moveX[] = {1,2,2,1,-1,-2,-2,-1};
    static int moveY[] = {-2,-1,1,2,2,1,-1,-2};
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];
            int currentX, currentY, targetX, targetY;
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            currentX = Integer.parseInt(st.nextToken());
            currentY = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());
            
            Point start = new Point(currentX,currentY);
            Point target = new Point(targetX, targetY);
            
            bfs(start, target, arr);
        }
    }
 
    private static void bfs(Point start, Point target, int[][] arr) {
        Queue<Point> queue =new LinkedList<Point>();
        queue.add(start);
        boolean visit[][] = new boolean[arr.length][arr.length];
        visit[start.y][start.x] = true;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.y==target.y && p.x==target.x) {
                System.out.println(arr[p.y][p.x]);
                return;
            }
            
            for(int d=0; d<8; d++) {
                int newY = p.y + moveY[d];
                int newX = p.x + moveX[d];
                if(0<=newX && newX<arr.length && 0<=newY && newY<arr.length && !visit[newY][newX]) {
                    visit[newY][newX] = true;
                    arr[newY][newX] = arr[p.y][p.x] + 1;
                    queue.add(new Point(newX,newY));
                }
            }
        }
    }
}
class Point {
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
 
