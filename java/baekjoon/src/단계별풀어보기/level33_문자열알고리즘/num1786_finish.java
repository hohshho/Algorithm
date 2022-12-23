package 단계별풀어보기.level33_문자열알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num1786_finish {
    static int cnt;
    static ArrayList<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String pattern = br.readLine();

        KMP(origin, pattern);

        System.out.println(cnt);
        for (int i = 0; i < cnt; i++)
            System.out.println(result.get(i));
    }

    // 대응 된 문자수 matched만 유지하면서 orgin 모두 순회
    // 글자마다 matched 적절히 갱신
    public static void KMP(String origin, String pattern) {
        int N = origin.length(), M = pattern.length();

        int[] pi = getPartialMatch(pattern);

        // 현재 대응된 글자 수
        int j = 0;

        for(int i=0; i< N; i++){ // i = begin + matched
            while(j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            //글자 대응 될 경우
            if(origin.charAt(i) == pattern.charAt(j)){
                // 전체 대응
                if(j == M - 1){
                    ++cnt;
                    result.add(i - j + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }

    // O(pattern 길이)
    // 접두사, 접미사 일치 테이블 계산
    public static int[] getPartialMatch(String pattern) {
        // 초기화
        int len = pattern.length();
        int[] pi = new int[len];
        int j = 0;

        for (int i = 1; i < len; i++) {
            // 맞는 위치가 나올 때 까지 j - 1칸의 공통 부분 위치로 이동
            // j-1 까지 접두사와 접미사가 일치
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            // 맞는 경우
            if (pattern.charAt(i) == pattern.charAt(j))
                // 공통 문자열의 길이는 j의 위치(배열의 index) + 1
                pi[i] = ++j;
        }

        return pi;
    }
}
