package beakjoon.sort.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Q2751_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] nums = new int[N];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            stringBuilder.append(nums[i]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}