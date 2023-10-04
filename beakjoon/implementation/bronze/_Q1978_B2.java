package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1978_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            boolean isPrime = true;
            if (number == 1){
                isPrime = false;
            }
            for (int j = 2; j < number; j++) {
                if (number % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) cnt += 1;

        }
        System.out.println(cnt);
    }
}
