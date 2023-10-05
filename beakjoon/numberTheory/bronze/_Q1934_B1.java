package beakjoon.numberTheory.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1934_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int gcd = 1;
            for (int j = 1; j <= Math.max(a, b) ; j++) {
                if (a % j == 0 && b % j == 0){
                    gcd = j;
                }
            }
            stringBuilder.append(a * b / gcd).append("\n");
        }
        System.out.println(stringBuilder);
    }
}