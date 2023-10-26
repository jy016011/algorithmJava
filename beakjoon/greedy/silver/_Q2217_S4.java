package beakjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Q2217_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(ropes);
        int w = 0;
        int count = 1;
        for (int i = ropes.length - 1; i >= 0 ; i--) {
            w = Math.max(ropes[i] * count, w);
            count++;
        }
        System.out.println(w);
    }
}
