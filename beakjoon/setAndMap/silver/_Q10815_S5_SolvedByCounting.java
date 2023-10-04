package beakjoon.setAndMap.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q10815_S5_SolvedByCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] cards = new int[20_000_001]; // 9,999,999 ~ 0: -1 ~ -10,000,000 / 10,000,000 ~ 20,000,000: 0 ~ 10,000,000
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            cards[Integer.parseInt(stringTokenizer.nextToken()) + 10_000_000] += 1;
        }
        int M = Integer.parseInt(bufferedReader.readLine());
        int[] answer = new int[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            if (cards[Integer.parseInt(stringTokenizer.nextToken()) + 10_000_000] > 0){
                answer[i] = 1;
            }
            else {
                answer[i] = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stringBuilder.append(answer[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
