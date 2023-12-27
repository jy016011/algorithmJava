package codeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _dxdy_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken()); // row
        int m = Integer.parseInt(stringTokenizer.nextToken()); // col
        int[][] matrix = new int[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;
        int curRow = 0;
        int curCol = 0;
        matrix[curRow][curCol] = 1;
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                stringBuilder.append(matrix[i][j]).append(" ");
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }
}
