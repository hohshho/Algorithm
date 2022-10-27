package level29_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class num17472 {
	static int N, M, landCount=0, result = 0, cnt=0;
	static int[] parent;
	static int[][] map;
	static int[] dx = new int[]{0,0,1,-1};
	static int[] dy = new int[]{1,-1,0,0};
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] NM = br.readLine().split(" ");
		
		N = stoi(NM[0]);
		M = stoi(NM[1]);
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String[] mapData = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = stoi(mapData[j]);
			}
		}
		
		checkLand();
		
		parent = new int[landCount+1];
		for(int i=0; i<=landCount; i++) {
			parent[i] = i;
		}
		
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0) {
                    makeBridge(i, j, map[i][j]);
                }
            }
        }
        
        int size = pq.size();
	    for(int i=0; i<size; i++) {
	    	Edge temp = pq.poll();
	    	int a = temp.s;
	    	int b = temp.e;
	    	if(!union(a, b))		
	    		continue;
	    	union(temp.s, temp.e);
	    	result+= temp.w;
	    	cnt++;
	    }
	    if(result == 0 || cnt != landCount-1) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
	}
	
	static void makeBridge(int x, int y, int landNum) {
        int newX = x;
        int newY = y;
		int length = 0;
        
        for(int i=0; i<4; i++) {
            while(true) {
                newX = newX + dx[i];
                newY = newY + dy[i];
                
                if(isPossibleIndex(newX, newY)) {
                    if(map[newX][newY] == landNum) {
                        length = 0;
                        newX = x;
                        newY = y;
                        break;
                    } else if(map[newX][newY] == 0){
                        length++;
                    } else {
                        if(length > 1) {
                        	pq.add(new Edge(landNum, map[newX][newY], length));
                        }
                        length = 0;
                        newX = x;
                        newY = y;
                        break;
                    }
                } else {
                    length = 0;
                    newX = x;
                    newY = y;
                    break;
                }
            }
        }	
	}
	
	static class Edge implements Comparable<Edge>{
		int s, e, w;
		Edge(int s, int e, int w){
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return o.w >= this.w ? -1 : 1;
		}
	}
	
	public static int find_parent(int num) {
		if(parent[num] != num)
			return parent[num] = find_parent(parent[num]);
		return parent[num];
	}
	
	public static boolean union(int a, int b) {
		a = find_parent(a);
		b = find_parent(b);
		
		if(a==b) {
			return false;
		}
		else if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
		return true;
	}
	
	public static void checkLand() {
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					landCount++;
					dfs(i, j, visited);
				}
			}
		}
		
	}
	
	public static void dfs(int x, int y, boolean[][] visited) {
		map[x][y] = landCount;
		for(int i=0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(isPossibleIndex(newX, newY) && !visited[newX][newY] && map[newX][newY] != 0) {
				visited[x + dx[i]][y + dy[i]] = true;
				map[newX][newY] = landCount;
				dfs(x + dx[i], y + dy[i], visited);
			}
		}
	}
	
	public static boolean isPossibleIndex(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M ? true : false;
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
