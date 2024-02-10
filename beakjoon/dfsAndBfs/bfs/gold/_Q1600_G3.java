package beakjoon.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q1600_G3 {
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

    private static int K, W, H;
    private static int[][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        W = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int row = 0; row < H; row++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int col = 0; col < W; col++) {
                map[row][col] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int[] horseDx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] horseDy = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] monkeyDx = {-1, 1, 0, 0};
        int[] monkeyDy = {0, 0, -1, 1};
        visited[0][0][K] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, K, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.x == H - 1 && current.y == W - 1) {
                return current.distance;
            }
            for (int i = 0; i < 4; i++) {
                int nx = current.x + monkeyDx[i];
                int ny = current.y + monkeyDy[i];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                    continue;
                }
                if (map[nx][ny] == 0 && !visited[nx][ny][current.k]) {
                    visited[nx][ny][current.k] = true;
                    queue.offer(new Node(nx, ny, current.k, current.distance + 1));
                }
            }
            if (current.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = current.x + horseDx[i];
                    int ny = current.y + horseDy[i];
                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                        continue;
                    }
                    if (map[nx][ny] == 0 && !visited[nx][ny][current.k - 1]) {
                        visited[nx][ny][current.k - 1] = true;
                        queue.offer(new Node(nx, ny, current.k - 1, current.distance + 1));
                    }
                }
            }
        }
        return -1;
    }
}
