package beakjoon.backTracking.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q11967_G2 {

    private static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static int N, M, cnt;
    private static int[][] map;
    private static boolean[][] turnedOn;
    private static ArrayList<Node>[][] switchesInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N + 1][N + 1];
        map[1][1] = 1;
        turnedOn = new boolean[N + 1][N + 1];
        switchesInfo = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                switchesInfo[i][j] = new ArrayList<>();
            }
        }
        cnt = 1;
        M = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            switchesInfo[x][y].add(new Node(a, b));
        }
        bfs();
        System.out.println(cnt);
    }

    private static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[N + 1][N + 1];
        boolean isTurnedOnLight = false;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 1});
        visited[1][1] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if (!turnedOn[x][y]) {
                isTurnedOnLight = true;
                turnedOn[x][y] = true;
                for (Node willTurnOn : switchesInfo[x][y]) {
                    int a = willTurnOn.a;
                    int b = willTurnOn.b;
                    if (map[a][b] != 1) {
                        map[a][b] = 1;
                        cnt++;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || ny < 1 || nx > N || ny > N) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        if (isTurnedOnLight) {
            bfs();
        }
    }

}
