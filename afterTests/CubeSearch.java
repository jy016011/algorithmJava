package afterTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class CubeSearch {
    private static class Node {
        int x, y, z, count, t;

        public Node(int x, int y, int z, int count, int t) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        int[][][] map = new int[L][N][M];
        int T = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < N; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
        }

        int result = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 0, 0, T));
        boolean isArrived = false;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == N - 1 && cur.y == M - 1 && cur.y == L - 1) {
                result = Math.max(result, cur.count);
                isArrived = true;
            }

            // i + 1
            if (cur.x + 1 < N) {
                if (map[cur.z][cur.x + 1][cur.y] >= 0) {
                    queue.offer(new Node(cur.x + 1, cur.y, cur.z, cur.count + map[cur.z][cur.x + 1][cur.y], cur.t));
                } else if (map[cur.z][cur.x + 1][cur.y] < 0 && cur.t > 0) {
                    queue.offer(new Node(cur.x + 1, cur.y, cur.z, cur.count, cur.t - 1));
                }
            }

            // j + 1
            if (cur.y + 1 < M) {
                if (map[cur.z][cur.x][cur.y + 1] >= 0) {
                    queue.offer(new Node(cur.x, cur.y + 1, cur.z, cur.count + map[cur.z][cur.x][cur.y + 1], cur.t));
                } else if (map[cur.z][cur.x][cur.y + 1] < 0 && cur.t > 0) {
                    queue.offer(new Node(cur.x, cur.y + 1, cur.z, cur.count, cur.t - 1));
                }
            }

            // k + 1
            if (cur.z + 1 < L) {
                if (map[cur.z + 1][cur.x][cur.y] >= 0) {
                    queue.offer(new Node(cur.x, cur.y, cur.z + 1, cur.count + map[cur.z + 1][cur.x][cur.y], cur.t));
                } else if (map[cur.z + 1][cur.x][cur.y] < 0 && cur.t > 0) {
                    queue.offer(new Node(cur.x, cur.y, cur.z + 1, cur.count, cur.t - 1));
                }
            }
        }
        if (isArrived) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
