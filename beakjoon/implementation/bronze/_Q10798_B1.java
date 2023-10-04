package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q10798_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] matrix = new char[5][15];
        for (int i = 0; i < 5; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < row.length; j++) {
                matrix[i][j] = row[j];
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[j][i] != '\0')
                    sb.append(matrix[j][i]);
            }
        }
        System.out.println(sb);
    }
}
