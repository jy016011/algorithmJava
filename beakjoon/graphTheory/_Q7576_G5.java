package beakjoon.graphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q7576_G5 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int[][] tomatoes;
    private static final Queue<int[]> startPoints = new LinkedList<>();
    private static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        tomatoes = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                int tomato = Integer.parseInt(stringTokenizer.nextToken());
                if (tomato == 1) {
                    int[] ripeTomato = {i, j};
                    startPoints.offer(ripeTomato);
                }
                tomatoes[i][j] = tomato;
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int max = Integer.MIN_VALUE;
        while (!startPoints.isEmpty()) {
            int[] ripeTomato = startPoints.poll();
            int x = ripeTomato[0];
            int y = ripeTomato[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (tomatoes[nx][ny] == 0) {
                    tomatoes[nx][ny] += tomatoes[x][y] + 1;
                    startPoints.offer(new int[]{nx, ny});
                    max = Math.max(max, tomatoes[nx][ny]);
                }
            }
        }
        for (int[] row : tomatoes) {
            for (int tomato : row) {
                if (tomato == 0) {
                    return -1;
                }
            }
        }
        if (max == Integer.MIN_VALUE) {
            return 0;
        }
        return max - 1;
    }
}
