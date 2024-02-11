package beakjoon.backTracking.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q6603_S2 {
    private static int[] S, sequence;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        stringBuilder = new StringBuilder();
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            if (k == 0) {
                break;
            }
            S = new int[k];
            sequence = new int[6];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            backTracking(0, 0);
            stringBuilder.append(System.lineSeparator());
        }

        System.out.println(stringBuilder);
    }

    private static void backTracking(int depth, int start) {
        if (depth == 6) {
            for (int number : sequence) {
                stringBuilder.append(number).append(" ");
            }
            stringBuilder.append(System.lineSeparator());
            return;
        }

        for (int i = start; i < S.length; i++) {
            sequence[depth] = S[i];
            backTracking(depth + 1, i + 1);
        }
    }
}
