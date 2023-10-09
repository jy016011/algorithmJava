package beakjoon.numberTheory.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2485_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int gcd = trees[1] - trees[0];
        for (int i = 0; i < N - 1; i++) {
            int distance = trees[i + 1] - trees[i];
            gcd = getGcd(gcd, distance);
        }
        int count = (trees[N - 1] - trees[0]) / gcd + 1 - trees.length;
        System.out.println(count);

    }
    public static int getGcd(int a, int b){
        if (b == 0)
            return a;
        else
            return getGcd(b , a % b);
    }
}
