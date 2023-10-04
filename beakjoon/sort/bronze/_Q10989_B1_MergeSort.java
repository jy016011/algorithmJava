package beakjoon.sort.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q10989_B1_MergeSort { // solved by merge sort
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] nums = new int[N];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(bufferedReader.readLine());
        }
        mergeSort(nums, 0, N -1);
        for (int i = 0; i < N; i++) {
            stringBuilder.append(nums[i]).append("\n");
        }
        System.out.println(stringBuilder);
    }
    public static void mergeSort(int[] nums, int start, int end){
        if (start == end)
            return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        int idx1 = start;
        int idx2 = mid + 1;
        int numsIdx = start;
        while (idx1 <= mid && idx2 <= end){
            if (temp[idx1] > temp[idx2]){
                nums[numsIdx] = temp[idx2];
                idx2++;
            }
            else {
                nums[numsIdx] = temp[idx1];
                idx1++;
            }
            numsIdx++;
        }
        if (idx1 <= mid){
            for (int i = idx1; i <= mid; i++) {
                nums[numsIdx] = temp[i];
                numsIdx++;
            }
        }
        else {
            for (int i = idx2; i <= end; i++) {
                nums[numsIdx] = temp[i];
                numsIdx++;
            }
        }
    }
}
