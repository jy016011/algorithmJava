package beakjoon.etc;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            sb.append(" ".repeat(n - i));
            sb.append("*".repeat(2 * i - 1));
            sb.append("\n");
        }

        for (int i = n - 1; i >= 1; i--) {
            sb.append(" ".repeat(n - i));
            sb.append("*".repeat(2 * i - 1));
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
