package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _Q2346_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Deque<int[]> balloons = new ArrayDeque<>();//LinkedList will cause memory exceeded
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int[] tmp = {i, Integer.parseInt(stringTokenizer.nextToken())};
            balloons.offerLast(tmp);
        }
        while (!balloons.isEmpty()){
            int offset = balloons.peekFirst()[1];
            stringBuilder.append(balloons.pollFirst()[0]).append(" ");
            if (!balloons.isEmpty()) {
                if (offset > 0) {
                    for (int i = 1; i < offset; i++) {
                        balloons.offerLast(balloons.pollFirst());
                    }
                } else {
                    for (int i = -1; i >= offset; i--) {
                        balloons.offerFirst(balloons.pollLast());
                    }
                }
            }
        }
        System.out.println(stringBuilder);
    }
}
