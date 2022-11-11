package save;

public class kSolution2 {
    static boolean visited[];
    static int res = 0;

    public int solution(int[] T, int[] skills) {
        visited = new boolean[T.length];

        for (int n : skills) {
                check(T, n);
        }

        return res;
    }

    public static void check(int[] T, int n){
        if(T[n] == n) {
            if(visited[n] == false) {
                visited[n] = true;
                res++;
            }
            return;
        }

        if(visited[n] == false) {
            res++;
            visited[n] = true;
            check(T, T[n]);
        }
    }

    public static void main(String[] args) {
        kSolution2 a = new kSolution2();
        System.out.println(a.solution(new int[]{0, 0, 1, 2}, new int[] {2}));
//        System.out.println(a.solution(new int[]{0, 3, 0, 0, 5, 0, 5}, new int[] {4, 2, 6, 1, 0}));
    }
}

