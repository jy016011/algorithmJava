package beakjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _Q15903_S1_PriorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(Long.parseLong(stringTokenizer.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = 0; j < 2; j++) {
                if (!priorityQueue.isEmpty()){
                    sum += priorityQueue.poll();
                }
            }
            priorityQueue.offer(sum);
            priorityQueue.offer(sum);
        }

        long sum = 0;
        while (!priorityQueue.isEmpty()){
            sum += priorityQueue.poll();
        }
        System.out.println(sum);
    }
}
