package beakjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _Q15683_G4 {
    private static final int[] dx = {0, 0, 1, 0, -1};
    private static final int[] dy = {0, 1, 0, -1, 0};
    private static final int[] FIRST = {1, 1};
    private static final int[] SECOND = {1, 1, 3, 3};
    private static final int[] THIRD = {1, 1, 4, 4};
    private static final int[] FOURTH = {1, 1, 3, 3, 4, 4};
    private static final int[] FIFTH = {1, 1, 2, 2, 3, 3, 4, 4};

    private static int N, M;
    private static int[][] map;
    private static List<Cam> cams;
    private static List<List<Integer>> dirCombinations;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N][M];
        cams = new ArrayList<>();
        dirCombinations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cams.add(new Cam(i, j, map[i][j]));
                }
            }
        }
        getDirCombinations(new ArrayList<>());
        int min = Integer.MAX_VALUE;
        for (List<Integer> directions : dirCombinations) {
            List<Cam> changedCams = new ArrayList<>();
            for (int i = 0; i < cams.size(); i++) {
                Cam changed = cams.get(i).getChanged(directions.get(i));
                changedCams.add(changed);
            }
            min = Math.min(min, getArea(changedCams));
        }
        System.out.println(min);
    }

    private static int getArea(List<Cam> cams) {
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
        for (Cam cam : cams) {
            bfs(tempMap, cam);
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int[][] temp, Cam cam) {
        int x = cam.x;
        int y = cam.y;
        int[] range = cam.range;
        for (int i = 0; i < range.length; i += 2) {
            int nx = x + dx[range[i]];
            int ny = y + dy[range[i + 1]];
            if (nx == x && ny != y) { // y방향으로만 직진
                if (ny > y) { // 오른쪽으로
                    for (int j = ny; j < M; j++) {
                        if (temp[x][j] == 6) {
                            break;
                        }
                        if (temp[x][j] == 0) {
                            temp[x][j] = 7;
                        }
                    }
                } else { // 왼쪽으로
                    for (int j = ny; j >= 0; j--) {
                        if (temp[x][j] == 6) {
                            break;
                        }
                        if (temp[x][j] == 0) {
                            temp[x][j] = 7;
                        }
                    }
                }

            } else if (ny == y && nx != x) { // x방향으로만 직진
                if (nx > x) { // 아래로
                    for (int j = nx; j < N; j++) {
                        if (temp[j][y] == 6) {
                            break;
                        }
                        if (temp[j][y] == 0) {
                            temp[j][y] = 7;
                        }
                    }
                } else { // 위로
                    for (int j = nx; j >= 0; j--) {
                        if (temp[j][y] == 6) {
                            break;
                        }
                        if (temp[j][y] == 0) {
                            temp[j][y] = 7;
                        }
                    }
                }
            }
        }

    }

    private static void getDirCombinations(List<Integer> directions) {
        if (directions.size() == cams.size()) {
            dirCombinations.add(new ArrayList<>(directions));
            return;
        }
        for (int i = 0; i < 4; i++) {
            directions.add(i);
            getDirCombinations(directions);
            directions.remove(directions.size() - 1);
        }
    }

    public static class Cam {
        int x;
        int y;
        int id;
        int[] range;

        public Cam(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
            setRange();
        }

        public Cam(int x, int y, int id, int[] range) {
            this.x = x;
            this.y = y;
            this.id = id;
            this.range = range;
        }

        private void setRange() {
            if (id == 1) {
                range = FIRST;
                return;
            }
            if (id == 2) {
                range = SECOND;
                return;
            }
            if (id == 3) {
                range = THIRD;
                return;
            }
            if (id == 4) {
                range = FOURTH;
                return;
            }
            range = FIFTH;
        }

        public Cam getChanged(int idx) {
            int[] newDir = new int[range.length];
            for (int i = 0; i < newDir.length; i++) {
                int changed = range[i] + idx;
                if (changed > 4) {
                    changed = changed % 4;
                }
                newDir[i] = changed;
            }
            return new Cam(x, y, id, newDir);
        }
    }
}
