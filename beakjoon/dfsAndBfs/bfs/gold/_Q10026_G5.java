package beakjoon.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _Q10026_G5 {
    private static int N;
    private static Set<Character> colors;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        colors = new HashSet<>(Set.of('R', 'G', 'B'));
        char[][] draw = new char[N][N];
        char[][] colorBlindSeen = new char[N][N];
        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                char point = row.charAt(j);
                draw[i][j] = point;
                if (point == 'R') {
                    colorBlindSeen[i][j] = 'G';
                    continue;
                }
                colorBlindSeen[i][j] = point;
            }
        }
        int notColorBlindCount = 0;
        int colorBlindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (colors.contains(draw[i][j])) {
                    bfs(i, j, draw);
                    notColorBlindCount++;
                }
                if (colors.contains(colorBlindSeen[i][j])) {
                    bfs(i, j, colorBlindSeen);
                    colorBlindCount++;
                }
            }
        }
        System.out.println(notColorBlindCount + " " + colorBlindCount);
    }

    private static void bfs(int pointX, int pointY, char[][] draw) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        char color = draw[pointX][pointY];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{pointX, pointY});
        draw[pointX][pointY] = '0';
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (colors.contains(draw[nx][ny]) && draw[nx][ny] == color) {
                    draw[nx][ny] = '0';
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
