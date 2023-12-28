package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _bruteForce_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] cows = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int cnt = 0;
        for (int i = 0; i < N - 2; i++) {
            int shortest = cows[i];
            for (int j = i + 1; j < N - 1; j++) {
                int middle = cows[j];
                if (middle < shortest) {
                    continue;
                }
                for (int k = j + 1; k < N; k++) {
                    int longest = cows[k];
                    if (longest < middle) {
                        continue;
                    }
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
