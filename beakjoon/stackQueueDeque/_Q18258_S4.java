package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q18258_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int last = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            if (command.equals("push")){
                last = Integer.parseInt(stringTokenizer.nextToken());
                queue.offer(last);
            } else if (command.equals("pop")) {
                if (!queue.isEmpty())
                    stringBuilder.append(queue.poll()).append("\n");
                else
                    stringBuilder.append(-1).append("\n");
            } else if (command.equals("size")) {
                stringBuilder.append(queue.size()).append("\n");
            } else if (command.equals("front")) {
                if (!queue.isEmpty())
                    stringBuilder.append(queue.peek()).append("\n");
                else
                    stringBuilder.append(-1).append("\n");
            } else if (command.equals("back")) {
                if (!queue.isEmpty())
                    stringBuilder.append(last).append("\n");
                else
                    stringBuilder.append(-1).append("\n");
            } else if (command.equals("empty")) {
                if (queue.isEmpty())
                    stringBuilder.append(1).append("\n");
                else
                    stringBuilder.append(0).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
