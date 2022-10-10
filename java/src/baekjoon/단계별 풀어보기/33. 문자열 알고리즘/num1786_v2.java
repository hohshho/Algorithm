package package33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num1786_v2 {
    static int cnt;
    static ArrayList<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String pattern = br.readLine();

        KMP2(origin, pattern);
        System.out.println(cnt);
        for (int i = 0; i < cnt; i++)
            System.out.println(result.get(i));
    }

    // O(origin 길이)
    public static void KMP(String origin, String pattern) {

        int n = origin.length(), m = pattern.length();

        // begin, matched = 0 부터 탐색 시작
        int begin = 0, matched = 0;

        // 접미사도 되고 접두사도 되는 문자열의 최대 길이
        int[] pi = getPartialMatch(pattern);

        while (begin <= n - m) {
            // 만약 pattern과 origin의 글자가 일치한다면
            if (matched < m && origin.charAt(begin + matched) == pattern.charAt(matched)) {
                // pattern의 다음 글자를 비교하기 위해 pattern비교 index 값 증가
                ++matched;
                // 끝까지 비교했을 경우 일치
                if (matched == m) {
                    cnt++;
                    result.add(begin + 1);
                }
            } else {
                // 예외 : matched가 0인 경우에는 다음 칸에서부터 계속
                if (matched == 0) {
                    ++begin;
                } else {
                    begin += matched - pi[matched - 1];

                    // begin을 옮겼다고 처음부터 다시 비교할 필요가 없다.
                    // 옮긴 후에도 table[matched-1]만큼은 항상 일치하기 때문이다.
                    matched = pi[matched - 1];
                }
            }
        }
    }

    public static int[] getPartialMatch(String pattern) {
        int len = pattern.length();
        int[] pi = new int[len];

        int begin = 1, matched = 0;

        while(begin + matched < len){
            if(pattern.charAt(begin + matched) == pattern.charAt(matched)) {
                ++matched;
                pi[begin + matched - 1] = matched;
            } else {
                if(matched == 0){
                    ++begin;
                } else{
                    begin += matched - pi[matched - 1];
                    matched = pi[matched - 1];
                }
            }
        }

        return pi;

    }

    // 대응 된 문자수 matched만 유지하면서 orgin 모두 순회
    // 글자마다 matched 적절히 갱신
    public static void KMP2(String origin, String pattern) {
        int N = origin.length(), M = pattern.length();

        int[] pi = getPartialMatch2(pattern);

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
    public static int[] getPartialMatch2(String pattern) {
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
