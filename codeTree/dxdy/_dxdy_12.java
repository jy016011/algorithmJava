package codeTree.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _dxdy_12 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] matrix = new int[n][n];
        int curRow = (n - 1) / 2;
        int curCol = (n - 1) / 2;
        matrix[curRow][curCol] = 1;
        int cycle = 1;
        int dir = 0;
        int distance = 1;
        while (cycle < n * n) {
            for (int i = 0; i < distance; i += 2) {
                if (cycle == n * n) {
                    break;
                }
                int nextRow = curRow + dx[dir];
                int nextCol = curCol + dy[dir];
                matrix[nextRow][nextCol] = matrix[curRow][curCol] + 1;
                curRow = nextRow;
                curCol = nextCol;
                cycle++;
            }
            if (dir == 3) {
                dir = 0;
            } else {
                dir++;
            }
            distance++;
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
