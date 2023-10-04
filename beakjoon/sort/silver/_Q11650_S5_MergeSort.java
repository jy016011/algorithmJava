package beakjoon.sort.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q11650_S5_MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] coordinates = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 2; j++) {
                coordinates[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        mergeSort(coordinates, 0, N - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                stringBuilder.append(coordinates[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);

    }
    public static void mergeSort(int[][] coordinates, int start, int end){
        if (start == end) return;
        int mid = (start + end) / 2;
        mergeSort(coordinates, start, mid);
        mergeSort(coordinates, mid + 1, end);
        int[][] temp = new int[coordinates.length][2];
        for (int i = start; i <= end; i++) {
            for (int j = 0; j < 2; j++) {
                temp[i][j] = coordinates[i][j];
            }
        }
        int idx1 = start;
        int idx2 = mid + 1;
        int k = start;
        while (idx1 <= mid && idx2 <= end){
            if (temp[idx1][0] > temp[idx2][0]){
                coordinates[k] = temp[idx2];
                idx2++;
            } else if (temp[idx1][0] == temp[idx2][0]) {
                if (temp[idx1][1] > temp[idx2][1] ){
                    coordinates[k] = temp[idx2];
                    idx2++;
                }
                else {
                    coordinates[k] = temp[idx1];
                    idx1++;
                }
            }
            else {
                coordinates[k] = temp[idx1];
                idx1++;
            }
            k++;
        }
        if (idx1 <= mid){
            for (int i = idx1; i <= mid ; i++) {
                coordinates[k] = temp[i];
                k++;
            }
        }
        else {
            for (int i = idx2; i <= end ; i++) {
                coordinates[k] = temp[i];
                k++;
            }
        }
    }
}
