package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class num13913 {
	static int N, K;
	// 위치 저장
    private static int[] visited = new int[100001];
    // 이전 노드 저장
    private static int[] parent = new int[100001];
    static int INF = 100000;
    static Queue<Integer> q = new LinkedList<Integer>();
    // 출력용
    static Stack<Integer> path = new Stack<Integer>();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		
		N = stoi(input.nextToken());
		K = stoi(input.nextToken());
		
		// 초기값 설정
	    q.add(N);
	    visited[N] = 1;
		bfs();
		
		System.out.println(visited[K] - 1);
		
		while(!path.isEmpty()) {
			System.out.print(path.pop() + " ");
		}
	}
	
	public static void bfs() {
		 
		while(true) {
			int cur = q.poll();

            if(chkLocation(cur - 1)){
                q.add(cur - 1);
                visited[cur-1] = visited[cur] + 1;
                parent[cur-1] = cur;
            }

            if(chkLocation(cur + 1)){
                q.add(cur + 1);
                visited[cur + 1] = visited[cur] + 1;
                parent[cur + 1] = cur;
            }

            if(chkLocation(cur * 2)){
                q.add(cur * 2);
                visited[cur * 2] = visited[cur] + 1;
                parent[cur * 2] = cur;
            }

            // 동생 위치에 0이 아니면 최단 거리로 값이 저장된 상황
            if(visited[K] != 0) {
                int curIdx = K;

                // 경로 추적 후 저장
                while(curIdx != N){
                    path.push(curIdx);
                    curIdx = parent[curIdx];
                }

                // 시작 노드 추가
                path.push(curIdx);
                return;
            }
		}
	}
	
	public static boolean chkLocation(int location) {
		// 사용할 수 있는 위치인지 체크
		if(location < 0 || location > INF) {
			return false;
		}

		// 방문한 경우 체크
		if(visited[location] != 0) {
			return false;
		}
		
		return true;
	} 
	
	public static int stoi(String data) {
		return Integer.parseInt(data);
	}
}
