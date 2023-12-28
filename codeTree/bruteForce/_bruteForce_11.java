package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _bruteForce_11 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String cows = bufferedReader.readLine();
        int cnt = 0;
        for (int i = 0; i < N - 2; i++) {
            if (cows.charAt(i) != 'C') {
                continue;
            }
            for (int j = i + 1; j < N - 1; j++) {
                if (cows.charAt(j) != 'O') {
                    continue;
                }
                for (int k = j + 1; k < N; k++) {
                    if (cows.charAt(k) != 'W') {
                        continue;
                    }
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
