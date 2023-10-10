package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _Q28278_S4_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> intStack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int command = Integer.parseInt(stringTokenizer.nextToken());
            if (command == 1){
                int number = Integer.parseInt(stringTokenizer.nextToken());
                intStack.push(number);
            } else if (command == 2) {
                if (!intStack.isEmpty()) {
                    stringBuilder.append(intStack.pop()).append("\n");
                }
                else
                    stringBuilder.append(-1).append("\n");
            } else if (command == 3) {
                stringBuilder.append(intStack.size()).append("\n");
            } else if (command == 4) {
                if (intStack.isEmpty())
                    stringBuilder.append(1).append("\n");
                else
                    stringBuilder.append(0).append("\n");
            } else if (command == 5) {
                if (!intStack.isEmpty()) {
                    stringBuilder.append(intStack.peek()).append("\n");
                }
                else
                    stringBuilder.append(-1).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
