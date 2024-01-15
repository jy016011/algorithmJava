package beakjoon.backTracking.dfsAndBfs.bfs.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q3197_P5_TimeOut {
    private static final char WATER = '.';
    private static final char ICE = 'X';
    private static final char SWAN = 'L';
    private static int R, C;
    private static char[][] map;
    private static List<int[]> swansPoint;
    private static List<int[]> meltingIces;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[R][C];
        swansPoint = new ArrayList<>();
        meltingIces = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                char ch = row.charAt(j);
                if (ch == SWAN) {
                    swansPoint.add(new int[]{i, j});
                }
                map[i][j] = ch;
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        int time = 0;
        while (!isSwanMet()) {
            iceMelting();
            time++;
        }
        return time;
    }

    private static boolean isSwanMet() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        int startX = swansPoint.get(0)[0];
        int startY = swansPoint.get(0)[1];
        queue.offer(swansPoint.get(0));
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if (map[x][y] == SWAN && (x != startX || y != startY)) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] != ICE) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }

    private static void iceMelting() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == ICE && isNearToWater(i, j)) {
                    meltingIces.add(new int[]{i, j});
                }
            }
        }

        for (int[] ice : meltingIces) {
            int x = ice[0];
            int y = ice[1];
            map[x][y] = WATER;
        }

        meltingIces.clear();
    }

    private static boolean isNearToWater(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }
            if (map[nx][ny] == WATER || map[nx][ny] == SWAN) {
                return true;
            }
        }
        return false;
    }
}
