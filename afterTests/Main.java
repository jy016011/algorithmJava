package afterTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static int[] dx = {1, 1, 1, 1, 1};
    private static int[] dy = {0, 1, -1, 2, -2};
    private static int N;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N + 2][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            map[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            map[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            map[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int min = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 1, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            if (x == N + 1) {
                System.out.println(count);
                min = Math.min(min, count);
                if (count == 2) {
                    System.out.println(x + " " + y);
                }
                continue;
            }
            for (int i = 0; i < 5; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N + 2 || ny >= 3) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    if (i == 0) {
//                        System.out.println("밑 " + count);
                        queue.offer(new Node(nx, ny, count));
                    } else {
//                        System.out.println("옆 " + count);
                        queue.offer(new Node(nx, ny, count + 1));
                    }
                }
            }
        }
        return min;
    }
}
