package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2720_B3 {
    static int QUATER = 25;
    static int DIME = 10;
    static int NICKEL = 5;
    static int PENNY = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < T; i++) {
            int c = Integer.parseInt(br.readLine());
                sb.append(c / QUATER).append(" ");
                c %=  QUATER;
                sb.append(c / DIME).append(" ");
                c %= DIME;
                sb.append(c / NICKEL).append(" ");
                c %= NICKEL;
                sb.append(c / PENNY).append(" ");

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
