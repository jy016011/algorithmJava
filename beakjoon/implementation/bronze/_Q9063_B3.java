package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q9063_B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int minX = 10000;
        int minY = 10000;
        int maxX = -10000;
        int maxY = -10000;
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            int y = Integer.parseInt(stringTokenizer.nextToken());
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);

        }
        System.out.println((maxX - minX) * (maxY - minY));
    }
}