package beakjoon.sort.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2751_MergeSort { // solved by using merge sort
    static int n ;
    static int[] numbers ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, n - 1);
        for (int num:
             numbers) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
    public static void mergeSort(int start, int end){
        if(start == end)
            return;
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        int idx1 = start;
        int idx2 = mid + 1;
        int k = start;
        int[] tmp = new int[end + 1];
        System.arraycopy(numbers, 0, tmp, 0, end + 1);
        while ((idx1 <= mid) && (idx2 <= end)){
            if (tmp[idx1] > tmp[idx2]){
                numbers[k] = tmp[idx2];
                idx2 += 1;
            }
            else {
                numbers[k] = tmp[idx1];
                idx1 += 1;
            }
            k += 1;
        }
        if(idx1 <= mid){
            for (int i = idx1; i <= mid; i++) {
                numbers[k] = tmp[i];
                k += 1;
            }
        }
        else if(idx2 <= end) {
            for (int i = idx2; i <= end; i++) {
                numbers[k] = tmp[i];
                k += 1;
            }
        }
    }
}
