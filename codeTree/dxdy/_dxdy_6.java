package codeTree.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _dxdy_6 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = Integer.parseInt(bufferedReader.readLine());
        int curX = 0;
        int curY = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String direction = stringTokenizer.nextToken();
            int distance = Integer.parseInt(stringTokenizer.nextToken());
            int dir;
            if (direction.equals("N")) {
                dir = 0;
            } else if (direction.equals("E")) {
                dir = 1;
            } else if (direction.equals("S")) {
                dir = 2;
            } else {
                dir = 3;
            }
            for (int j = 0; j < distance; j++) {
                curX += dx[dir];
                curY += dy[dir];
                time++;
                if (curX == 0 && curY == 0) {
                    break;
                }
            }
            if (curX == 0 && curY == 0) {
                break;
            }
        }
        if (curX != 0 || curY != 0) {
            System.out.println(-1);
        } else {
            System.out.println(time);
        }
    }
}
