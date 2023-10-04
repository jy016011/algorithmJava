package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2903_B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int pointRow = (int)Math.pow(2, N) + 1;
        System.out.println(pointRow * pointRow);
    }
}
