package beakjoon.backTracking.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q2146_G3_Improved {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static int N;
    private static List<int[]> list;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int numberOfIsland = 2;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (map[row][col] == 1) {
                    bfs(row, col, numberOfIsland);
                    numberOfIsland++;
                }
            }
        }
        for (int[] edge : list) {
            bfsDistance(edge[0], edge[1], edge[2]);
        }
        System.out.println(result);
    }

    private static void bfs(int row, int col, int numberOfIsland) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        map[row][col] = numberOfIsland;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            boolean isEdge = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (map[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    map[nx][ny] = numberOfIsland;
                    continue;
                }

                if (map[nx][ny] == 0 && !isEdge) {
                    isEdge = true;
                    list.add(new int[]{x, y, numberOfIsland});
                }
            }
        }
    }

    private static void bfsDistance(int row, int col, int numberOfIsland) {
        int[][] sumMap = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        sumMap[row][col] = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if (map[x][y] != 0 && map[x][y] != numberOfIsland) {
                result = Math.min(result, sumMap[x][y] - 2);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (map[nx][ny] != numberOfIsland && sumMap[nx][ny] == 0) {
                    sumMap[nx][ny] = sumMap[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
