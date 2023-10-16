package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q28279_S4_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] deque = new int[2_000_001];
        int first = 1_000_000;
        int last = 1_000_001;
        int size = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int command = Integer.parseInt(stringTokenizer.nextToken());
            if (command == 1){
                int X = Integer.parseInt(stringTokenizer.nextToken());
                deque[first] = X;
                first--;
                size++;
            } else if (command == 2) {
                int X = Integer.parseInt(stringTokenizer.nextToken());
                deque[last] = X;
                last++;
                size++;
            } else if (command == 3) {
                if (size == 0)
                    stringBuilder.append(-1).append("\n");
                else {
                    first++;
                    size--;
                    stringBuilder.append(deque[first]).append("\n");
                }
            } else if (command == 4) {
                if (size == 0)
                    stringBuilder.append(-1).append("\n");
                else {
                    last--;
                    size--;
                    stringBuilder.append(deque[last]).append("\n");
                }
            } else if (command == 5) {
                stringBuilder.append(size).append("\n");
            } else if (command == 6) {
                if (size == 0)
                    stringBuilder.append(1).append("\n");
                else
                    stringBuilder.append(0).append("\n");
            } else if (command == 7) {
                if (size == 0)
                    stringBuilder.append(-1).append("\n");
                else
                    stringBuilder.append(deque[first + 1]).append("\n");
            } else if (command == 8) {
                if (size == 0)
                    stringBuilder.append(-1).append("\n");
                else
                    stringBuilder.append(deque[last - 1]).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}