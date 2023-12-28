package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _bruteForce_14 {
    private static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        char[][] matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = row.charAt(j);
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 'L') {
                    for (int dir = 0; dir < 8; dir++) {
                        int curRow = i;
                        int curCol = j;
                        int countOfE = 0;
                        for (int distance = 0; distance < 2; distance++) {
                            int nextRow = curRow + dx[dir];
                            int nextCol = curCol + dy[dir];
                            if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M
                                    || matrix[nextRow][nextCol] != 'E') {
                                continue;
                            }
                            curRow = nextRow;
                            curCol = nextCol;
                            countOfE++;
                        }
                        if (countOfE == 2) {
                            result++;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}