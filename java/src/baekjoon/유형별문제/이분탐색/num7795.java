package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num7795 {
    static int T, A[], B[], N, M, result[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = stoi(br.readLine());
        result = new int[T];

        for (int i = 0; i < T; i++) {
            String[] firstLine = br.readLine().split(" ");
            String[] aLine = br.readLine().split(" ");
            String[] bLine = br.readLine().split(" ");

            N = stoi(firstLine[0]);
            M = stoi(firstLine[1]);
            A = new int[N + 1];
            B = new int[M + 1];

            for (int j = 1; j <= N; j++) {
                A[j] = stoi(aLine[j - 1]);
            }

            for (int j = 1; j <= M; j++) {
                B[j] = stoi(bLine[j - 1]);
            }

            Arrays.sort(B);

            sb.append(Bsearch() + "\n");
        }

        System.out.println(sb.toString());
    }

    public static int Bsearch() {
        int start = 0, end = M, cnt = 0, mid = (start + end) / 2, ret = 0;

        for (int j = 1; j <= N; j++) {
            while (end >= start) {
                mid = (start + end) / 2;

                if (A[j] > B[mid]) {
                    ret = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            start = 1;
            end = M;
            cnt += ret;
            ret = 0;
        }

        return cnt;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
