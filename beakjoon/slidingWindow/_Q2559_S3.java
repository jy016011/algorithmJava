package beakjoon.slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q2559_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] sequence = new int[N + 1];
        int[] sumArr = new int[N + 1];
        int K = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            sequence[i] = Integer.parseInt(stringTokenizer.nextToken());
            sumArr[i] = sumArr[i - 1] + sequence[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N - K + 1; i++) {
            int lastIndex = i + K - 1;
            max = Math.max(max, sumArr[lastIndex] - sumArr[i - 1]);
        }
        System.out.println(max);

    }
}
