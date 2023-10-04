package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q9506_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            int sum = 0;
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;
            sb.append(n).append(" = ");
            for (int i = 1; i < n ; i++) {
                if (n % i == 0) {
                    sum += i;
                    sb.append(i).append(" + ");
                }
            }
            if (sum == n) {
                sb = new StringBuilder(sb.substring(0, sb.length() - 3));
                sb.append("\n");
            }
            else {
                sb = new StringBuilder(sb.substring(0, sb.lastIndexOf("\n") + 1));
                sb.append(n).append(" is NOT perfect.\n");
            }
        }
        System.out.println(sb);
    }
}
