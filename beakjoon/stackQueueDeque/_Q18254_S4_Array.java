package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q18254_S4_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] queue = new int[2_000_001];
        int start = 0;
        int end = start;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            if (command.equals("push")){
                queue[end] = Integer.parseInt(stringTokenizer.nextToken());
                end++;
            } else if (command.equals("pop")) {
                if (queue[start] < 1)
                    stringBuilder.append(-1).append("\n");
                else {
                    stringBuilder.append(queue[start]).append("\n");
                    start++;
                }
            } else if (command.equals("size")) {
                stringBuilder.append(end - start).append("\n");
            } else if (command.equals("empty")) {
                if (queue[start] < 1)
                    stringBuilder.append(1).append("\n");
                else
                    stringBuilder.append(0).append("\n");
            } else if (command.equals("front")) {
                if (queue[start] < 1)
                    stringBuilder.append(-1).append("\n");
                else
                    stringBuilder.append(queue[start]).append("\n");
            } else if (command.equals("back")) {
                if (queue[start] < 1)
                    stringBuilder.append(-1).append("\n");
                else
                    stringBuilder.append(queue[end - 1]).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
