package beakjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Q2170_G5_CollectionsSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        ArrayList<int[]> lines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int[] line = {x, y};
            lines.add(line);
        }
        lines.sort(((o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        }));
        int start = lines.get(0)[0];
        int end = lines.get(0)[1];
        int size = end - start;
        for (int i = 1; i < N; i++) {
            if (lines.get(i)[1] <= end)
                continue;
            else if (lines.get(i)[0] <= end) {
                size += (lines.get(i)[1]- end);
                end = lines.get(i)[1];
            }
            else {
                start = lines.get(i)[0];
                end = lines.get(i)[1];
                size += (end - start);
            }
        }
        System.out.println(size);

    }
}
