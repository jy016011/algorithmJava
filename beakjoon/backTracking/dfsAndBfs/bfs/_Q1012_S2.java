package beakjoon.backTracking.dfsAndBfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q1012_S2 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static int M, N;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            int K = Integer.parseInt(stringTokenizer.nextToken());
            for (int i = 0; i < K; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int m = Integer.parseInt(stringTokenizer.nextToken());
                int n = Integer.parseInt(stringTokenizer.nextToken());
                map[n][m] = 1;
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            stringBuilder.append(cnt).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }


    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
