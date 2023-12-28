package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _bruteForce_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());
        char[][] matrix = new char[R][C];
        for (int i = 0; i < R; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < C; j++) {
                matrix[i][j] = stringTokenizer.nextToken().charAt(0);
            }
        }
        int cnt = 0;
        for (int i = 1; i < R - 2; i++) {
            for (int j = 1; j < C - 2; j++) {
                if (matrix[i][j] == matrix[0][0]) {
                    continue;
                }
                for (int k = i + 1; k < R - 1; k++) {
                    for (int l = j + 1; l < C - 1; l++) {
                        if (matrix[k][l] == matrix[i][j]) {
                            continue;
                        }
                        if (matrix[k][l] != matrix[R - 1][C - 1]) {
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
