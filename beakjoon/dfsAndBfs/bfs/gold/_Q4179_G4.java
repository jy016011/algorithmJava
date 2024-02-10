package beakjoon.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q4179_G4 {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final char WALL = '#';
    private static final char EMPTY = '.';
    private static final char JH = 'J';
    private static final char FIRE = 'F';
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static Queue<int[]> jhQueue;
    private static Queue<int[]> fireQueue;
    private static int R, C;
    private static char[][] map;
    private static int[][] sumMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[R][C];
        sumMap = new int[R][C];
        jhQueue = new LinkedList<>();
        fireQueue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == FIRE) {
                    fireQueue.offer(new int[]{i, j});
                    continue;
                }
                if (map[i][j] == JH) {
                    sumMap[i][j] = 1;
                    jhQueue.offer(new int[]{i, j});
                }
            }
        }
        int minute = bfsJH();
        if (minute == -1) {
            System.out.println(IMPOSSIBLE);
            return;
        }
        System.out.println(minute);
    }

    private static int bfsJH() {
        while (!jhQueue.isEmpty()) {
            bfsFire();
            int size = jhQueue.size();
            for (int i = 0; i < size; i++) {
                if (!jhQueue.isEmpty()) {
                    int[] current = jhQueue.poll();
                    int x = current[0];
                    int y = current[1];
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                            return sumMap[x][y];
                        }
                        if (sumMap[nx][ny] == 0 && map[nx][ny] == EMPTY) {
                            sumMap[nx][ny] = sumMap[x][y] + 1;
                            jhQueue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static void bfsFire() {
        int size = fireQueue.size();
        for (int i = 0; i < size; i++) {
            if (!fireQueue.isEmpty()) {
                int[] current = fireQueue.poll();
                int x = current[0];
                int y = current[1];
                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                        continue;
                    }
                    if (map[nx][ny] != FIRE && map[nx][ny] != WALL) {
                        map[nx][ny] = FIRE;
                        fireQueue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
