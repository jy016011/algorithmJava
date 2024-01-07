package beakjoon.backTracking.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
                            continue;
                        }
                        if (ch == DOCUMENT) {
                            cnt++;
                            map[i][j] = EMPTY;
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
