package beakjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q12100_G2 {
    private static int N, result;
    private static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[6][N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[0][i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        up(0);
        right(0);
        left(0);
        down(0);

        System.out.println(result);
    }

    private static void up(int depth) {
        if (depth == 5) {
            result = Math.max(result, countMax());
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] merged = new boolean[N][N];
        map[depth + 1] = new int[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[depth][x][y] == 0) {
                    continue;
                }
                map[depth + 1][x][y] = map[depth][x][y];
                queue.offer(x);
                while (!queue.isEmpty()) {
                    int curX = queue.poll();
                    int nx = curX - 1;
                    if (nx < 0) {
                        break;
                    }
                    if (map[depth + 1][nx][y] == 0) {
                        map[depth + 1][nx][y] = map[depth + 1][curX][y];
                        map[depth + 1][curX][y] = 0;
                        queue.offer(nx);
                        continue;
                    }
                    if (!merged[nx][y] && map[depth + 1][nx][y] == map[depth + 1][curX][y]) {
                        merged[nx][y] = true;
                        map[depth + 1][nx][y] += map[depth + 1][curX][y];
                        map[depth + 1][curX][y] = 0;
                    }
                }
            }
        }
        up(depth + 1);
        right(depth + 1);
        down(depth + 1);
        left(depth + 1);
    }

    private static void down(int depth) {
        if (depth == 5) {
            result = Math.max(result, countMax());
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] merged = new boolean[N][N];
        map[depth + 1] = new int[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = N - 1; x >= 0; x--) {
                if (map[depth][x][y] == 0) {
                    continue;
                }
                map[depth + 1][x][y] = map[depth][x][y];
                queue.offer(x);
                while (!queue.isEmpty()) {
                    int curX = queue.poll();
                    int nx = curX + 1;
                    if (nx >= N) {
                        break;
                    }
                    if (map[depth + 1][nx][y] == 0) {
                        map[depth + 1][nx][y] = map[depth + 1][curX][y];
                        map[depth + 1][curX][y] = 0;
                        queue.offer(nx);
                        continue;
                    }
                    if (!merged[nx][y] && map[depth + 1][nx][y] == map[depth + 1][curX][y]) {
                        merged[nx][y] = true;
                        map[depth + 1][nx][y] += map[depth + 1][curX][y];
                        map[depth + 1][curX][y] = 0;
                    }
                }
            }
        }
        up(depth + 1);
        right(depth + 1);
        down(depth + 1);
        left(depth + 1);
    }

    private static void left(int depth) {
        if (depth == 5) {
            result = Math.max(result, countMax());
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] merged = new boolean[N][N];
        map[depth + 1] = new int[N][N];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[depth][x][y] == 0) {
                    continue;
                }
                map[depth + 1][x][y] = map[depth][x][y];
                queue.offer(y);
                while (!queue.isEmpty()) {
                    int curY = queue.poll();
                    int ny = curY - 1;
                    if (ny < 0) {
                        break;
                    }
                    if (map[depth + 1][x][ny] == 0) {
                        map[depth + 1][x][ny] = map[depth + 1][x][curY];
                        map[depth + 1][x][curY] = 0;
                        queue.offer(ny);
                        continue;
                    }
                    if (!merged[x][ny] && map[depth + 1][x][ny] == map[depth + 1][x][curY]) {
                        merged[x][ny] = true;
                        map[depth + 1][x][ny] += map[depth + 1][x][curY];
                        map[depth + 1][x][curY] = 0;
                    }
                }
            }
        }
        up(depth + 1);
        right(depth + 1);
        down(depth + 1);
        left(depth + 1);
    }

    private static void right(int depth) {
        if (depth == 5) {
            result = Math.max(result, countMax());
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] merged = new boolean[N][N];
        map[depth + 1] = new int[N][N];
        for (int x = 0; x < N; x++) {
            for (int y = N - 1; y >= 0; y--) {
                if (map[depth][x][y] == 0) {
                    continue;
                }
                map[depth + 1][x][y] = map[depth][x][y];
                queue.offer(y);
                while (!queue.isEmpty()) {
                    int curY = queue.poll();
                    int ny = curY + 1;
                    if (ny >= N) {
                        break;
                    }
                    if (map[depth + 1][x][ny] == 0) {
                        map[depth + 1][x][ny] = map[depth + 1][x][curY];
                        map[depth + 1][x][curY] = 0;
                        queue.offer(ny);
                        continue;
                    }
                    if (!merged[x][ny] && map[depth + 1][x][ny] == map[depth + 1][x][curY]) {
                        merged[x][ny] = true;
                        map[depth + 1][x][ny] += map[depth + 1][x][curY];
                        map[depth + 1][x][curY] = 0;
                    }
                }
            }
        }
        up(depth + 1);
        right(depth + 1);
        down(depth + 1);
        left(depth + 1);
    }

    private static int countMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, map[5][i][j]);
            }
        }
        return max;
    }
}
