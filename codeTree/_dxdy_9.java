package codeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _dxdy_9 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int N = Integer.parseInt(bufferedReader.readLine());
        char[][] matrix = new char[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            String mirrorRow = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j + 1] = mirrorRow.charAt(j);
            }
        }
        int K = Integer.parseInt(bufferedReader.readLine());
        int laserDirection;
        int curX;
        int curY;
        int offset = K % N;
        if (K <= N) {
            laserDirection = 0;
            curX = 1;
            curY = offset;
        } else if (K <= 2 * N) {
            laserDirection = 1;
            curX = offset;
            curY = N;
        } else if (K <= 3 * N) {
            laserDirection = 2;
            curX = N;
            if (K == 3 * N) {
                curY = 1;
            } else {
                curY = N - offset + 1;
            }
        } else {
            laserDirection = 3;
            if (K == 4 * N) {
                curX = 0;
            } else {
                curX = N - offset + 1;
            }
            curY = 1;
        }
        int cnt = 1;
        while (true) {
            char mirror = matrix[curX][curY];
            if (mirror == '\\') {
                laserDirection = 3 - laserDirection;
            } else if (mirror == '/') {
                if (laserDirection == 0 || laserDirection == 1) {
                    laserDirection = 1 - laserDirection;
                } else {
                    laserDirection = 5 - laserDirection;
                }
            }
            int nx = curX + dx[laserDirection];
            int ny = curY + dy[laserDirection];
            if (nx < 1 || ny < 1 || nx > N || ny > N) {
                break;
            }
            curX = nx;
            curY = ny;
            cnt++;
        }
        System.out.println(cnt);
    }
}
