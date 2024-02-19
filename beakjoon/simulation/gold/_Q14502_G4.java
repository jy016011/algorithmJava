package beakjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q14502_G4 {
    private static int N, M, safeArea, answer;
    private static int[][] map;
    private static List<int[]> viruses;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N][M];
        viruses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (map[i][j] == 0) {
                    safeArea++;
                    continue;
                }
                if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        pickWall(0, 0, 0);
        System.out.println(answer);
    }

    private static void pickWall(int depth, int startRow, int startCol) {
        if (depth == 3) {
            boolean[][] visited = new boolean[N][M];
            int temp = safeArea;
            safeArea -= 3;
            for (int[] virus :
                    viruses) {
                if (!visited[virus[0]][virus[1]]) {
                    bfs(virus[0], virus[1], visited);
                }
            }
            answer = Math.max(answer, safeArea);
            safeArea = temp;
            return;
        }
        for (int i = startRow; i < N; i++) {
            for (int j = startCol; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    pickWall(depth + 1, i, j + 1);
                    map[i][j] = 0;
                }
            }
            startCol = 0;
        }
    }

    private static void bfs(int startX, int startY, boolean[][] visited) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    safeArea--;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

    }
}
