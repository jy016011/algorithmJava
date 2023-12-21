package beakjoon.backTracking.dfsAndBfs.bfs.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _Q2667_S1 {
    private static int[][] map;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < row.length(); j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        List<Integer> wides = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    count++;
                    map[i][j] = 0;
                    wides.add(bfs(i, j));
                }
            }
        }
        if (wides.isEmpty()) {
            wides.add(0);
        }
        StringBuilder stringBuilder = new StringBuilder(count + System.lineSeparator());
        wides.sort(Integer::compareTo);
        for (int wide : wides) {
            stringBuilder.append(wide).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private static int bfs(int pointX, int pointY) {
        int wide = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{pointX, pointY});
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (map[nx][ny] == 1) {
                    wide++;
                    map[nx][ny] = 0;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return wide;
    }
}
