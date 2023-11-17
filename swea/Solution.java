package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase = 1; testCase <= 10; testCase++) {
            bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder(String.format("#%d ", testCase));
            int[][] matrix = new int[100][100];
            int rowMax = 0;
            int colMax = 0;
            int toRightDiagonalMax = 0;
            int toLeftDiagonlaMax = 0;
            for (int i = 0; i < 100; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int rowSum = 0;
                for (int j = 0; j < 100; j++) {
                    matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                    if (i == j) {
                        toRightDiagonalMax += matrix[i][j];
                    } else if (j == 99 - i) {
                        toLeftDiagonlaMax += matrix[i][j];
                    }
                    rowSum += matrix[i][j];
                }
                rowMax = Math.max(rowMax, rowSum);
            }
            int diagonalMax = Math.max(toRightDiagonalMax, toLeftDiagonlaMax);
            int max = Math.max(rowMax, diagonalMax);
            for (int i = 0; i < 100; i++) {
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                    colSum += matrix[j][i];
                }
                colMax = Math.max(colMax, colSum);
            }
            max = Math.max(colMax, max);
            stringBuilder.append(max);
            System.out.println(stringBuilder);
        }
    }
}
