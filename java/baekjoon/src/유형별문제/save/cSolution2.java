package 유형별문제.save;

public class cSolution2 {
    static long max = 0, min = Integer.MAX_VALUE;
    /*
     * Complete the 'findRange' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER num as parameter.
     */

    public static long findRange(String num) {
        getMaxMinNum(num);

        return max - min;
    }

    public static void getMaxMinNum(String num) {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i == j) continue;

                String result = replacePart(num, itos(i), itos(j));

                max = Math.max(max, stol(result));

                if (ltos(stol(result)).length() != num.length() || result.equals("0")) continue;

                min = Math.min(min, stol(result));
            }
        }
    }

    public static String replacePart(String s, String pre, String next) {
        return s.replace(pre, next);
    }

    public static String itos(Integer n) {
        return Integer.toString(n);
    }

    public static String ltos(Long n) {
        return Long.toString(n);
    }

    public static long stol(String s) {
        return Long.parseLong(s);
    }

    public static void main(String[] args) {

        long result = cSolution2.findRange("9");

        System.out.println(result);
    }
}

