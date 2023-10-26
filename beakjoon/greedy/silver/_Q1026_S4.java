package beakjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _Q1026_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        int sum = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < N; i++) {
            sum += a[i] * b[N - 1 - i];
        }
        System.out.println(sum);
    }
}
