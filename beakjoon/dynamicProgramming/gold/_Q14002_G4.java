package beakjoon.dynamicProgramming.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _Q14002_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(max).append(System.lineSeparator());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            if (max == dp[i]) {
                max--;
                deque.push(numbers[i]);
            }
        }
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pop()).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
