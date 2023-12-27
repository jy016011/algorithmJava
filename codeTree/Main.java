package codeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        char[][] matrix = new char[n][m];
        int curRow = 0;
        int curCol = 0;
        matrix[curRow][curCol] = (char) 65;
        int dir = 0;
        int cycle = 1;
        while (cycle < n * m) {
            int nextRow = curRow + dx[dir];
            int nextCol = curCol + dy[dir];
            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m || matrix[nextRow][nextCol] != '\u0000') {
                if (dir == 3) {
                    dir = 0;
                } else {
                    dir++;
                }
                continue;
            }
            if (matrix[curRow][curCol] < 90) {
                matrix[nextRow][nextCol] = (char) ((int) matrix[curRow][curCol] + 1);
            } else {
                matrix[nextRow][nextCol] = (char) 65;
            }
            curRow = nextRow;
            curCol = nextCol;
            cycle++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] row : matrix) {
            for (char point : row) {
                stringBuilder.append(point).append(" ");
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }
}
