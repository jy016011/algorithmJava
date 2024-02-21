package beakjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
refactor code for Q14890 Gold 3
 */
public class _Q14890_G3_Refactor {
    private static int N, L, count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[N][N];
        int[][] transpose = new int[N][N];
        L = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                transpose[j][i] = map[i][j];
            }
        }
        checkPath(map);
        checkPath(transpose);

        System.out.println(count);
    }

    private static void checkPath(int[][] map) {
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
                    if (!makeUphill(row + 1, col, visited, map)) {
                        isPassed = false;
                        break;
                    }
                }
                // downhill
                if ((map[row][col] - map[row + 1][col]) == -1) {
                    if (!makeDownhill(row, col, visited, map)) {
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

    private static boolean makeUphill(int row, int col, boolean[] visited, int[][] map) {
        if (row + L > N) {
            return false;
        }
        int height = map[row][col];
        for (int i = 0; i < L; i++) {
            if (map[row + i][col] != height) {
                return false;
            }
            visited[row + i] = true;
        }
        return true;
    }

    private static boolean makeDownhill(int row, int col, boolean[] visited, int[][] map) {
        if (row - L + 1 < 0) {
            return false;
        }
        int height = map[row][col];
        for (int i = 0; i < L; i++) {
            if (visited[row - i]) {
                return false;
            }
            if (map[row - i][col] != height) {
                return false;
            }
            visited[row - i] = true;
        }
        return true;
    }
}
