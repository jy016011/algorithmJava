package beakjoon.backTracking.dfsAndBfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q1697_S1 {
    static int[] locations = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        locations[N] = 1; // 시작 지점은 재방문하지 않도록 값 설정
        bfs(N, K);
        System.out.println(locations[K] - 1);
    }

    private static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        while (!queue.isEmpty()) {
            int curLocation = queue.poll();
            if (curLocation == K) {
                return;
            }
            if (curLocation - 1 >= 0 && locations[curLocation - 1] == 0) {
                locations[curLocation - 1] = locations[curLocation] + 1;
                queue.offer(curLocation - 1);
            }
            if (curLocation + 1 <= 100_000 && locations[curLocation + 1] == 0) {
                locations[curLocation + 1] = locations[curLocation] + 1;
                queue.offer(curLocation + 1);
            }
            if (curLocation * 2 <= 100_000 && locations[curLocation * 2] == 0) {
                locations[curLocation * 2] = locations[curLocation] + 1;
                queue.offer(curLocation * 2);
            }
        }
    }
}