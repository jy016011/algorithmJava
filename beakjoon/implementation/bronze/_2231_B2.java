package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2231_B2 {
    public static void main(String[] args) throws IOException {
        int min = 1_000_000;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1; i <= N ; i++) {
            int sum = i;
            int number = i;
            while (number > 0){
                sum += number % 10;
                number /= 10;
            }
            if (sum == N)
                min = Math.min(min, i);
        }
        if (min != 1_000_000)
            System.out.println(min);
        else
            System.out.println(0);
    }
}
