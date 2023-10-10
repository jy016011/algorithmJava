package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _Q12789_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int nextOrder = 1;
        Stack<Integer> lineSpace = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        String feeling = "Nice";
        for (int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(stringTokenizer.nextToken()));
        }
        while (!queue.isEmpty()){
            if(queue.peek() == nextOrder) {
                queue.poll();
                nextOrder++;
            }
            else if (!lineSpace.isEmpty() && lineSpace.peek() == nextOrder) {
                lineSpace.pop();
                nextOrder++;
            }
            else
                lineSpace.push(queue.poll());
        }

        while (!lineSpace.isEmpty()){
            if (lineSpace.peek() != nextOrder) {
                feeling = "Sad";
                break;
            } else {
                lineSpace.pop();
                nextOrder++;
            }
        }
        System.out.println(feeling);
    }
}
