package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _bruteForce_8 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int distanceSum = 0;
            for (int j = 0; j < N; j++) {
                int distance;
                if (j < i) {
                    distance = N - (i - j);
                } else {
                    distance = j - i;
                }
                distanceSum += arr[j] * distance;
            }
            minDistance = Math.min(minDistance, distanceSum);
        }
        System.out.println(minDistance);
    }
}
