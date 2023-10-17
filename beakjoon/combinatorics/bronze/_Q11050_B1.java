package beakjoon.combinatorics.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q11050_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));

    }
    public static int factorial(int n){
        int fact = 1;
        for (int i = 2; i <= n ; i++) {
            fact *= i;
        }
        return fact;
    }
}
