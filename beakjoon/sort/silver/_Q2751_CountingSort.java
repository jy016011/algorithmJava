package beakjoon.sort.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2751_CountingSort {
    public static void main(String[] args) throws IOException {
        int[] numbers = new int[2_000_001];
        int number;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            number = Integer.parseInt(br.readLine());
            numbers[number + 1_000_000] += 1;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0){
                for (int j = 1; j <= numbers[i]; j++) {
                    sb.append(i - 1_000_000).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
