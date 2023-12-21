package beakjoon.backTracking.dfsAndBfs.bfs.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q2583_S1 {
    private static int[][] matrix;
    private static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        matrix = new int[M][N];
        K = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    matrix[y][x] = 1;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (matrix[y][x] == 0) {
                    cnt++;
                    matrix[y][x] = 1;
                    result.add(bfs(y, x));
                }
            }
        }
        result.sort(Integer::compareTo);
        stringBuilder.append(cnt).append(System.lineSeparator());
        if (result.isEmpty()) {
            stringBuilder.append(0);
        }
        for (int wide : result) {
            stringBuilder.append(wide).append(" ");
        }
        System.out.println(stringBuilder);
    }

    private static int bfs(int pointY, int pointX) {
        int wide = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{pointY, pointX});
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int y = coordinate[0];
            int x = coordinate[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (matrix[ny][nx] == 0) {
                    matrix[ny][nx] = 1;
                    wide++;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }

        return wide;
    }
}
