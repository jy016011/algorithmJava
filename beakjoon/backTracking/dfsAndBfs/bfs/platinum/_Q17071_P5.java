package beakjoon.backTracking.dfsAndBfs.bfs.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q17071_P5 {
    private static int N, K;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        visited = new boolean[500_001][2];
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        System.out.println(bfs());
    }

    private static int bfs() {
        int[] dx = {-1, 1, 2};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        int time = 0;
        visited[N][time] = true;
        while (!queue.isEmpty()) {
            if (K > 500_000) {
                return -1;
            }
            int speed = time + 1;
            int size = queue.size();
            int remain = time % 2;
            if (visited[K][remain]) {
                return time;
            }
            for (int i = 0; i < size; i++) {
                if (!queue.isEmpty()) {
                    int current = queue.poll();
                    int nextRemain = (time + 1) % 2;
                    for (int dir = 0; dir < 3; dir++) {
                        int nx;
                        if (dir == 2) {
                            nx = current * dx[dir];
                        } else {
                            nx = current + dx[dir];
                        }
                        if (nx < 0 || nx > 500_000) {
                            continue;
                        }
                        if (!visited[nx][nextRemain]) {
                            visited[nx][nextRemain] = true;
                            queue.offer(nx);
                        }
                    }
                }
            }
            K += speed;
            time++;
        }
        return -1;
    }
}
