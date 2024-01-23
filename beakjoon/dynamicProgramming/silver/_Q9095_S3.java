package beakjoon.dynamicProgramming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q9095_S3 {
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            result = 0;
            recursive(n);
            stringBuilder.append(result).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private static void recursive(int n) {
        if (n == 0) {
            result++;
            return;
        }
        if (n < 0) {
            return;
        }
        recursive(n - 1);
        recursive(n - 2);
        recursive(n - 3);
    }
}
