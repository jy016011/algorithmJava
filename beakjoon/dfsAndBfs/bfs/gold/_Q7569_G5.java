package beakjoon.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q7569_G5 {
    private static Queue<int[]> queue;
    private static int[][][] tomatoes;
    private static int M, N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken()); // col
        N = Integer.parseInt(stringTokenizer.nextToken()); // row
        H = Integer.parseInt(stringTokenizer.nextToken()); // height
        tomatoes = new int[H][N][M];
        queue = new LinkedList<>();
        for (int height = 0; height < H; height++) {
            for (int row = 0; row < N; row++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int col = 0; col < M; col++) {
                    int tomato = Integer.parseInt(stringTokenizer.nextToken());
                    tomatoes[height][row][col] = tomato;
                    if (tomato == 1) {
                        queue.offer(new int[]{row, col, height});
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            int z = coordinate[2];
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
                    continue;
                }
                if (tomatoes[nz][nx][ny] == 0) {
                    tomatoes[nz][nx][ny] = tomatoes[z][x][y] + 1;
                    max = Math.max(max, tomatoes[nz][nx][ny]);
                    queue.offer(new int[]{nx, ny, nz});
                }
            }
        }

        for (int height = 0; height < H; height++) {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if (tomatoes[height][row][col] == 0) {
                        return -1;
                    }
                }
            }
        }
        if (max == Integer.MIN_VALUE) {
            return 0;
        }
        return max - 1;
    }
}
