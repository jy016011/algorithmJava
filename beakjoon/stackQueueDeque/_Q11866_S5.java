package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q11866_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        Queue<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            circle.offer(i);
        }
        int index = 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (!circle.isEmpty()){
            if (index % K == 0)
                stringBuilder.append(circle.poll()).append(", ");
            else
                circle.offer(circle.poll());
            index++;
        }
        System.out.println("<" + stringBuilder.substring(0, stringBuilder.length() - 2) + ">");
    }
}
