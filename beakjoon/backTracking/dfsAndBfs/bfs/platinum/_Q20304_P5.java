package beakjoon.backTracking.dfsAndBfs.bfs.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q20304_P5 {
    private static int N;
    private static int lengthOfBinary;
    private static Queue<Integer> queue;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        lengthOfBinary = Integer.toBinaryString(N).length();
        arr = new int[N + 1];
        Arrays.fill(arr, Integer.MIN_VALUE);
        int m = Integer.parseInt(bufferedReader.readLine());
        queue = new LinkedList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            int tried = Integer.parseInt(stringTokenizer.nextToken());
            arr[tried] = 0;
            queue.offer(tried);
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (!queue.isEmpty()) {
                    int current = queue.poll();
                    max = Math.max(max, arr[current]);
                    for (int shift = 0; shift < lengthOfBinary; shift++) {
                        int nx = current ^ (1 << shift);
                        if (nx > N || arr[nx] != Integer.MIN_VALUE) {
                            continue;
                        }
                        arr[nx] = arr[current] + 1;
                        queue.offer(nx);
                    }
                }
            }
        }
        return max;
    }
}
