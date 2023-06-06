package 유형별문제.최단거리.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class num13168 {
    static int N, R, M, K, INF = 987654321, passMin = 0, nopassMin = 0;
    static HashMap<String, Integer> discount;
    static HashMap<String, Integer> cityMap = new HashMap<>();
    static double[][] dist, discountDist;
    static int[] tripList;
    static HashSet<Integer> visited;
    static HashSet<Integer> visitedIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        R = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String cityName = st.nextToken();
            cityMap.put(cityName, i);
        }

        M = stoi(br.readLine());
        tripList = new int[M];

        initDiscount();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            tripList[i] = cityMap.get(st.nextToken());
        }

        K = stoi(br.readLine());

        dist = new double[N][N];
        discountDist = new double[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
            Arrays.fill(discountDist[i], INF);
            dist[i][i] = 0;
            discountDist[i][i] = 0;
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String vehicle = st.nextToken();
            int startCityIndex = cityMap.get(st.nextToken());
            int endCityIndex = cityMap.get(st.nextToken());
            double weight = stoi(st.nextToken());

            dist[startCityIndex][endCityIndex] = Math.min(weight, dist[startCityIndex][endCityIndex]);
            dist[endCityIndex][startCityIndex] = Math.min(weight, dist[endCityIndex][startCityIndex]);

            if (discount.containsKey(vehicle)) {
                if(discount.get(vehicle) == 0) weight = 0;
                else weight = weight/discount.get(vehicle);
            }

            discountDist[startCityIndex][endCityIndex] = Math.min(weight, discountDist[startCityIndex][endCityIndex]);
            discountDist[endCityIndex][startCityIndex] = Math.min(weight, discountDist[endCityIndex][startCityIndex]);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i==j || j==k) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    dist[j][i] = Math.min(dist[j][i], dist[j][k] + dist[k][i]);
                    discountDist[i][j] = Math.min(discountDist[i][j], discountDist[i][k] + discountDist[k][j]);
                    discountDist[j][i] = Math.min(discountDist[j][i], discountDist[j][k] + discountDist[k][i]);
                }
            }
        }

        for (int i = 1; i < M; i++) {
            int pre = tripList[i - 1];
            int cur = tripList[i];
            nopassMin += dist[pre][cur];
            passMin += discountDist[pre][cur];
        }

        System.out.println(passMin + R >= nopassMin ? "No" : "Yes");

    }

    public static void initDiscount() {
        discount = new HashMap<>();
        discount.put("Mugunghwa", 0);
        discount.put("ITX-Saemaeul", 0);
        discount.put("ITX-Cheongchun", 0);
        discount.put("V-Train", 2);
        discount.put("S-Train", 2);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
