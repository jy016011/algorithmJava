package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _bruteForce_16 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[N];
        int S = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    sum += arr[k];
                }
                min = Math.min(min, Math.abs(S - sum));
            }
        }
        System.out.println(min);
    }
}