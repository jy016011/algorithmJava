package codeTree.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _dxdy_7 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[][] matrix = new int[N + 1][N + 1];
        int M = Integer.parseInt(stringTokenizer.nextToken());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int row = Integer.parseInt(stringTokenizer.nextToken());
            int col = Integer.parseInt(stringTokenizer.nextToken());
            matrix[row][col] = 1;
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                int nextRow = row + dx[j];
                int nextCol = col + dy[j];
                if (nextRow < 1 || nextCol < 1 || nextRow > N || nextCol > N) {
                    continue;
                }
                if (matrix[nextRow][nextCol] == 1) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                stringBuilder.append(1).append(System.lineSeparator());
            } else {
                stringBuilder.append(0).append(System.lineSeparator());
            }
        }
        System.out.println(stringBuilder);
    }
}
