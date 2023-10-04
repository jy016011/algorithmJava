package beakjoon.sort.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q10989_B1_CountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        int[] numCnts = new int[10001];
        for (int i = 0; i < N; i++) {
            numCnts[Integer.parseInt(bufferedReader.readLine())] += 1;
        }
        for (int i = 1; i <= 10000; i++) {
            if (numCnts[i] > 0){
                for (int j = 0; j < numCnts[i]; j++) {
                    stringBuilder.append(i).append("\n");
                }
            }
        }
        System.out.println(stringBuilder);

    }
}
