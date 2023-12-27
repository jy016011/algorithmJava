package codeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _dxdy_8 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        String commands = bufferedReader.readLine();
        int time = 0;
        int curX = 0;
        int curY = 0;
        int dir = 0;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            time++;
            if (command == 'F') {
                curX += dx[dir];
                curY += dy[dir];
                if (curX == 0 && curY == 0) {
                    break;
                }
                continue;
            }
            if (command == 'R') {
                if (dir == 3) {
                    dir = 0;
                    continue;
                }
                dir++;
            } else if (command == 'L') {
                if (dir == 0) {
                    dir = 3;
                    continue;
                }
                dir--;
            }
        }
        if (curX != 0 || curY != 0) {
            System.out.println(-1);
        } else {
            System.out.println(time);
        }
    }
}
