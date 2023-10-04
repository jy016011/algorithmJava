package beakjoon.sort.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2750_B2_BubbleSort {// solved by bubble sort
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                if (nums[j] > nums[j + 1]){
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(nums[i]);
        }
    }
}
