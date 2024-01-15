package beakjoon.backTracking.dfsAndBfs.bfs.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q3197_P5 {
    private static final char WATER = '.';
    private static final char ICE = 'X';
    private static final char SWAN = 'L';
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int R, C, targetX, targetY;
    private static char[][] map;
    private static boolean[][] visited;
    private static Queue<int[]> searchQueue;
    private static Queue<int[]> water;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        searchQueue = new LinkedList<>();
        water = new LinkedList<>();
        List<int[]> swans = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                char ch = row.charAt(j);
                if (ch == SWAN) {
                    int[] point = new int[]{i, j};
                    swans.add(point);
                    water.offer(point);
                } else if (ch == WATER) {
                    water.offer(new int[]{i, j});
                }
                map[i][j] = ch;
            }
        }
        int[] first = swans.get(0);
        int[] second = swans.get(1);
        searchQueue.offer(first);
        visited[first[0]][first[1]] = true;
        targetX = second[0];
        targetY = second[1];
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
        Queue<int[]> temp = new LinkedList<>();
        while (!searchQueue.isEmpty()) {
            int[] current = searchQueue.poll();
            int x = current[0];
            int y = current[1];
            if (x == targetX && y == targetY) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isOutOfRange(nx, ny)) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] != ICE) {
                    searchQueue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == ICE) {
                    temp.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        searchQueue = temp;
        return false;
    }

    private static void iceMelting() {
        int size = water.size();
        for (int i = 0; i < size; i++) {
            if (!water.isEmpty()) {
                int[] current = water.poll();
                int x = current[0];
                int y = current[1];
                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (isOutOfRange(nx, ny)) {
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

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= R || y >= C;
    }
}
