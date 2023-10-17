package beakjoon.combinatorics.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q10872_B5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int factorial = 1;
        int N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 2; i <= N; i++) {
            factorial *= i;
        }
        System.out.println(factorial);
    }
}
