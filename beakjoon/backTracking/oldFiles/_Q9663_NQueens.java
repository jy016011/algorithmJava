package beakjoon.backTracking.oldFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q9663_NQueens {
    static int[] coordinates; //idx: row, value: col
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        coordinates = new int[n];
        putQueens(0);
        System.out.println(cnt);
    }

    public static void putQueens(int row) {
        if (row == n) {
            cnt += 1;
            return;
        }
        for (int col = 0; col < n; col++) {
            coordinates[row] = col;
            if (isValid(row)) {
                putQueens(row + 1);
            }
        }
    }

    public static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (coordinates[i] == coordinates[row]) { // line of col
                return false;
            } else if (Math.abs(row - i) == Math.abs(coordinates[row] - coordinates[i])) {
                return false;
            }
        }
        return true;
    }
}
