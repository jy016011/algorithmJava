package codeTree.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _dxdy_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[] current = new int[2];
        for (int i = 0; i < N; i++) {
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
            current[0] += dx[dir] * distance;
            current[1] += dy[dir] * distance;
        }
        System.out.println(current[0] + " " + current[1]);
    }

}
