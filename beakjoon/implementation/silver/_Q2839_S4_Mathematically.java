package beakjoon.implementation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2839_S4_Mathematically {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        if (N == 4 || N == 7 || N < 3){
            System.out.println(-1);
        }
        else {
            if (N % 5 == 0)
                System.out.println(N / 5);
            else if (N % 5 == 1 || N % 5 == 3) {
                System.out.println(N / 5 + 1);
            } else {
                System.out.println(N / 5 + 2);
            }

        }
    }
}
