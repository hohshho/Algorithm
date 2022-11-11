package save;

public class kSolution3 {
    public int solution(int[] arr) {
        if (arr.length <= 2) {
            return arr.length;
        }

        int ans = 2;
        int temp_ans = 2;

        for (int i = 2; i < arr.length ; ++i) {
            if (arr[i] == arr[i - 2]) {
                temp_ans = temp_ans + 1;
            } else {
                temp_ans = 2;
            }

            ans = Math.max(temp_ans, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        kSolution3 a = new kSolution3();
        System.out.println(a.solution(new int[]{7, -5, -5, -5, 7, -1, 7}));
        System.out.println(a.solution(new int[]{7, 4, -2, 4, -2, -9}));
    }
}

//https://stackoverflow.com/questions/58357037/the-longest-sub-array-with-switching-elements