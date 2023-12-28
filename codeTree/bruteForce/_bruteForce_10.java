package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _bruteForce_10 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (i == 0 && j == i + 1) {
                    continue;
                }
                if (i == N - 1 && j == i - 1) {
                    continue;
                }
                if (j == i - 1 || j == i + 1) {
                    continue;
                }
                max = Math.max(max, arr[i] + arr[j]);
            }
        }
        System.out.println(max);
    }
}
