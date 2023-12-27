package codeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _dxdy_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String commands = bufferedReader.readLine();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int curX = 0;
        int curY = 0;
        int dir = 0;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'F') {
                curX += dx[dir];
                curY += dy[dir];
            } else if (command == 'L') {
                if (dir == 0) {
                    dir = 3;
                } else {
                    dir -= 1;
                }
            } else {
                if (dir == 3) {
                    dir = 0;
                } else {
                    dir += 1;
                }
            }
        }
        System.out.println(curX + " " + curY);
    }
}
