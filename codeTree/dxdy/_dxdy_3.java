package codeTree.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _dxdy_3 {
    private static int result, n;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visitMap(i, j, matrix);
            }
        }
        System.out.println(result);
    }

    private static void visitMap(int x, int y, int[][] matrix) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (matrix[nx][ny] == 1) {
                cnt++;
            }
        }
        if (cnt >= 3) {
            result++;
        }
    }
}
