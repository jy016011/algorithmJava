package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _bruteForce_12 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int max = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (isCarry(arr[i], arr[j], arr[k])) {
                        continue;
                    }
                    max = Math.max(max, arr[i] + arr[j] + arr[k]);
                }
            }
        }
        if (max == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(max);

    }

    private static boolean isCarry(int num1, int num2, int num3) {
        boolean isCarried = false;
        while (num1 != 0 || num2 != 0 || num3 != 0) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            int digit3 = num3 % 10;
            if (digit1 + digit2 + digit3 > 9) {
                isCarried = true;
                break;
            }
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return isCarried;
    }
}
