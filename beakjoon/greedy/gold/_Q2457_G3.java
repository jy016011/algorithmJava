package beakjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _Q2457_G3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<int[]> flowerDays = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int[] flowerDay = new int[4];
            for (int j = 0; j < 4; j++) {
                flowerDay[j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            flowerDays.offer(flowerDay);
        }
        PriorityQueue<int[]> fallingDays = new PriorityQueue<>((o1, o2) -> {
            if (o2[2] == o1[2])
                return o2[3] - o1[3];
            return o2[2] - o1[2];
        });
        int[] endTime = {3, 1};
        int count = 0;
        while (!flowerDays.isEmpty()){
            int[] startTime = flowerDays.peek();
            if (startTime[0] > 11) break;
            if (startTime[0] > endTime[0] || (startTime[0] == endTime[0] && startTime[1] > endTime[1])){
                if (fallingDays.isEmpty()){
                    break;
                }
                endTime[0] = fallingDays.peek()[2];
                endTime[1] = fallingDays.poll()[3];
                count++;
                continue;
            }
            fallingDays.offer(flowerDays.poll());
        }
        while (endTime[0] <= 11 && !fallingDays.isEmpty()){
            endTime[0] = fallingDays.peek()[2];
            endTime[1] = fallingDays.poll()[3];
            count++;
        }
        if (endTime[0] > 11)
            System.out.println(count);
        else {
            System.out.println(0);
        }
    }
}
