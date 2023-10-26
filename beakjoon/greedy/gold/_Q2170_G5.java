package beakjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Q2170_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] lines = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            lines[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            lines[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(lines, (o1, o2) ->{
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int start = lines[0][0];
        int end = lines[0][1];
        int size = end - start;
        for (int i = 1; i < N; i++) {
            if (lines[i][1] <= end)
                continue;
            else if (lines[i][0] <= end) {
                size += (lines[i][1] - end);
                end = lines[i][1];
            }
            else {
                start = lines[i][0];
                end = lines[i][1];
                size += (end - start);
            }
        }
        System.out.println(size);

    }
}
