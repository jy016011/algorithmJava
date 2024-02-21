package beakjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
solved ASAP in time
 */
public class _Q14890_G3 {
    private static int N, L;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N][N];
        L = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int count = 0;
        if (L == 1) {
            for (int col = 0; col < N; col++) {
                boolean[] visited = new boolean[N];
                boolean isPassed = true;
                for (int row = 0; row < N - 1; row++) {
                    if (Math.abs(map[row][col] - map[row + 1][col]) >= 2) {
                        isPassed = false;
                        break;
                    }
                    // uphill
                    if ((map[row][col] - map[row + 1][col]) == 1) {
                        visited[row + 1] = true;
                    }
                    if ((map[row][col] - map[row + 1][col]) == -1) {
                        if (visited[row]) {
                            isPassed = false;
                            break;
                        }
                    }
                }
                if (isPassed) {
                    count++;
                }
            }
            for (int row = 0; row < N; row++) {
                boolean[] visited = new boolean[N];
                boolean isPassed = true;
                for (int col = 0; col < N - 1; col++) {
                    if (Math.abs(map[row][col] - map[row][col + 1]) >= 2) {
                        isPassed = false;
                        break;
                    }
                    // lefthill
                    if ((map[row][col] - map[row][col + 1]) == 1) {
                        visited[col + 1] = true;
                    }
                    // righthill
                    if ((map[row][col] - map[row][col + 1]) == -1) {
                        if (visited[col]) {
                            isPassed = false;
                            break;
                        }
                    }
                }
                if (isPassed) {
                    count++;
                }
            }

        } else {
            for (int col = 0; col < N; col++) {
                boolean[] visited = new boolean[N];
                boolean isPassed = true;
                for (int row = 0; row < N - 1; row++) {
                    if (Math.abs(map[row][col] - map[row + 1][col]) >= 2) {
                        isPassed = false;
                        break;
                    }
                    // uphill
                    if ((map[row][col] - map[row + 1][col]) == 1) {
                        if (!makeUphill(row + 1, col, visited)) {
                            isPassed = false;
                            break;
                        }
                    }
                    // downhill
                    if ((map[row][col] - map[row + 1][col]) == -1) {
                        if (!makeDownhill(row, col, visited)) {
                            isPassed = false;
                            break;
                        }
                    }
                }
                if (isPassed) {
                    count++;
                }
            }
            for (int row = 0; row < N; row++) {
                boolean[] visited = new boolean[N];
                boolean isPassed = true;
                for (int col = 0; col < N - 1; col++) {
                    if (Math.abs(map[row][col] - map[row][col + 1]) >= 2) {
                        isPassed = false;
                        break;
                    }
                    // lefthill
                    if ((map[row][col] - map[row][col + 1]) == 1) {
                        if (!makeLefthill(row, col + 1, visited)) {
                            isPassed = false;
                            break;
                        }
                    }
                    // righthill
                    if ((map[row][col] - map[row][col + 1]) == -1) {
                        if (!makeRighthill(row, col, visited)) {
                            isPassed = false;
                            break;
                        }
                    }
                }
                if (isPassed) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean makeUphill(int row, int col, boolean[] visited) {
        if (row + L > N) {
            return false;
        }
        for (int i = row; i < (row + L) - 1; i++) {
            if (map[i][col] != map[i + 1][col]) {
                return false;
            }
            visited[i] = true;
            visited[i + 1] = true;
        }
        return true;
    }

    private static boolean makeDownhill(int row, int col, boolean[] visited) {
        if (row - L + 1 < 0) {
            return false;
        }
        for (int i = row; i > row - L + 1; i--) {
            if (map[i][col] != map[i - 1][col]) {
                return false;
            }
            if (visited[i] || visited[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean makeLefthill(int row, int col, boolean[] visited) {
        if (col + L > N) {
            return false;
        }
        for (int i = col; i < (col + L) - 1; i++) {
            if (map[row][i] != map[row][i + 1]) {
                return false;
            }
            visited[i] = true;
            visited[i + 1] = true;
        }
        return true;
    }

    private static boolean makeRighthill(int row, int col, boolean[] visited) {
        if (col - L + 1 < 0) {
            return false;
        }
        for (int i = col; i > col - L + 1; i--) {
            if (map[row][i] != map[row][i - 1]) {
                return false;
            }
            if (visited[i] || visited[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
