package level26_동적계획법과최단거리역추적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num11780 {
	static int N, M, INF = 100000000;
	static int[][] dist, next;
	static boolean[][] visited;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		dist = new int[N][N];
		next = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dist[i][j] = i == j ? 0 : INF;
				next[i][j] = INF;
			}
		}
				
		for(int i=0; i<M; i++) {
			String[] abc = br.readLine().split(" ");
			int a = stoi(abc[0])-1;
			int b = stoi(abc[1])-1;
			int c = stoi(abc[2]);
			
			dist[a][b] = Math.min(dist[a][b], c);
			next[a][b] = a;
		}
		
		floyd();
		
		printPath();
	}
	
	public static void floyd() {
		for(int k = 0; k<N; k++) {
			for(int i = 0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] +dist[k][j];
						next[i][j] = next[k][j];
					}
				}
			}
		}
	}
	
	public static void printPath() {
		for(int[] a : dist) {
			for(int b: a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(next[i][j]==INF)
                    System.out.println(0);

                else {
                	stack = new Stack<>();
                    int pre = j;
                    stack.push(j);
                    while(i != next[i][pre]) {
                        pre = next[i][pre];
                        stack.push(pre);
                    }
                    System.out.print((stack.size()+1)+" ");
                    System.out.print(i+1+" ");
                    while(!stack.empty())
                        System.out.print(stack.pop()+1+" ");
                    System.out.println();
                }
            }
        }
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
	
}
