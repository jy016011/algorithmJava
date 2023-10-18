package beakjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Q1931_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] meetingTimes = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            meetingTimes[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            meetingTimes[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(meetingTimes, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });
        int endTime = meetingTimes[0][1];
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (meetingTimes[i][0] >= endTime){
                cnt += 1;
                endTime = meetingTimes[i][1];
            }
        }
        System.out.println(cnt);
    }
}
