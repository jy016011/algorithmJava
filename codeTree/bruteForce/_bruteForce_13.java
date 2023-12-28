package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _bruteForce_13 {
    private static final ArrayList<int[]> winningStones = new ArrayList<>();
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        matrix = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 19; j++) {
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int winningStone = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (matrix[i][j] != 0) {
                    checkStones(i, j, matrix[i][j]);
                }
                if (winningStones.size() == 5) {
                    winningStone = matrix[i][j];
                    break;
                }
            }
            if (winningStones.size() == 5) {
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(winningStone).append(System.lineSeparator());
        if (winningStones.size() == 5) {
            for (int xy : winningStones.get(2)) {
                stringBuilder.append(xy + 1).append(" ");
            }
        }

        System.out.println(stringBuilder);
    }

    private static void checkStones(int row, int col, int stone) {
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int dir = 0; dir < 8; dir++) {
            int curRow = row;
            int curCol = col;
            winningStones.add(new int[]{curRow, curCol});
            for (int i = 0; i < 4; i++) {
                int nr = curRow + dr[dir];
                int nc = curCol + dc[dir];
                if (nr < 0 || nc < 0 || nr >= 19 || nc >= 19 || matrix[nr][nc] != stone) {
                    winningStones.clear();
                    break;
                }
                if (matrix[nr][nc] == stone) {
                    winningStones.add(new int[]{nr, nc});
                    curRow = nr;
                    curCol = nc;
                }
            }
            if (winningStones.size() == 5) {
                break;
            }
        }
    }
}
