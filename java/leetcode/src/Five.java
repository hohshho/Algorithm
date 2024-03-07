import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Five {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int[][] matrix = new int[N][N];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<input.length; j++){
                matrix[i][j] = stoi(input[j]);
            }

        }
        int[] columnSelected = new int[N];
        Arrays.fill(columnSelected, -1);

        int result = findMinSumRecursive(matrix, columnSelected, 0);
        System.out.println(result);
    }

    public static int findMinSumRecursive(int[][] matrix, int[] columnSelected, int row) {
        if (row == matrix.length) {
            int sum = 0;
            // 선택한 컬럼으로 행돌면서 전체 더함
            for (int i = 0; i < columnSelected.length; i++) {
                sum += matrix[i][columnSelected[i]];
            }
            return sum;
        }

        int answer = Integer.MAX_VALUE;
        // 순열
        for (int col = 0; col < matrix[0].length; col++) {
            if (!isColumnSelected(columnSelected, col)) {
                columnSelected[row] = col;
                answer = Math.min(answer, findMinSumRecursive(matrix, columnSelected, row + 1));
                columnSelected[row] = -1; // 다음 반복을 위해 선택 취소
            }
        }
        return answer;
    }

    public static boolean isColumnSelected(int[] columnSelected, int col) {
        for (int i = 0; i < columnSelected.length; i++) {
            if (columnSelected[i] == col) {
                return true;
            }
        }
        return false;
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
