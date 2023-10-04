package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q11720_SumOfNumbers_B4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            sum += (s.charAt(i) - 48);
        }
        System.out.println(sum);
    }
}
