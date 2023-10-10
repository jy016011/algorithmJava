package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q28278_S4_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] intStack = new int[1_000_001];
        boolean[] hasNumber = new boolean[1_000_001];
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int command = Integer.parseInt(stringTokenizer.nextToken());
            if (command == 1){
                int number = Integer.parseInt(stringTokenizer.nextToken());
                index++;
                intStack[index] = number;
                hasNumber[index] = true;
            } else if (command == 2) {
                if (hasNumber[1]) {
                    stringBuilder.append(intStack[index]).append("\n");
                    intStack[index] = 0;
                    hasNumber[index] = false;
                    index--;
                }
                else
                    stringBuilder.append(-1).append("\n");
            } else if (command == 3) {
                stringBuilder.append(index).append("\n");
            } else if (command == 4) {
                if (!hasNumber[1])
                    stringBuilder.append(1).append("\n");
                else
                    stringBuilder.append(0).append("\n");
            } else if (command == 5) {
                if (hasNumber[index]) {
                    stringBuilder.append(intStack[index]).append("\n");
                }
                else
                    stringBuilder.append(-1).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
