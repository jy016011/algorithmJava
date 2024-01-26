package beakjoon.shortTermGrowth.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q3197_P5 {
    private static final char WATER = '.';
    private static final char ICE = 'X';
    private static final char SWAN = 'L';
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static char[][] map;
    private static boolean[][] visited;
    private static int R, C;
    private static Queue<int[]> swanQueue;
    private static Queue<int[]> water;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        swanQueue = new LinkedList<>();
        water = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                char ch = row.charAt(j);
                map[i][j] = ch;
                if (ch != ICE) {
                    water.offer(new int[]{i, j});
                }
                if (ch == SWAN && swanQueue.isEmpty()) {
                    swanQueue.offer(new int[]{i, j});
                    map[i][j] = WATER;
                    visited[i][j] = true;
                }
            }
        }
        int day = 0;
        while (!isSwanMet()) {
            meltIce();
            day++;
        }
        System.out.println(day);
    }

    private static boolean isSwanMet() {
        Queue<int[]> nextQueue = new LinkedList<>();
        while (!swanQueue.isEmpty()) {
            int[] current = swanQueue.poll();
            int x = current[0];
            int y = current[1];
            if (map[x][y] == SWAN) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isOutOfBound(nx, ny)) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] != ICE) {
                    visited[nx][ny] = true;
                    swanQueue.offer(new int[]{nx, ny});
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == ICE) {
                    visited[nx][ny] = true;
                    nextQueue.offer(new int[]{nx, ny});
                }
            }
        }
        swanQueue = nextQueue;
        return false;
    }

    private static void meltIce() {
        int size = water.size();
        for (int i = 0; i < size; i++) {
            if (!water.isEmpty()) {
                int[] current = water.poll();
                int x = current[0];
                int y = current[1];
                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (isOutOfBound(nx, ny)) {
                        continue;
                    }
                    if (map[nx][ny] == ICE) {
                        map[nx][ny] = WATER;
                        water.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private static boolean isOutOfBound(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= R || ny >= C;
    }
}
