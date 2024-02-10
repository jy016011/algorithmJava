package beakjoon.backTracking.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _Q15656_S3 {
    private static int N, M;
    private static int[] numbers;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(numbers);
        stringBuilder = new StringBuilder();
        List<Integer> sequence = new ArrayList<>();
        backTracking(0, sequence);
        System.out.println(stringBuilder);
    }

    private static void backTracking(int depth, List<Integer> sequence) {
        if (depth == M) {
            for (int number :
                    sequence) {
                stringBuilder.append(number).append(" ");
            }
            stringBuilder.append(System.lineSeparator());
            return;
        }

        for (int i = 0; i < N; i++) {
            sequence.add(numbers[i]);
            backTracking(depth + 1, sequence);
            sequence.remove(sequence.size() - 1);
        }
    }
}
