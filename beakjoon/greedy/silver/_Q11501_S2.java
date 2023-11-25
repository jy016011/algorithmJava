package beakjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q11501_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] stocks = new int[N];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int max = 0;
            for (int i = 0; i < N; i++) {
                int stock = Integer.parseInt(stringTokenizer.nextToken());
                stocks[i] = stock;
            }
            long totalBenefits = 0;
            for (int i = N - 1; i >= 0 ; i--) {
                if (stocks[i] > max){
                    max = stocks[i];
                    continue;
                }
                totalBenefits += max - stocks[i];
            }
            stringBuilder.append(totalBenefits).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
