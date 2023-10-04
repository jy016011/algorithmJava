package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2581_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int min = N;
        int sum = 0;
        boolean[] numbers = new boolean[N + 1]; // true == notPrime, false == prime
        numbers[0] = numbers[1] = true; //0 and 1 are not prime number.
        for (int i = 2; i * i <= N; i++) {
            for (int j = i * i; j <= N ; j += i) {
                if (!numbers[j]){
                    numbers[j] = true;
                }
            }
        }
        for (int i = M; i <= N ; i++) {
            if (!numbers[i]){
                sum += i;
                min = Math.min(min, i);
            }
        }
        if (sum == 0)
            System.out.println(-1);
        else
            System.out.println(sum + "\n" +min);

    }
}
