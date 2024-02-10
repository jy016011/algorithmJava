package beakjoon.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q6593_G5 {
    private static final String ESCAPED = "Escaped in %d minute(s).";
    private static final String TRAPPED = "Trapped!";
    private static char[][][] building;
    private static int[][][] sumMap;
    private static Queue<int[]> queue;
    private static int L, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            L = Integer.parseInt(stringTokenizer.nextToken());
            R = Integer.parseInt(stringTokenizer.nextToken());
            C = Integer.parseInt(stringTokenizer.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            building = new char[L][R][C];
            sumMap = new int[L][R][C];
            int[] endPoint = new int[3];
            queue = new LinkedList<>();
            for (int height = 0; height < L; height++) {
                for (int row = 0; row < R + 1; row++) {
                    String rowString = bufferedReader.readLine();
                    if (rowString.length() != C) {
                        continue;
                    }
                    for (int col = 0; col < C; col++) {
                        char point = rowString.charAt(col);
                        building[height][row][col] = point;
                        if (point == 'S') {
                            queue.offer(new int[]{row, col, height});
                            building[height][row][col] = '#';
                        }
                        if (point == 'E') {
                            endPoint = new int[]{row, col, height};
                        }
                    }
                }
            }
            bfs();
            int height = endPoint[2];
            int row = endPoint[0];
            int col = endPoint[1];
            if (sumMap[height][row][col] == 0) {
                result.append(TRAPPED).append(System.lineSeparator());
                continue;
            }
            result.append(String.format(ESCAPED, sumMap[height][row][col])).append(System.lineSeparator());

        }
        System.out.println(result);
    }

    private static void bfs() {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            int z = coordinate[2];
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L) {
                    continue;
                }
                if (building[nz][nx][ny] != '#') {
                    sumMap[nz][nx][ny] = sumMap[z][x][y] + 1;
                    building[nz][nx][ny] = '#';
                    queue.offer(new int[]{nx, ny, nz});
                }
            }
        }
    }
}
