package beakjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _Q11000_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] lectures = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            lectures[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            lectures[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(lectures, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            else
                return o1[0] - o2[0];
        });
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(lectures[0][1]);
        for (int i = 1; i < N; i++) {
            if (lectures[i][0] >= endTimes.peek()){
                endTimes.poll();
            }
            endTimes.offer(lectures[i][1]);
        }
        System.out.println(endTimes.size());
    }
}
