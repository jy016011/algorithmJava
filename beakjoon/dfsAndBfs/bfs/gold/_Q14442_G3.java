package beakjoon.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q14442_G3 {
    private static class Node {
        int x;
        int y;
        int k;
        int distance;

        public Node(int x, int y, int k, int distance) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.distance = distance;
        }
    }

    private static int N, M, K;
    private static int[][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][K + 1];
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
        queue.offer(new Node(0, 0, K, 1));
        visited[0][0][K] = true;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.x == N - 1 && current.y == M - 1) {
                return current.distance;
            }
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (current.k > 0) {
                    if (!visited[nx][ny][current.k - 1] && map[nx][ny] == 1) {
                        visited[nx][ny][current.k - 1] = true;
                        queue.offer(new Node(nx, ny, current.k - 1, current.distance + 1));
                    }
                    if (!visited[nx][ny][current.k] && map[nx][ny] == 0) {
                        visited[nx][ny][current.k] = true;
                        queue.offer(new Node(nx, ny, current.k, current.distance + 1));
                    }
                    continue;
                }
                if (!visited[nx][ny][current.k] && map[nx][ny] == 0) {
                    visited[nx][ny][current.k] = true;
                    queue.offer(new Node(nx, ny, current.k, current.distance + 1));
                }
            }
        }
        return -1;
    }
}