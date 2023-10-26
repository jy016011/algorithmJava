package beakjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Q15903_S1_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        long[] cards = new long[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Long.parseLong(stringTokenizer.nextToken());
        }
        for (int i = 0; i < m; i++) {
            long sum = 0;
            Arrays.sort(cards);
            sum = cards[0] + cards[1];
            cards[0] = cards[1] = sum;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cards[i];
        }
        System.out.println(sum);
    }
}
