package beakjoon.implementation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1018_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int min = N * M;
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = bufferedReader.readLine().toCharArray();
        }
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cnt = 0;
                char compare = 'W';
                for (int k = i; k < i + 8; k++) {
                    if (compare != board[k][j]){
                        cnt++;
                    }
                    for (int l = j; l < j + 7; l++) {
                        if (compare == 'B'){
                            if (board[k][l + 1] != 'W') {
                                cnt++;
                            }
                            compare = 'W';
                        }
                        else {
                            if (board[k][l + 1] != 'B') {
                                cnt++;
                            }
                            compare = 'B';
                        }
                    }
                }
                min = Math.min(min, cnt);
                cnt = 0;
                compare = 'B';
                for (int k = i; k < i + 8; k++) {
                    if (compare != board[k][j]){
                        cnt++;
                    }
                    for (int l = j; l < j + 7; l++) {
                        if (compare == 'B'){
                            if (board[k][l + 1] != 'W') {
                                cnt++;
                            }
                            compare = 'W';
                        }
                        else {
                            if (board[k][l + 1] != 'B') {
                                cnt++;
                            }
                            compare = 'B';
                        }
                    }
                }
                min = Math.min(min, cnt);
            }
        }
        System.out.println(min);
    }
}
