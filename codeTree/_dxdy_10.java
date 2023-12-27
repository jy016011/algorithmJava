package codeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _dxdy_10 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] matrix = new int[n][m];
        int curRow = 0;
        int curCol = 0;
        matrix[curRow][curCol] = 1;
        int dir = 0;
        int cycle = 0;
        while (cycle < n * m - 1) {
            int nextRow = curRow + dx[dir];
            int nextCol = curCol + dy[dir];
            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m || matrix[nextRow][nextCol] != 0) {
                if (dir == 3) {
                    dir = 0;
                } else {
                    dir++;
                }
                continue;
            }
            matrix[nextRow][nextCol] = matrix[curRow][curCol] + 1;
            curRow = nextRow;
            curCol = nextCol;
            cycle++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] row : matrix) {
            for (int point : row) {
                stringBuilder.append(point).append(" ");
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }
}
