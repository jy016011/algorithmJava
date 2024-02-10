package beakjoon.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q2206_G3 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static boolean[][] visitedWithCrash;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        visitedWithCrash = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1, false));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.row;
            int y = current.col;
            if (x == N - 1 && y == M - 1) {
                return current.movedDistance;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (map[nx][ny] == 1 && !current.isAlreadyCrashed) {
                    visitedWithCrash[nx][ny] = true;
                    queue.offer(new Node(nx, ny, current.movedDistance + 1, true));
                }
                if (map[nx][ny] == 0) {
                    if (current.isAlreadyCrashed && !visitedWithCrash[nx][ny]) {
                        visitedWithCrash[nx][ny] = true;
                        queue.offer(new Node(nx, ny, current.movedDistance + 1, current.isAlreadyCrashed));
                    }
                    if (!current.isAlreadyCrashed && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, current.movedDistance + 1, current.isAlreadyCrashed));
                    }
                }
            }
        }
        return -1;
    }

    private static class Node {
        final int row;
        final int col;
        final int movedDistance;
        final boolean isAlreadyCrashed;

        public Node(int row, int col, int movedDistance, boolean isAlreadyCrashed) {
            this.row = row;
            this.col = col;
            this.movedDistance = movedDistance;
            this.isAlreadyCrashed = isAlreadyCrashed;
        }
    }
}
