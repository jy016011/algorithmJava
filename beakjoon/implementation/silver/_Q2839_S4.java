package beakjoon.implementation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2839_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int min = N;
        for (int i = 0; i <= N / 3 ; i++) {
            for (int j = 0; j <= N / 5; j++) {
                if (3 * i + 5 * j == N){
                   min = Math.min(min, i + j);
                }
            }
        }
        if (min == N) System.out.println(-1);
        else System.out.println(min);
    }
}
