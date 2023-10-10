package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _Q10773_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> intStack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number == 0)
                intStack.pop();
            else
                intStack.push(number);
        }
        int sum = 0;
        for (int number:
             intStack) {
            sum += number;
        }
        System.out.println(sum);
    }
}
