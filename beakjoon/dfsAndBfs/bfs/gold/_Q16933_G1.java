package beakjoon.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q16933_G1 {
    private static class Node {
        int x;
        int y;
        int k;
        int distance;
        boolean isNight;

        public Node(int x, int y, int k, int distance, boolean isNight) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.distance = distance;
            this.isNight = isNight;
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
        map = new int[N][M];
        K = Integer.parseInt(stringTokenizer.nextToken());
        visited = new boolean[N][M][K + 1];
        for (int row = 0; row < N; row++) {
            String rowString = bufferedReader.readLine();
            for (int col = 0; col < M; col++) {
                map[row][col] = Character.getNumericValue(rowString.charAt(col));
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, K, 1, false));
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
                if (!current.isNight) {
                    if (current.k > 0) {
                        if (!visited[nx][ny][current.k - 1] && map[nx][ny] == 1) {
                            visited[nx][ny][current.k - 1] = true;
                            queue.offer(new Node(nx, ny, current.k - 1, current.distance + 1, true));
                        }
                        if (!visited[nx][ny][current.k] && map[nx][ny] == 0) {
                            visited[nx][ny][current.k] = true;
                            queue.offer(new Node(nx, ny, current.k, current.distance + 1, true));
                        }
                        continue;
                    }
                    if (!visited[nx][ny][current.k] && map[nx][ny] == 0) {
                        visited[nx][ny][current.k] = true;
                        queue.offer(new Node(nx, ny, current.k, current.distance + 1, true));
                    }
                } else {
                    if (current.k > 0) {
                        if (!visited[nx][ny][current.k - 1] && map[nx][ny] == 1) {
                            queue.offer(new Node(current.x, current.y, current.k, current.distance + 1, false));
                        }
                        if (!visited[nx][ny][current.k] && map[nx][ny] == 0) {
                            visited[nx][ny][current.k] = true;
                            queue.offer(new Node(nx, ny, current.k, current.distance + 1, false));
                        }
                        continue;
                    }
                    if (!visited[nx][ny][current.k] && map[nx][ny] == 0) {
                        visited[nx][ny][current.k] = true;
                        queue.offer(new Node(nx, ny, current.k, current.distance + 1, false));
                    }
                }
            }
        }

        return -1;
    }
}
