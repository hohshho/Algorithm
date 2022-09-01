package package23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num7569 {
	static int m,n,k;
	static int[] dx = new int[] {1,-1,0,0,0,0};
	static int[] dy = new int[] {0,0,1,-1,0,0};
	static int[] dz = new int[] {0,0,0,0,1,-1};
	static int[][][] arr;
	static int max=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mnk = br.readLine().split(" ");
		n=Integer.parseInt(mnk[0]);
		m=Integer.parseInt(mnk[1]);
		k=Integer.parseInt(mnk[2]);
		
		arr = new int[m][n][k];
		Queue<int[]>q = new LinkedList<>();
		
		for(int i=0; i<k; i++) {
			for(int j=0; j<m; j++) {
				String[] mn = br.readLine().split(" ");
				for(int l=0; l<n; l++) {
					arr[j][l][i] = Integer.parseInt(mn[l]);
					if(arr[j][l][i] == 1) {
						q.offer(new int[] {j,l,i});
					}
				}
			}
		}
		bfs(q);
		outer : for(int i=0; i<k; i++) {
			for(int j=0; j<m; j++) {
				for(int l=0; l<n; l++) {
					if(arr[j][l][i] == 0) {
						max = -1;
						break outer;
					}
					max = max > arr[j][l][i] ? max : arr[j][l][i];
				}
			}
		}
		if(max!=-1)
			System.out.println(max-1);
		else
			System.out.println(max);
	}
	public static void bfs(Queue<int[]> q) {
		while(!q.isEmpty()) {
			int[] point = q.poll();
	          for (int i = 0; i < 6; i++) {
	              int nx = point[0] + dx[i];
	              int ny = point[1] + dy[i];
	              int nz = point[2] + dz[i];
	              if (nx>=0 && ny>=0 && nz>=0 && nx<m && ny<n && nz<k) {
	                  if (arr[nx][ny][nz] == 0) {
	                      arr[nx][ny][nz] = arr[point[0]][point[1]][point[2]] + 1;
	                      q.offer(new int[]{nx, ny, nz});
	                      max = arr[nx][ny][nz] > max ? arr[nx][ny][nz]:max;
	                  }
	              }
	          }
		}
		
	}

}
