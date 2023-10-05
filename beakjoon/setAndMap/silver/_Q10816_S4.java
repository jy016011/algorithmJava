package beakjoon.setAndMap.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q10816_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] cards = new int[20_000_001];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int cardNum = Integer.parseInt(stringTokenizer.nextToken());
            cards[cardNum + 10_000_000] += 1;
        }
        int M = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(cards[target + 10_000_000]).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
