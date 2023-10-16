package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _Q28279_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int command = Integer.parseInt(stringTokenizer.nextToken());
            if (command == 1){
                int X = Integer.parseInt(stringTokenizer.nextToken());
                deque.offerFirst(X);
            } else if (command == 2) {
                int X = Integer.parseInt(stringTokenizer.nextToken());
                deque.offerLast(X);
            } else if (command == 3) {
                if (deque.isEmpty())
                    stringBuilder.append(-1).append("\n");
                else
                    stringBuilder.append(deque.pollFirst()).append("\n");
            } else if (command == 4) {
                if (deque.isEmpty())
                    stringBuilder.append(-1).append("\n");
                else
                    stringBuilder.append(deque.pollLast()).append("\n");
            } else if (command == 5) {
                stringBuilder.append(deque.size()).append("\n");
            } else if (command == 6) {
                if (deque.isEmpty())
                    stringBuilder.append(1).append("\n");
                else
                    stringBuilder.append(0).append("\n");
            } else if (command == 7) {
                if (deque.isEmpty())
                    stringBuilder.append(-1).append("\n");
                else
                    stringBuilder.append(deque.peekFirst()).append("\n");
            } else if (command == 8) {
                if (deque.isEmpty())
                    stringBuilder.append(-1).append("\n");
                else
                    stringBuilder.append(deque.peekLast()).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}