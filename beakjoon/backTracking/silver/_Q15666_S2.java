package beakjoon.backTracking.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _Q15666_S2 {
    private static int M;
    private static int[] sequence;
    private static Integer[] arr;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        sequence = new int[M];
        Set<Integer> set = new HashSet<>();
        stringBuilder = new StringBuilder();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        backTracking(0, 0);
        System.out.println(stringBuilder);

    }

    private static void backTracking(int depth, int start) {
        if (depth == M) {
            for (int number :
                    sequence) {
                stringBuilder.append(number).append(" ");
            }
            stringBuilder.append(System.lineSeparator());
            return;
        }

        for (int i = start; i < arr.length; i++) {
            sequence[depth] = arr[i];
            backTracking(depth + 1, i);
        }
    }
}
