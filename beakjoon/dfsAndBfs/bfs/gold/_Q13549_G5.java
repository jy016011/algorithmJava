package beakjoon.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q13549_G5 {
    private static final int[] map = new int[100_001];
    private static final boolean[] visited = new boolean[100_001];
    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        bfs();
        System.out.println(map[K]);

    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == K) {
                return;
            }

            if (current * 2 <= 100_000 && !visited[current * 2]) {
                queue.offer(current * 2);
                visited[current * 2] = true;
                map[current * 2] = map[current];
            }

            if (current - 1 >= 0 && !visited[current - 1]) {
                queue.offer(current - 1);
                visited[current - 1] = true;
                map[current - 1] = map[current] + 1;
            }

            if (current + 1 <= 100_000 && !visited[current + 1]) {
                queue.offer(current + 1);
                visited[current + 1] = true;
                map[current + 1] = map[current] + 1;
            }
        }
    }
}
