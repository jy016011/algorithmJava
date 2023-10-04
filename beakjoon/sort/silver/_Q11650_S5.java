package beakjoon.sort.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class _Q11650_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        List<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int[] tmp = {x, y};
            coordinates.add(tmp);
        }
        coordinates.sort((o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            else
                return o1[0] - o2[0];
        });
        for (int[] arr:
             coordinates) {
            stringBuilder.append(arr[0]).append(" ");
            stringBuilder.append(arr[1]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
