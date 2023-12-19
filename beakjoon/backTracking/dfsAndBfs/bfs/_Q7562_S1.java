package beakjoon.backTracking.dfsAndBfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q7562_S1 {
    private static final int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
    private static int[][] map;

    private static int I, targetX, targetY;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            I = Integer.parseInt(bufferedReader.readLine());
            map = new int[I][I];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int startX = Integer.parseInt(stringTokenizer.nextToken());
            int startY = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            targetX = Integer.parseInt(stringTokenizer.nextToken());
            targetY = Integer.parseInt(stringTokenizer.nextToken());
            bfs(startX, startY);
            stringBuilder.append(map[targetX][targetY]).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            if (x == targetX && y == targetY) {
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= I || ny < 0 || ny >= I) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    map[nx][ny] = map[x][y] + 1;
                }
            }
        }
    }
}
