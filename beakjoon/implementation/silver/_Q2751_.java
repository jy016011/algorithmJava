package beakjoon.implementation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2751_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[2_000_001];// 1_000_000 ~ 2_000_000: 0 ~ 1000_000, 999_999 ~ 0: -1 ~ - 1_000_000
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[num + 1_000_000] += 1;
        }
        contingSort(numbers, sb);
        System.out.println(sb);
    }
    public static void contingSort(int[] numbers, StringBuilder sb){
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0){
                for (int j = 0; j < numbers[i]; j++) {
                    sb.append(i - 1_000_000).append("\n");
                }
            }
        }
    }
}
