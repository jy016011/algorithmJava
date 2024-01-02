package beakjoon.backTracking.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q2146_G3 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int minDistance = Integer.MAX_VALUE;
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int numberOfIsland = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, numberOfIsland);
                    numberOfIsland++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    bfsDistance(i, j);
                }
            }
        }
        System.out.println(minDistance);
    }

    private static void bfs(int row, int col, int numberOfIsland) {
        Queue<int[]> queue = new LinkedList<>();
        map[row][col] = numberOfIsland;
        visited[row][col] = true;
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = numberOfIsland;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private static void bfsDistance(int row, int col) {
        int numberOfIsland = map[row][col];
        int[][] sumMap = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        sumMap[row][col] = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if (map[x][y] != 0 && map[x][y] != numberOfIsland) {
                minDistance = Math.min(minDistance, sumMap[x][y] - 2);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (sumMap[nx][ny] == 0 && map[nx][ny] != numberOfIsland) {
                    queue.offer(new int[]{nx, ny});
                    sumMap[nx][ny] = sumMap[x][y] + 1;
                }
            }
        }
    }
}