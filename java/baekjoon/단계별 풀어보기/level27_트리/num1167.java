package level27_트리;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 

public class num1167 {
    static int n, max = 0;
    static Point maxP;
    static boolean visit[];
    static List<Point>[] arrList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arrList = new ArrayList[n+1];
        visit = new boolean[n+1];
        StringTokenizer st;
        for(int i=0; i<n+1; i++)
            arrList[i] = new ArrayList<>();
        	for(int i=0; i<n; i++) {
        		st = new StringTokenizer(br.readLine());
        		int index = Integer.parseInt(st.nextToken());
        		int next = Integer.parseInt(st.nextToken());
        		int val = Integer.parseInt(st.nextToken());

        		arrList[index].add(new Point(next, val));
        		arrList[next].add(new Point(index, val));
        		int tmp = Integer.parseInt(st.nextToken());

        		while(tmp!=-1) {
        			next = tmp;
        			val = Integer.parseInt(st.nextToken());
        			arrList[index].add(new Point(next,val));
        			arrList[next].add(new Point(index, val));
        			tmp = Integer.parseInt(st.nextToken());
        		}
        	}
        	Point tmp = dfs(arrList[1].get(0), 0);
        	visit = new boolean[n+1];
        	maxP = null;
        	max = 0;
        	dfs(tmp, 0);
        	System.out.println(max);
    }

    private static Point dfs(Point p, int val) {
        visit[p.x] = true;
        for(Point t : arrList[p.x]) {
            if(!visit[t.x])
                dfs(t, val+t.y);
        }
        if(max < val) {
            max = val;
            maxP = p;
        }
        return maxP;
    }
}