package beakjoon.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class _Q9328_G1 {
    private static final char WALL = '*';
    private static final char EMPTY = '.';
    private static final char DOCUMENT = '$';
    private static int h, w, cnt;
    private static char[][] map;
    private static List<int[]> entries;
    private static Set<Character> keys;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            h = Integer.parseInt(stringTokenizer.nextToken());
            w = Integer.parseInt(stringTokenizer.nextToken());
            map = new char[h][w];
            cnt = 0;
            entries = new ArrayList<>();
            keys = new HashSet<>();
            for (int i = 0; i < h; i++) {
                String row = bufferedReader.readLine();
                for (int j = 0; j < w; j++) {
                    char ch = row.charAt(j);
                    map[i][j] = ch;
                    if ((i == 0 || j == 0 || i == h - 1 || j == w - 1) && ch != WALL) {
                        if (isDoor(ch) || ch == EMPTY) {
                            entries.add(new int[]{i, j});
                            continue;
                        }
                        if (isKey(ch)) {
                            keys.add(ch);
                            map[i][j] = WALL;
                            entries.add(new int[]{i, j});
                            continue;
                        }
                        if (ch == DOCUMENT) {
                            cnt++;
                            map[i][j] = WALL;
                            entries.add(new int[]{i, j});
                        }
                    }
                }
            }

            String keyOwned = bufferedReader.readLine();
            if (!keyOwned.equals("0")) {
                for (int i = 0; i < keyOwned.length(); i++) {
                    keys.add(keyOwned.charAt(i));
                }
            }
            bfs();
            stringBuilder.append(cnt).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean getNewKey = false;
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> cantOpenDoors = new ArrayList<>();
        for (int[] entrance : entries) {
            int x = entrance[0];
            int y = entrance[1];
            if (isDoor(map[x][y])) {
                if (!canOpen(map[x][y])) {
                    cantOpenDoors.add(entrance);
                    continue;
                }
            }
            queue.add(entrance);
        }
        entries = cantOpenDoors;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == WALL) {
                    continue;
                }
                char nextValue = map[nx][ny];

                if (isDoor(nextValue)) {
                    if (canOpen(nextValue)) {
                        map[nx][ny] = WALL;
                        queue.offer(new int[]{nx, ny});
                    } else {
                        entries.add(new int[]{nx, ny});
                    }
                    continue;
                }

                if (nextValue == DOCUMENT) {
                    map[nx][ny] = WALL;
                    cnt++;
                    queue.offer(new int[]{nx, ny});
                    continue;
                }

                if (isKey(nextValue)) {
                    if (!keys.contains(nextValue)) {
                        keys.add(nextValue);
                        getNewKey = true;
                    }
                    map[nx][ny] = WALL;
                    queue.offer(new int[]{nx, ny});
                    continue;
                }

                if (nextValue == EMPTY) {
                    map[nx][ny] = WALL;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        if (getNewKey) {
            bfs();
        }
    }

    private static boolean isDoor(char element) {
        return (element >= 65 && element <= 90);
    }

    private static boolean isKey(char element) {
        return (element >= 97 && element <= 122);
    }

    private static boolean canOpen(char door) {
        char lowerCase = Character.toLowerCase(door);
        return keys.contains(lowerCase);
    }
}
