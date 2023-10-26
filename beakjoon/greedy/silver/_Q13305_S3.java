package beakjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Q13305_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        long[] distances = new long[N - 1];
        long[] cities = new long[N];
        long totalCost = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Long.parseLong(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < cities.length; i++) {
            cities[i] = Long.parseLong(stringTokenizer.nextToken());
        }
        long minCost = 1_000_000_000;
        for (int i = 0; i < distances.length; i++) {
            minCost = Math.min(cities[i], minCost);
            totalCost += (minCost * distances[i]);
        }
        System.out.println(totalCost);

    }
}
