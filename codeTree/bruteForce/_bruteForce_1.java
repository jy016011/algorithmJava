package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _bruteForce_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int distance = Math.abs(i - j);
                sum += distance * arr[j];
            }
            min = Math.min(min, sum);
        }
        System.out.println(min);
    }
}
