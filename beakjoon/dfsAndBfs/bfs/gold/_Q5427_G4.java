package beakjoon.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q5427_G4 {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final char EMPTY = '.';
    private static final char WALL = '#';
    private static final char SG = '@';
    private static final char FIRE = '*';
    private static Queue<int[]> sgQueue;
    private static Queue<int[]> fireQueue;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static char[][] map;
    private static int[][] sumMap;
    private static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder resultStringBuilder = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            w = Integer.parseInt(stringTokenizer.nextToken());
            h = Integer.parseInt(stringTokenizer.nextToken());
            map = new char[h][w];
            sumMap = new int[h][w];
            sgQueue = new LinkedList<>();
            fireQueue = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                String row = bufferedReader.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = row.charAt(j);
                    if (map[i][j] == SG) {
                        sgQueue.offer(new int[]{i, j});
                        sumMap[i][j] = 1;
                        continue;
                    }
                    if (map[i][j] == FIRE) {
                        fireQueue.offer(new int[]{i, j});
                    }
                }
            }
            int[] index = bfs();
            if (index[0] == -1) {
                resultStringBuilder.append(IMPOSSIBLE).append(System.lineSeparator());
            } else {
                resultStringBuilder.append(sumMap[index[0]][index[1]]).append(System.lineSeparator());
            }
        }
        System.out.println(resultStringBuilder);
    }

    private static int[] bfs() {
        while (!sgQueue.isEmpty()) {
            fireGrows();
            int sgQueueSize = sgQueue.size();
            for (int t = 0; t < sgQueueSize; t++) {
                if (sgQueue.isEmpty()) {
                    continue;
                }
                int[] sgCurrent = sgQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int sgNextX = sgCurrent[0] + dx[i];
                    int sgNextY = sgCurrent[1] + dy[i];
                    if (sgNextX < 0 || sgNextY < 0 || sgNextX >= h || sgNextY >= w) {
                        return new int[]{sgCurrent[0], sgCurrent[1]};
                    }

                    if (sumMap[sgNextX][sgNextY] == 0 && map[sgNextX][sgNextY] == EMPTY) {
                        sgQueue.offer(new int[]{sgNextX, sgNextY});
                        sumMap[sgNextX][sgNextY] = sumMap[sgCurrent[0]][sgCurrent[1]] + 1;
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static void fireGrows() {
        int currentFires = fireQueue.size();
        for (int i = 0; i < currentFires; i++) {
            if (fireQueue.isEmpty()) {
                continue;
            }
            int[] currentFire = fireQueue.poll();
            int x = currentFire[0];
            int y = currentFire[1];
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
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
