package codeTree.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _dxdy_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[][] matrix = new int[n + 1][n + 1];
        int t = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        String direction = stringTokenizer.nextToken();
        int dir;
        if (direction.equals("U")) {
            dir = 0;
        } else if (direction.equals("D")) {
            dir = 3;
        } else if (direction.equals("R")) {
            dir = 1;
        } else {
            dir = 2;
        }
        for (int i = 1; i <= t; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                dir = 3 - dir;
                continue;
            }
            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
    }
}
