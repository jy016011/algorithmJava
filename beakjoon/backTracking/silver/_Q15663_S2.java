package beakjoon.backTracking.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _Q15663_S2 {
    private static int N, M;
    private static int[] numbers;
    private static Map<Integer, Integer> map;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new int[M];
        map = new HashMap<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
                continue;
            }
            map.put(number, 1);
        }
        stringBuilder = new StringBuilder();
        Arrays.sort(numbers);

        backTracking(0);
        System.out.println(stringBuilder);
    }

    private static void backTracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                stringBuilder.append(numbers[i]).append(" ");
            }
            stringBuilder.append(System.lineSeparator());
            return;
        }

        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                numbers[depth] = key;
                map.put(key, map.get(key) - 1);
                backTracking(depth + 1);
                numbers[depth] = 0;
                map.put(key, map.get(key) + 1);
            }
        }
    }
}

