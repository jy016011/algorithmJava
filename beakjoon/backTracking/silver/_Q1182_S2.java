package beakjoon.backTracking.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1182_S2 {
    private static int N, S, result;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new int[N];
        S = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int limit = 1; limit <= N; limit++) {
            backTracking(0, 0, 0, limit);
        }
        System.out.println(result);
    }

    private static void backTracking(int depth, int index, int sum, int limit) {
        if (depth == limit) {
            if (sum == S) {
                result++;
            }
            return;
        }

        for (int i = index; i < N; i++) {
            backTracking(depth + 1, i + 1, sum + numbers[i], limit);
        }
    }
}
